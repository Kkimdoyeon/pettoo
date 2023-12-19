package model.dao;

import java.sql.*;
import java.util.*;
import model.DiaryDto;
import model.dao.JDBCUtil;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.text.ParseException;

public class DiaryDAO {
	private JDBCUtil jdbcUtil = null;
	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	public DiaryDAO() {			
		jdbcUtil = new JDBCUtil();	// JDBCUtil 객체 생성
	}
			   	
	// diary 테이블에 새로운 다이어리 생성
	public int createDiary(DiaryDto diary) throws SQLException {
		String sql = "INSERT INTO DIARY VALUES (?, ?, ?, ?, ?, ?, ?)";
		Object[] param = new Object[] {diary.getPhoto(), diary.getDiaryTit(), diary.getDiaryDate(),
				diary.getDiaryText(), diary.getUserId(), diary.getWalkingTime(), diary.getPlace()};
		
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
	
	//다이어리 삭제
	public int deleteDiary(String diaryTit) throws SQLException {
		String sql = "DELETE FROM DIARY WHERE diaryTit=?";
		jdbcUtil.setSqlAndParameters(sql, new Object[] {diaryTit}); //JDBCUtil에 delete문과 매개 변수 설정
		
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
	
	//private static String UPDATE = "UPDATE DIARY SET photo=?, diaryDate=?, diaryText=?, userId=?, walkingTime=?, place=? WHERE diaryTit=?";
	//다이어리 수정
	public int updateDiary(DiaryDto diary) throws SQLException {
		  String sql = "UPDATE DIARY " 
		       + "SET photo=?, diaryDate=?, diaryText=?, userId=?, walkingTime=?, place=?"
		       + "WHERE diaryTit=?";
		  
		  DateFormat df = new SimpleDateFormat("yyyy/MM/dd");  // 주의: 월은 대문자 MM, 분은 소문자 mm
          Date utilDate = null;
		try {
			utilDate = df.parse(diary.getDiaryDate());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}            // String --> java.util.Date 변환
          
          
		  Object[] param = new Object[] {diary.getPhoto(), 
				  new java.sql.Date(utilDate.getTime()), diary.getDiaryText(), diary.getUserId(), diary.getWalkingTime(), diary.getPlace(), diary.getDiaryTit()};

		  jdbcUtil.setSqlAndParameters(sql, param);   // JDBCUtil에 update문과 매개 변수 설정
		         
		      try {            
		          int result = jdbcUtil.executeUpdate();   // update 문 실행
		         return result;
		      } catch (Exception ex) {
		         jdbcUtil.rollback();
		         ex.printStackTrace();
		      }
		      finally {
		    	 System.out.println("수정 완료");
		         jdbcUtil.commit();
		         jdbcUtil.close();   // resource 반환
		      }      
		      return 0;
		   }
}
