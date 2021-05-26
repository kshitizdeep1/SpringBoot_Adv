package com.olx.service;

import com.olx.dto.User;

public interface UserService {

	User login(User user);

	boolean logout(String authToken);

	User createUser(User user);

	boolean getUser(String authToken);

}
