package ru.gubern.twitterbe.twit.domain;

import jakarta.persistence.*;
import lombok.Data;
import ru.gubern.twitterbe.like.domain.Like;
import ru.gubern.twitterbe.user.domain.User;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Twit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private TwitId id;

    @ManyToOne
    private User user;

    private TwitContent content;

    private TwitImage image;

    private TwitVideo video;

    @OneToMany(mappedBy = "twit", cascade = CascadeType.ALL)
    private List<Like> likes = new ArrayList<>();

    @OneToMany
    private List<Twit> replyTwits = new ArrayList<>();

    @ManyToMany
    private List<User> retwitUser = new ArrayList<>();

    @ManyToOne
    private Twit replyFor;

    private OffsetDateTime createdAt;

    private boolean isReply;

    private boolean isTwit;

}
