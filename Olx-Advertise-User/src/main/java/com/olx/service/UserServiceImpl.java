package com.olx.service;

import org.springframework.stereotype.Service;

import com.olx.dto.User;

@Service
public class UserServiceImpl implements UserService {

	@Override
	public User login(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean logout(String authToken) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public User createUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean getUser(String authToken) {
		// TODO Auto-generated method stub
		return false;
	}

}
