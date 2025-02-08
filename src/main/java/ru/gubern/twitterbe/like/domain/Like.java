package ru.gubern.twitterbe.like.domain;

import jakarta.persistence.*;
import lombok.Data;
import ru.gubern.twitterbe.twit.domain.Twit;
import ru.gubern.twitterbe.user.domain.User;

@Entity
@Data
@Table(name = "likes")
public class Like {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private LikeId id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Twit twit;
}
