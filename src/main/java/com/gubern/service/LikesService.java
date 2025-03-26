package com.gubern.service;

import java.util.List;

import com.gubern.exception.LikeException;
import com.gubern.exception.TwitException;
import com.gubern.exception.UserException;
import com.gubern.model.Like;
import com.gubern.model.User;

public interface LikesService {
	
	public Like likeTwit(Long twitId, User user) throws UserException, TwitException;
	
	public Like unlikeTwit(Long twitId, User user) throws UserException, TwitException, LikeException;
	
	public List<Like> getAllLikes(Long twitId) throws TwitException;

}
