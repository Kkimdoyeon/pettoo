package model.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import model.UserDto;
import model.dao.UserDAO;

// an example business class
public class UserAnalysis {
	private UserDAO dao;
	
	public UserAnalysis() {}
	
	public UserAnalysis(UserDAO dao) {
		super();
		this.dao = dao;
	}

	// an example business method
	public List<UserDto> recommendFriends(String userId) throws Exception {
		UserDto thisuser = dao.findUser(userId);
		if (thisuser == null) {
			throw new Exception("존재하지 않는 아이디입니다.");
		}
		int m1 = userId.indexOf('@');
		if (m1 == -1) return null;
		String mserver1 = thisuser.getEmail().substring(m1);
		
		List<UserDto> friends = new ArrayList<UserDto>();
		
		List<UserDto> userList = dao.findUserList(1, 10000);
		Iterator<UserDto> userIter = userList.iterator();		
		while (userIter.hasNext()) {
			UserDto user = (UserDto)userIter.next();
			
			if (user.getUserId().equals(userId)) continue;
			int m2 = user.getEmail().indexOf('@');
			if (m2 == -1) continue;
			String mserver2 = user.getEmail().substring(m2);

			if (mserver1.equals(mserver2)) 
				friends.add(user);		
		}
		return friends;
	}

}
