package ru.gubern.twitterbe.twit.usecases;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.User;
import ru.gubern.twitterbe.twit.domain.Twit;
import ru.gubern.twitterbe.twit.domain.TwitId;
import ru.gubern.twitterbe.user.domain.UserId;

import java.util.List;

public interface TwitRepository extends JpaRepository<Twit, TwitId> {

    List<Twit> findALlByTwitIsTrueOrderByCreatedAtDesc();

    List<Twit> findAllByRetwitUserContainsOrUser_idAndIsTwitTrueOrderByCreatedAtDesc (User user, UserId userId);


}
