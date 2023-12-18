package model.dao;

import java.sql.SQLException;
import model.PetDto;

public class PetDAO {
	private JDBCUtil jdbcUtil = null;
	
	public PetDAO() {
		jdbcUtil = new JDBCUtil();
	}
	
	//petinfo 테이블에 새로운 pet 추가
	public int create(PetDto pet) throws SQLException {
		String sql = "INSERT INTO PETINFO VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		Object[] param = new Object[] {pet.getPetId(), pet.getPetName(), pet.getUserId(), pet.getPetGender(),
										pet.getPetSpecies(), pet.getPetHeight(), pet.getPetWeight(), pet.getpetImage()};
		jdbcUtil.setSqlAndParameters(sql, param);
		
		try {
			int result = jdbcUtil.executeUpdate();
			return result;
		} catch (Exception ex) {
			jdbcUtil.rollback();
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close();
		}
		return 0;
	}
	
	//petId로 펫 정보 수정
	public int update(PetDto pet) throws SQLException {
		String sql = "UPDATE PETINFO "
					+ "SET petName=?, userId=?, petGender=?, petSpecies=?, petHeight=?, petWeight=?, petImage=? "
					+ "WHERE petId=?";
		Object[] param = new Object[] {pet.getPetName(), pet.getUserId(), pet.getPetGender(), pet.getPetSpecies(),
										pet.getPetHeight(), pet.getPetWeight(),pet.getpetImage(), pet.getPetId()};
		jdbcUtil.setSqlAndParameters(sql, param);
		
		try {
			int result = jdbcUtil.executeUpdate();
			return result;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close();
		}
		return 0;
	}
	
	//petId로 펫 삭제
	public int delete(String petId) throws SQLException {
		String sql = "DELETE FROM PETINFO WHERE petId=? ";
		jdbcUtil.setSqlAndParameters(sql, new Object[] {petId});
		
		try {
			int result = jdbcUtil.executeUpdate();
			return result;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close();
		}
		return 0;
	}

}
