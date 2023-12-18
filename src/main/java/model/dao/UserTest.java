package model.dao;

import java.sql.SQLException;
import java.util.Scanner;

public class UserTest {

	public static void main(String[] args) throws SQLException {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("id: ");
		String id = scan.nextLine();
		
		UserDAO test = new UserDAO();
		
		test.remove(id);
		System.out.println("삭제 완료");
		
		scan.close();
	}

}
