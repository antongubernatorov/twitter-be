package ru.gubern.twitterbe.like.usecases;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.gubern.twitterbe.like.domain.Like;
import ru.gubern.twitterbe.like.domain.LikeId;
import ru.gubern.twitterbe.twit.domain.TwitId;
import ru.gubern.twitterbe.user.domain.UserId;

import java.util.List;

public interface LikeRepository extends JpaRepository<Like, LikeId> {

    @Query("select l from Like l where l.user.id = :userId and l.twit.id = :twinId")
    Like isLikeExist(@Param("userId") UserId userId, @Param("twinId") TwitId twinId);

    @Query("select l from Like l where l.twit.id = : twitId")
    List<Like> findByTwitId(@Param("twitId") TwitId twinId);
}
