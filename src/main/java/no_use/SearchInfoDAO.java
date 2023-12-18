package no_use;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class SearchInfoDAO {
	
	public SearchInfoDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}
	}
	
	private static Connection getConnection() {
		String url = "jdbc:oracle:thin:@dblab.dongduk.ac.kr:1521/orclpdb";
		String user = "dbp230106";
		String passwd = "120922";
		
		//DBMS와의 연결 생성
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, user, passwd);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	
	//유저 id로 유저 정보 모두 출력
	public static void printUserInfo(String userId) {
		Connection conn = null;
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		
		StringBuilder query = new StringBuilder();
		query.append("SELECT userId, userPw, userName, address, gender, email, phoneNumber, userBirth, petId, comm_num ");
		query.append("FROM USERINFO ");
		query.append("WHERE userId = ? ");
		
		try {
			conn = getConnection();
			pStmt = conn.prepareStatement(query.toString());
			pStmt.setString(1, userId);
			rs = pStmt.executeQuery();
			
			while (rs.next()) {
				String userPw = rs.getString("userPw");
				String userName = rs.getString("userName");
				String address = rs.getString("address");
				String gender = rs.getString("gender");
				String email = rs.getString("email");
				String phone = rs.getString("phoneNumber");
				String birth = rs.getString("userBirth");
				String petId = rs.getString("petId");
				int commNum = rs.getInt("comm_num");
				
				System.out.println("아이디: "+ userId);
				System.out.println("비밀번호: "+ userPw);
				System.out.println("이름: "+ userName);
				System.out.println("성별: "+ gender);
				System.out.println("생년월일: "+ birth);
				System.out.println("이메일: "+ email);
				System.out.println("전화번호: "+ phone);
				System.out.println("주소: "+ address);
				System.out.println("반려동물: "+ petId);
				System.out.println("커뮤니티: "+ commNum);
			}
			System.out.println();
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException ex) { ex.printStackTrace(); }
			if (pStmt != null)
				try {
					pStmt.close();
				} catch (SQLException ex) { ex.printStackTrace(); }
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException ex) { ex.printStackTrace(); }
		}
	}
	
	//유저 id로 검색 -> 이름, 펫 아이디, 이메일만 출력
	public static void searchUserInfo(String userId) {
		Connection conn = null;
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		
		StringBuilder query = new StringBuilder();
		query.append("SELECT userName, email, petId ");
		query.append("FROM USERINFO ");
		query.append("WHERE userId = ? ");
		
		try {
			conn = getConnection();
			pStmt = conn.prepareStatement(query.toString());
			pStmt.setString(1, userId);
			rs = pStmt.executeQuery();
			
			System.out.println("이름        반려동물      이메일                    ");
			System.out.println("-----------------------------------------------");
			while (rs.next()) {
				String userName = rs.getString("userName");
				String petId = rs.getString("petId");
				String email = rs.getString("email");
				System.out.printf("%s \t %s \t %s \n", userName, petId, email);
			}
			System.out.println();
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException ex) { ex.printStackTrace(); }
			if (pStmt != null)
				try {
					pStmt.close();
				} catch (SQLException ex) { ex.printStackTrace(); }
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException ex) { ex.printStackTrace(); }
		}
	}
	
	

	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("유저 ID를 입력하시오: ");
		String printUserId = scanner.nextLine();
		printUserInfo(printUserId);
		
		System.out.print("검색할 유저 ID를 입력하시오: ");
		String searchUserId = scanner.next();
		searchUserInfo(searchUserId);
		
		scanner.close();
		
	}

}
