package ru.gubern.twitterbe.user.domain;

import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@Embeddable
public class UserId implements Serializable {

    private UUID value;

    public UserId(UUID uuid) {
        this.value = uuid;
    }

    public UserId() {

    }

    public static UserId of() {
        return new UserId();
    }
}
