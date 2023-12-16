package model.dao;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

import model.Diary.*;
import model.Diary;
import model.dao.JDBCUtil;

public class DiaryDAO {
	private JDBCUtil jdbcUtil = null;
	
	public DiaryDAO() {			
		jdbcUtil = new JDBCUtil();
	}
	
	//Diary 기본 정보를 포함하는 query 문
	private static String query = "SELECT DIARY.D_TITLE, " +
	         "DIARY.PHOTO, " +
	         "DIARY.DATE, " +
	         "DIARY.WALKINGTIME, " +
	         "DIARY.D_TEXT, " +
	         "DIARY.USERID, " +
	         "DIARY.PLACE ";
	
	//해당 userId의 diary 를 리스트로 반환
	public List<Diary> getDiaryListByUserId(int userId) {
		String allQuery = query + ", " + "FROM Diary WHERE userId = ?";
			
		Object[] param = new Object[] {userId};
		jdbcUtil.setSqlAndParameters(allQuery, param);
		
		try { 
			ResultSet rs = jdbcUtil.executeQuery();		
			List<Diary> list = new ArrayList<Diary>();
			while (rs.next()) {	
				Diary dto = new Diary();		// 하나의 StudentDTO 객체 생성 후 정보 설정
				dto.setPhoto(rs.getBytes("PHOTO"));
				dto.setDiaryTit(rs.getString("D_TITLE"));
				dto.setDate(rs.getDate("DATE"));
				dto.setWalkingTime(rs.getInt("WALKINGTIME"));
				dto.setDiaryText(rs.getString("D_TEXT"));
				dto.setUserId(rs.getString("USERID"));
				dto.setPlace(rs.getString("PLACE"));
				list.add(dto);		// list 객체에 정보를 설정한 StudentDTO 객체 저장
			}
			return list;		// 학생정보를 저장한 dto 들의 목록을 반환
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();	// ResultSet, PreparedStatement, Connection 반환
		}		
		return null;	
	}

	//Diary 객체에 담겨있는 일기장 정보를 기반으로 일기장 정보를 Diary table에 삽입하는 메소드
	public int insertDiary(Diary dto) {
		int result = 0;
		String insertQuery = "INSERT INTO DIARY (D_TITLE, PHOTO, DATE, WALKINGTIME, D_TEXT, USERID, PLACE) " +
				 "VALUES (?, ?, ?, ?, ?, ?, ?) ";
		Object[] param = new Object[] {dto.getPlace(), dto.getWalkingTime(), 
				dto.getPhoto(), dto.getDiaryTit(), dto.getDate(), dto.getDiaryText(), dto.getUserId()};
		jdbcUtil.setSqlAndParameters(insertQuery, param);
		
		try {				
			result = jdbcUtil.executeUpdate();		// insert 문 실행
			System.out.println(dto.getUserId() + "님의 "+ dto.getDate() + "의 일기가 삽입되었습니다.");
		} catch (SQLException ex) {
			System.out.println("입력오류 발생!!!");
			if (ex.getErrorCode() == 1)
				System.out.println("동일한 학생정보가 이미 존재합니다."); 
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {		
			jdbcUtil.commit();
			jdbcUtil.close();		// ResultSet, PreparedStatement, Connection 반환
		}		
		return result;
	}
}
