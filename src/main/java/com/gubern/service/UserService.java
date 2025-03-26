package com.gubern.service;

import java.util.List;

import com.gubern.exception.UserException;
import com.gubern.model.User;

public interface UserService {

	public User findUserById(Long userId) throws UserException;
	
	public User findUserProfileByJwt(String jwt) throws UserException;
	
	public User updateUser(Long userId,User user) throws UserException;
	
	public User followUser(Long userId,User user) throws UserException;
	
	public List<User> searchUser(String query);
	
}
