package ru.gubern.twitterbe.user.domain;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.OffsetDateTime;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
public class UserBirthDate {

    private String value;

    public UserBirthDate(String birthdate) {
        this.value = birthdate;
    }
}
