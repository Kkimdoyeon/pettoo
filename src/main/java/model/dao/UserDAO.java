package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.UserDto;

/**
 * 사용자 관리를 위해 데이터베이스 작업을 전담하는 DAO 클래스
 * USERINFO 테이블에 사용자 정보를 추가, 수정, 삭제, 검색 수행 
 */
public class UserDAO {
	private JDBCUtil jdbcUtil = null;
	
	public UserDAO() {			
		jdbcUtil = new JDBCUtil();	// JDBCUtil 객체 생성
	}
		
	/**
	 * userinfo 테이블에 새로운 사용자 추가
	 */
	public int create(UserDto user) throws SQLException {
		String sql = "INSERT INTO USERINFO VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";		
		Object[] param = new Object[] {user.getUserId(), user.getuserPw(), user.getUserName(), 
									user.getAddress(), user.getGender(), user.getEmail(), 
									user.getPhoneNumber(), user.getUserBirth(), user.getPetId(),
									(user.getComm_num()!=0) ? user.getComm_num() : null };				
		jdbcUtil.setSqlAndParameters(sql, param);	// JDBCUtil 에 insert문과 매개 변수 설정
						
		try {				
			int result = jdbcUtil.executeUpdate();	// insert 문 실행
			return result;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {		
			jdbcUtil.commit();
			jdbcUtil.close();	// resource 반환
		}		
		return 0;			
	}

	/**
	 * 기존의 사용자 정보를 수정.
	 */
	public int update(UserDto user) throws SQLException {
		String sql = "UPDATE USERINFO "
					+ "SET userPw=?, userName=?, address=?, gender=?, email=?, phoneNumber=?, userBirth=?, petId=?, comm_num=? "
					+ "WHERE userid=?";
		Object[] param = new Object[] {user.getuserPw(), user.getUserName(), user.getAddress(), user.getGender(),
					user.getEmail(), user.getPhoneNumber(), user.getUserBirth(), user.getPetId(), 
					(user.getComm_num()!=0) ? user.getComm_num() : null, user.getUserId()};				
		jdbcUtil.setSqlAndParameters(sql, param);	// JDBCUtil에 update문과 매개 변수 설정
			
		try {				
			int result = jdbcUtil.executeUpdate();	// update 문 실행
			return result;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close();	// resource 반환
		}		
		return 0;
	}

	/**
	 * 사용자 ID에 해당하는 사용자를 삭제.
	 */
	public int delete(String userId) throws SQLException {
		String sql = "DELETE FROM USERINFO WHERE userid=?";		
		jdbcUtil.setSqlAndParameters(sql, new Object[] {userId});	// JDBCUtil에 delete문과 매개 변수 설정

		try {				
			int result = jdbcUtil.executeUpdate();	// delete 문 실행
			return result;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close();	// resource 반환
		}		
		return 0;
	}

	/**
	 * 주어진 사용자 ID에 해당하는 사용자 정보를 데이터베이스에서 찾아 Userinfo 도메인 클래스에 
	 * 저장하여 반환. => id로 사용자 검색
	 */
	public UserDto findUser(String userId) throws SQLException {
        String sql = "SELECT userPw, userName, address, gender, email, phoneNumber, userBirth, petId, comm_num "
        			+ "FROM userinfo "
        			+ "WHERE userid=? ";              
		jdbcUtil.setSqlAndParameters(sql, new Object[] {userId});	// JDBCUtil에 query문과 매개 변수 설정

		try {
			ResultSet rs = jdbcUtil.executeQuery();		// query 실행
			if (rs.next()) {						// 유저 정보 발견
				UserDto user = new UserDto(		// User 객체를 생성하여 학생 정보를 저장
						rs.getString("userID"),
						rs.getString("userPw"),
						rs.getString("userName"),
						rs.getString("address"),
						rs.getString("gender"),
						rs.getString("email"),
						rs.getString("phoneNumber"),
						rs.getString("userBirth"),
						rs.getString("petID"),
						rs.getInt("comm_num"));
				return user;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource 반환
		}
		return null;
	}

	/**
	 * 전체 사용자 정보를 검색하여 List에 저장 및 반환
	 */
	public List<UserDto> findUserList() throws SQLException {
        String sql = "SELECT userId, userPw, userName, address, gender, email, phoneNumber, userBirth, petId, NVL(comm_num, 0) " 
        		   + "FROM userinfo "
        		   + "ORDER BY userId";
		jdbcUtil.setSqlAndParameters(sql, null);		// JDBCUtil에 query문 설정
					
		try {
			ResultSet rs = jdbcUtil.executeQuery();			// query 실행			
			List<UserDto> userList = new ArrayList<UserDto>();	// User들의 리스트 생성
			while (rs.next()) {
				UserDto user = new UserDto( 		// User 객체를 생성하여 현재 행의 정보를 저장
						rs.getString("userID"),
						rs.getString("userPw"),
						rs.getString("userName"),
						rs.getString("address"),
						rs.getString("gender"),
						rs.getString("email"),
						rs.getString("phoneNumber"),
						rs.getString("userBirth"),
						rs.getString("petID"),
						rs.getInt("comm_num"));
				userList.add(user);				// List에 User 객체 저장
			}		
			return userList;					
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource 반환
		}
		return null;
	}
	
	/**
	 * 전체 사용자 정보를 검색한 후 현재 페이지와 페이지당 출력할 사용자 수를 이용하여
	 * 해당하는 사용자 정보만을 List에 저장하여 반환.
	 */
	public List<UserDto> findUserList(int currentPage, int countPerPage) throws SQLException {
		String sql = "SELECT userId, userPw, userName, address, gender, email, phoneNumber, userBirth, petId, NVL(comm_num, 0) " 
     		   		+ "FROM userinfo "
     		   		+ "ORDER BY userId";
		jdbcUtil.setSqlAndParameters(sql, null,					// JDBCUtil에 query문 설정
				ResultSet.TYPE_SCROLL_INSENSITIVE,				// cursor scroll 가능
				ResultSet.CONCUR_READ_ONLY);						
		
		try {
			ResultSet rs = jdbcUtil.executeQuery();				// query 실행			
			int start = ((currentPage-1) * countPerPage) + 1;	// 출력을 시작할 행 번호 계산
			if ((start >= 0) && rs.absolute(start)) {			// 커서를 시작 행으로 이동
				List<UserDto> userList = new ArrayList<UserDto>();	// User들의 리스트 생성
				do {
					UserDto user = new UserDto(			// User 객체를 생성하여 현재 행의 정보를 저장
							rs.getString("userID"),
							rs.getString("userPw"),
							rs.getString("userName"),
							rs.getString("address"),
							rs.getString("gender"),
							rs.getString("email"),
							rs.getString("phoneNumber"),
							rs.getString("userBirth"),
							rs.getString("petID"),
							rs.getInt("comm_num"));
					userList.add(user);							// 리스트에 User 객체 저장
				} while ((rs.next()) && (--countPerPage > 0));		
				return userList;							
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource 반환
		}
		return null;
	}

	/**
	 * 특정 커뮤니티에 속한 사용자들을 검색하여 List에 저장 및 반환
	 */
	public List<UserDto> findUsersInCommunity(int comm_num) throws SQLException {
        String sql = "SELECT userId, userName, gender, email, petId "
        			+ "FROM UserInfo "
     				+ "WHERE comm_num = ?";                         
		jdbcUtil.setSqlAndParameters(sql, new Object[] {comm_num});	// JDBCUtil에 query문과 매개 변수 설정
		
		try {
			ResultSet rs = jdbcUtil.executeQuery();		// query 실행
			List<UserDto> memList = new ArrayList<UserDto>();	// member들의 리스트 생성
			while (rs.next()) {
				UserDto member = new UserDto(			// User 객체를 생성하여 현재 행의 정보를 저장
						rs.getString("userID"),
						rs.getString("userName"),
						rs.getString("gender"),
						rs.getString("email"),
						rs.getString("petID"));
				memList.add(member);			// List에 Community 객체 저장
			}		
			return memList;					
				
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource 반환
		}
		return null;
	}
	
	/**
	 * 특정 커뮤니티에 속한 사용자들의 수를 count하여 반환
	 */
	public int getNumberOfUsersInCommunity(int comm_num) {
		String sql = "SELECT COUNT(userId) FROM userinfo "
     				+ "WHERE comm_num = ?";              
		jdbcUtil.setSqlAndParameters(sql, new Object[] {comm_num});	// JDBCUtil에 query문과 매개 변수 설정
		
		try {
			ResultSet rs = jdbcUtil.executeQuery();		// query 실행
			rs.next();										
			return rs.getInt(1);			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource 반환
		}
		return 0;
	}
	
	/**
	 * 주어진 사용자 ID에 해당하는 사용자가 존재하는지 검사 
	 */
	public boolean existingUser(String userId) throws SQLException {
		String sql = "SELECT count(*) FROM USERINFO WHERE userid=?";      
		jdbcUtil.setSqlAndParameters(sql, new Object[] {userId});	// JDBCUtil에 query문과 매개 변수 설정

		try {
			ResultSet rs = jdbcUtil.executeQuery();		// query 실행
			if (rs.next()) {
				int count = rs.getInt(1);
				return (count == 1 ? true : false);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource 반환
		}
		return false;
	}

}
