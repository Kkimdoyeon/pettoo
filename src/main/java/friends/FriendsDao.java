package friends;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import util.JDBCUtil;


public class FriendsDao {
	private JDBCUtil jdbcUtil = null;
	
	public FriendsDao() {
		jdbcUtil = new JDBCUtil();
	}
	
	
	//주어진 userID에 해당하는 유저 정보를 검색 후 UserInfo DTO를 생성 및 저장하고 반환
	public UserInfo findUser(int userID) {
		StringBuilder query = new StringBuilder();
		query.append("SELECT userName, address, gender, email, phoneNumber ");
		query.append("FROM USERINFO ");
		query.append("WHERE userID = ? ");
		
		jdbcUtil.setSqlAndParameters(query.toString(), new Object[]{userID});
		
		try {
			ResultSet rs = jdbcUtil.executeQuery();
			
			if (rs.next()) {
				return new UserInfo(
						userID,
						rs.getString("userName"),
						rs.getString("address"),
						rs.getString("gender"),
						rs.getString("email"),
						rs.getString("phoneNumber"),
						rs.getString("userBirth"),
						rs.getInt("petID"));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		return null;
	}
	
	//유저 이름으로 검색 (검색 기능에 활용 - 유저 이름 , 성별, 주소, 이메일만 표시)
	public UserInfo findUserByName(String userName) {
		StringBuilder query = new StringBuilder();
		query.append("SELECT userName, gender, address, email ");
		query.append("FROM USERINFO ");
		query.append("WHERE userName = ? ");
		
		jdbcUtil.setSqlAndParameters(query.toString(), new Object[]{userName});
		
		try {
			ResultSet rs = jdbcUtil.executeQuery();
			
			if (rs.next()) {
				UserInfo user = new UserInfo();
				user.setUserName(rs.getString("userName"));
				user.setGender(rs.getString("gender"));
				user.setAddress(rs.getString("address"));
				user.setEmail(rs.getString("email"));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		return null;
	}


}
