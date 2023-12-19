package model.service;

import java.sql.SQLException;
import java.util.List;

import model.CommunityDto;
import model.UserDto;
import model.dao.CommunityDAO;
import model.dao.UserDAO;
import model.dao.PetDAO;

/**
 * 사용자 관리 API를 사용하는 개발자들이 직접 접근하게 되는 클래스.
 * UserDAO를 이용하여 데이터베이스에 데이터 조작 작업이 가능하도록 하며,
 * 데이터베이스의 데이터들을 이용하여 비지니스 로직을 수행하는 역할을 한다.
 * 비지니스 로직이 복잡한 경우에는 비지니스 로직만을 전담하는 클래스를 
 * 별도로 둘 수 있다.
 */
public class UserManager {
	private static UserManager userMan = new UserManager();
	private UserDAO userDAO;
	private PetDAO petDAO;
	private CommunityDAO commDAO;
	private UserAnalysis userAanlysis;

	private UserManager() {
		try {
			userDAO = new UserDAO();
			petDAO = new PetDAO();
			commDAO = new CommunityDAO();
			userAanlysis = new UserAnalysis(userDAO);
		} catch (Exception e) {
			e.printStackTrace();
		}			
	}
	
	public static UserManager getInstance() {
		return userMan;
	}
	
	public int create(UserDto user) throws SQLException, ExistingUserException, ExistingPetException {
		if (userDAO.existingUser(user.getUserId()) == true) {
			throw new ExistingUserException(user.getUserId() +"는 존재하는 아이디입니다.");
		}
		if (petDAO.existingPet(user.getPetId()) == true) {
			throw new ExistingPetException(user.getPetId() +"는 존재하는 아이디 입니다.");
		}
		return userDAO.create(user);
	}

	public int update(UserDto user) throws SQLException, UserNotFoundException {
		int oldComm_num = findUser(user.getUserId()).getComm_num();
		if (user.getComm_num() != oldComm_num) { 	// 소속 커뮤티니가 변경됨
			CommunityDto comm = commDAO.findCommunity(oldComm_num);  // 기존 소속 커뮤니티
			if (comm != null && user.getUserId().equals(comm.getComm_leader())) {
				// 사용자가 기존 소속 커뮤니티의 회장인 경우 -> 그 커뮤니티의 회장을 null로 변경 및 저장
				comm.setComm_leader(null);
				commDAO.updateChair(comm);
			}
		}
		return userDAO.update(user);
	}	

	public int delete(String userId) throws SQLException, UserNotFoundException {
		int comm_num = findUser(userId).getComm_num();
		CommunityDto comm = commDAO.findCommunity(comm_num);  // 소속 커뮤니티
		if (comm != null && userId.equals(comm.getComm_leader())) {
			// 사용자가 소속 커뮤니티의 회장인 경우 -> 그 커뮤니티의 회장을 null로 변경 및 저장
			comm.setComm_leader(null);
			commDAO.updateChair(comm);
		}
		return userDAO.delete(userId);
	}

	public UserDto findUser(String userId)
		throws SQLException, UserNotFoundException {
		UserDto user = userDAO.findUser(userId);
		
		if (user == null) {
			throw new UserNotFoundException(userId + "는 존재하지 않는 아이디입니다.");
		}		
		return user;
	}

	public List<UserDto> findUserList() throws SQLException {
			return userDAO.findUserList();
	}
	
	public List<UserDto> findUserList(int currentPage, int countPerPage)
		throws SQLException {
		return userDAO.findUserList(currentPage, countPerPage);
	}

	public boolean login(String userId, String userPw)
		throws SQLException, UserNotFoundException, PasswordMismatchException {
		UserDto user = userDAO.findUser(userId);

		if (!user.matchUserPw(userPw)) {
			throw new PasswordMismatchException("비밀번호가 일치하지 않습니다.");
		}
		return true;
	}

	public List<UserDto> makeFriends(String userId) throws Exception {
		return userAanlysis.recommendFriends(userId);
	}
	
	public CommunityDto createCommunity(CommunityDto comm) throws SQLException {
		return commDAO.create(comm);		
	}

	public int updateCommunity(CommunityDto comm) throws SQLException {
		return commDAO.update(comm);				
	}
	
	public CommunityDto findCommunity(int comm_num) throws SQLException {
		CommunityDto comm = commDAO.findCommunity(comm_num); 
		
		List<UserDto> memberList = userDAO.findUsersInCommunity(comm_num);
		comm.setMemberList(memberList);
		
		int numOfMembers = userDAO.getNumberOfUsersInCommunity(comm_num);
		comm.setNumOfMembers(numOfMembers);
		return comm;
	}
	
	public List<CommunityDto> findCommunityList() throws SQLException {
		return commDAO.findCommunityList();
	}
	
	public List<UserDto> findCommunityMembers(int comm_num) throws SQLException {
		return userDAO.findUsersInCommunity(comm_num);
	}

	public UserDAO getUserDAO() {
		return this.userDAO;
	}
}
