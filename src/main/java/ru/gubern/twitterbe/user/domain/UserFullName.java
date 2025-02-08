package ru.gubern.twitterbe.user.domain;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Embeddable
@RequiredArgsConstructor
@Getter
public class UserFullName {

    private String firstName;

    private String lastName;

    private String middleName;

    private String fullName;

    public UserFullName(String fullName) {
        this.fullName = fullName;
    }
}
