package ru.gubern.twitterbe.user.presentation;

import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.gubern.twitterbe.user.application.UserRepositoryImpl;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomUserDetailServiceImplementation implements UserDetailsService {

    private final UserRepositoryImpl userRepository;

    public CustomUserDetailServiceImplementation(UserRepositoryImpl userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user = userRepository.findByEmail(username);
        if (user == null || user.getLogin_with_google()) {
            throw new UsernameNotFoundException("Username not found with this email " + username);
        }
        List<GrantedAuthority> authorities = new ArrayList<>();
        return User.builder()
                .username(user.getEmail().getValue())
                .password(user.getPassword().getValue())
                .authorities(authorities)
                .build();
    }
}
