package ru.gubern.twitterbe.user.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import ru.gubern.twitterbe.like.domain.Like;
import ru.gubern.twitterbe.twit.domain.Twit;
import ru.gubern.twitterbe.verification.domain.Verification;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@Getter
@ToString(onlyExplicitlyIncluded = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UserId id;

    private UserFullName fullName;

    /*private CityId location;*/

    private UserWebsite website;

    private UserBirthDate birthDate;

    private UserEmail email;

    private UserPassword password;

    private UserMobile mobile;

    private UserImage image;

    private UserBackgroundImage backgroundImage;

    private UserBio bio;

    private Boolean req_user;

    private Boolean login_with_google;

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Twit> twitList = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Like> likeList = new ArrayList<>();

    @Embedded
    private Verification verification;

    @JsonIgnore
    @ManyToMany
    private List<User> followers = new ArrayList<>();

    @JsonIgnore
    @ManyToMany
    private List<User> following = new ArrayList<>();

    private void of(@NonNull UserFullName userFullName,
                    @NonNull UserWebsite userWebsite,
                    @NonNull UserBirthDate birthDate,
                    @NonNull UserEmail email,
                    @NonNull UserPassword password,
                    @NonNull UserMobile mobile,
                    UserImage userImage) {
        this.id = new UserId(UUID.randomUUID());
        this.fullName = userFullName;
        this.website = userWebsite;
        this.birthDate = birthDate;
        this.email = email;
        this.password = password;
        this.mobile = mobile;
        this.image = userImage;
    }
}
