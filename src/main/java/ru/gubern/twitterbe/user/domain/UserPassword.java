package ru.gubern.twitterbe.user.domain;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
public class UserPassword {

    private String value;

    public UserPassword(String encode) {
        this.value = encode;
    }
}
