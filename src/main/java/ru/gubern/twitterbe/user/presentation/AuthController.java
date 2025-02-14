package ru.gubern.twitterbe.user.presentation;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import ru.gubern.twitterbe.config.JwtProvider;
import ru.gubern.twitterbe.exceptions.UserException;
import ru.gubern.twitterbe.user.application.UserRepositoryImpl;
import ru.gubern.twitterbe.user.domain.*;
import ru.gubern.twitterbe.verification.domain.Verification;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private UserRepositoryImpl userRepository;
    private PasswordEncoder passwordEncoder;

    private JwtProvider jwtProvider;
    private CustomUserDetailServiceImplementation detailService;

    public AuthController(UserRepositoryImpl userRepository, PasswordEncoder passwordEncoder, JwtProvider jwtProvider, CustomUserDetailServiceImplementation detailService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtProvider = jwtProvider;
        this.detailService = detailService;
    }

    @PostMapping("/signup")
    public ResponseEntity<AuthResponse> createUserHandler(@RequestBody User user) throws UserException {
        String email = user.getEmail().getValue();
        String password = user.getPassword().getValue();
        String fullName = user.getFullName().getFullName();
        String birthDate = user.getBirthDate().toString();

        User isEmailExist = userRepository.findByEmail(email);

        if (isEmailExist != null) {
            throw new UserException("Email is already user with another account");
        }

        User createdUser = new User();
        createdUser.setEmail(new UserEmail(email));
        createdUser.setFullName(new UserFullName(fullName));
        createdUser.setPassword(new UserPassword(passwordEncoder.encode(password)));
        createdUser.setBirthDate(new UserBirthDate(birthDate));
        createdUser.setVerification(new Verification());

        User savedUser = userRepository.save(createdUser);

        Authentication authentication = new UsernamePasswordAuthenticationToken(email, password);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = jwtProvider.generateToken(authentication);
        AuthResponse res = new AuthResponse(token, true);

        return new ResponseEntity<AuthResponse>(res, HttpStatus.CREATED);
    }

    @PostMapping("/signin")
    public ResponseEntity<AuthResponse> signIn(@RequestBody User user) {
        String username = user.getEmail().getValue();
        String password = user.getPassword().getValue();

        Authentication authentication = authenticate(username, password);
        String token = jwtProvider.generateToken(authentication);
        AuthResponse res = new AuthResponse(token, true);
        return new ResponseEntity<>(res, HttpStatus.ACCEPTED);
    }

    private Authentication authenticate(String username, String password) {
        UserDetails userDetails = detailService.loadUserByUsername(username);

        if (userDetails == null) {
            throw new BadCredentialsException("Invalid username...");
        }
        if (passwordEncoder.matches(password, userDetails.getPassword())) {
            throw new BadCredentialsException("Invalid username or password");
        }
        return new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
    }
}
