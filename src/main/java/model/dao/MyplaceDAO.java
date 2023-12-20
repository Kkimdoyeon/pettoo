package model.dao;

import java.sql.ResultSet;
import model.PlaceDTO;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

public class MyplaceDAO {
	
	private JDBCUtil jdbcUtil = null;
	public MyplaceDAO() {			
		jdbcUtil = new JDBCUtil();	// JDBCUtil 객체 생성
	}
	
	//myplace 테이블에 레코드 삽입 (placeDTO삽입)
	public int insertPlace(PlaceDTO place) throws SQLException {
		int result = 0;
		String sql = "INSERT INTO MYPLACE VALUES (?, ?, ?, ?)";
		Object[] param = new Object[] {place.getPlaceName(), place.getPlaceLoc(),
						place.getPlaceType(), place.getComm_num()};				
		
		jdbcUtil.setSqlAndParameters(sql, param);	// JDBCUtil 에 insert문과 매개 변수 설정
						   
		try {
			result = jdbcUtil.executeUpdate();  // insert 문 실행
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
	
	//myplace에서 레코드 삭제(placeDTO 삭제)
	public int remove(int comm_num, String placeName) throws SQLException {
		String sql = "DELETE FROM MYPLACE WHERE comm_num=? and placeName=?";		
		jdbcUtil.setSqlAndParameters(sql, new Object[] {comm_num, placeName});	// JDBCUtil에 delete문과 매개 변수 설정

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
	
	//myplace에서 커뮤니티별로 장소 검색
	public List<PlaceDTO> findPlaceList(String comm_title) throws SQLException {
        String sql = "SELECT myplace.placeName, myplace.placeLoc, myplace.placeType, myplace.comm_num "
        		   + "FROM myplace "
        		   + "JOIN community ON myplace.comm_num = community.comm_num "
        		   + "where comm_title = ?";
		jdbcUtil.setSqlAndParameters(sql, new Object[] {comm_title});		// JDBCUtil에 query문 설정
					
		try {
			ResultSet rs = jdbcUtil.executeQuery();			// query 실행			
			List<PlaceDTO> placeList = new ArrayList<PlaceDTO>();	// Community들의 리스트 생성
			while (rs.next()) {
				PlaceDTO place = new PlaceDTO (			// Community 객체를 생성하여 현재 행의 정보를 저장
						rs.getString("placeName"),
						rs.getString("placeLoc"),
						rs.getString("placeType"),
						rs.getInt("comm_num"));
				placeList.add(place);				// List에 Community 객체 저장
			}		
			return placeList;					
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource 반환
		}
		return null;
	}
}
