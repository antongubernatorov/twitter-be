package ru.gubern.twitterbe.user.domain;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
public class UserEmail {

    private String value;

    public UserEmail(String email) {
        this.value = email;
    }
}
