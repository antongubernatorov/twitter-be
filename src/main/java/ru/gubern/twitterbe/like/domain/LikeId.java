package ru.gubern.twitterbe.like.domain;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.UUID;

@Embeddable
public class LikeId implements Serializable {

    private UUID value;
}
