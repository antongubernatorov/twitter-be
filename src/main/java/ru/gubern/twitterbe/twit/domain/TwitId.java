package ru.gubern.twitterbe.twit.domain;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.UUID;

@Embeddable
public class TwitId implements Serializable {

    private UUID id;
}
