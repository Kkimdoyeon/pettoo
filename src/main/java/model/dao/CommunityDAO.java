package model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.CommunityDto;

/**
 * 사용자 관리를 위해 데이터베이스 작업을 전담하는 DAO 클래스
 * Community 테이블에서 커뮤니티 정보를 추가, 수정, 삭제, 검색 수행 
 */
public class CommunityDAO {
	private JDBCUtil jdbcUtil = null;
	public CommunityDAO() {			
		jdbcUtil = new JDBCUtil();	// JDBCUtil 객체 생성
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}
	}
	
	
	
	/**
	 * 커뮤니티 테이블에 새로운 행 생성 (PK 값은 Sequence를 이용하여 자동 생성)
	 */
	public CommunityDto create(CommunityDto comm) throws SQLException {
		String sql = "INSERT INTO Community VALUES (?, ?, ?, ?, ?, ?)";		
		Object[] param = new Object[] {
				comm.getComm_num(), 
				comm.getComm_title(),
				comm.getComm_text(), 
				comm.getComm_date(), 
				comm.getComm_memberLimit(), 
				comm.getComm_leader()};				
		jdbcUtil.setSqlAndParameters(sql, param);	// JDBCUtil 에 insert문과 매개 변수 설정/
						
		String key[] = {"comm_num"};	// PK 컬럼의 이름     
		try {    
			jdbcUtil.executeUpdate(key);  // insert 문 실행
		   	ResultSet rs = jdbcUtil.getGeneratedKeys();
		   	if(rs.next()) {
		   		int generatedKey = rs.getInt(1);   // 생성된 PK 값
		   		comm.setComm_num(generatedKey); 	// id필드에 저장  
		   	}
		   	return comm;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {		
			jdbcUtil.commit();
			jdbcUtil.close();	// resource 반환
		}		
		return null;			
	}

	/**
	 * 기존의 커뮤니티 정보를 수정
	 */
	public int update(CommunityDto comm) throws SQLException {
		String sql = "UPDATE Community "
					+ "SET comm_title=?, comm_text=?, comm_memberlimit=?, comm_leader = ? "
					+ "WHERE comm_num=?";
		
		Object[] param = new Object[] { 
				comm.getComm_title(),
				comm.getComm_text(), 
				comm.getComm_date(), 
				comm.getComm_memberLimit(),
				comm.getComm_num()};					
		jdbcUtil.setSqlAndParameters(sql, param);	// JDBCUtil에 update문과 매개 변수 설정
			
		try {				
			int result = jdbcUtil.executeUpdate();	// update 문 실행
			return result;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		}
		finally {
			jdbcUtil.commit();
			jdbcUtil.close();	// resource 반환
		}		
		return 0;
	}

	/**
	 * 커뮤니티의 회장을 변경  
	 */
	public int updateChair(CommunityDto comm) {
		String sql = "UPDATE Community "
					+ "SET comm_leader= ? "
					+ "WHERE comm_num=?";
		Object[] param = new Object[] {comm.getComm_leader(), comm.getComm_num()};				
		jdbcUtil.setSqlAndParameters(sql, param);	// JDBCUtil에 update문과 매개 변수 설정
			
		try {				
			int result = jdbcUtil.executeUpdate();	// update 문 실행
			return result;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		}
		finally {
			jdbcUtil.commit();
			jdbcUtil.close();	// resource 반환
		}		
		return 0;
	}
	
	/**
	 * 주어진 ID에 해당하는 커뮤니티 정보를 삭제.
	 */
	public int remove(CommunityDto comm) throws SQLException {
		String sql = "DELETE FROM Community WHERE comm_num=?";		
		jdbcUtil.setSqlAndParameters(sql, new Object[] {comm.getComm_num()});	// JDBCUtil에 delete문과 매개 변수 설정

		try {				
			int result = jdbcUtil.executeUpdate();	// delete 문 실행
			return result;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		}
		finally {
			jdbcUtil.commit();
			jdbcUtil.close();	// resource 반환
		}		
		return 0;
	}

	
	
	/**
	 * 주어진  ID에 해당하는 커뮤니티가 존재하는지 검사 
	 */
	public boolean existingCommunity(CommunityDto comm) throws SQLException {
		String sql = "SELECT count(*) FROM Community WHERE comm_num=?";      
		jdbcUtil.setSqlAndParameters(sql, new Object[] {comm.getComm_num()});	// JDBCUtil에 query문과 매개 변수 설정

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
	
	/*
	/**
	 * 주어진  동아리 고유번호 에 해당하는 커뮤니티 정보를 데이터베이스에서 찾아 Community 도메인 클래스에 
	 * 저장하여 반환.
	 
	public CommunityDto findCommunity(CommunityDto comm) throws SQLException {
        String sql = "SELECT Community.comm_title, Community.comm_text, Community.comm_date, Community.comm_memberlimit, Community.comm_leader "
        			+ "FROM Community" //c LEFT OUTER JOIN UserInfo u ON c.comm_leader = u.userId "
        			+ "WHERE comm_num=? ";              
		jdbcUtil.setSqlAndParameters(sql, new Object[] {comm.getComm_num()});	// JDBCUtil에 query문과 매개 변수 설정
		comm = null;
		try {
			ResultSet rs = jdbcUtil.executeQuery();		// query 실행
			if (rs.next()) {						// 학생 정보 발견
				comm = new CommunityDto(		// Community 객체를 생성하여 커뮤니티 정보를 저장
					rs.getInt("comm_num"),
					rs.getString("comm_title"),
					rs.getString("comm_text"),
					rs.getString("comm_date"),
					rs.getInt("comm_memberlimit"),
					rs.getString("comm_leader")
					);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource 반환
		}
		return comm;
	}
	*/

	/**
	 * 전체 커뮤니티 정보를 검색하여 List에 저장 및 반환
	 */
	
	
	/*public List<CommunityDto> findCommunityList() throws SQLException {
        String sql = "SELECT comm_num, comm_title, comm_text"
        		   + "FROM Community c LEFT OUTER JOIN UserInfo u ON c.comm_num = u.comm_num "
        		   + "GROUP BY comm_num, comm_title, comm_text "
        		   + "ORDER BY comm_title";        
		jdbcUtil.setSqlAndParameters(sql, null);		// JDBCUtil에 query문 설정
					
		try {
			ResultSet rs = jdbcUtil.executeQuery();			// query 실행			
			List<CommunityDto> commList = new ArrayList<CommunityDto>();	// Community들의 리스트 생성
			while (rs.next()) {
				CommunityDto comm = new CommunityDto(			// Community 객체를 생성하여 현재 행의 정보를 저장
						rs.getInt("comm_num"),
						rs.getString("comm_title"),
						rs.getString("comm_text"),
						rs.getString("comm_date"),
						rs.getInt("comm_memberlimit"),
						rs.getString("comm_leader"),
								// List에 Community 객체 저장
			}		
			commList.add(comm);
			return commList;					
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource 반환
		}
		return null;
	}*/
}
