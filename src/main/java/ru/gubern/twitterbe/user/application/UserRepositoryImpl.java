package ru.gubern.twitterbe.user.application;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.gubern.twitterbe.user.domain.User;
import ru.gubern.twitterbe.user.domain.UserId;

import java.util.List;

public interface UserRepositoryImpl extends JpaRepository<User, UserId> {

    User findByEmail(String email);

    @Query("select distinct u from User u where u.fullName.fullName like %:query% or u.email.value like %:query%")
    List<User> searchUser(@Param("query") String query);


}
