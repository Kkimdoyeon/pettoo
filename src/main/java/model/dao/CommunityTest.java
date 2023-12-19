package model.dao;

import model.CommunityDto;
import model.dao.CommunityDAO;

import java.sql.SQLException;
import java.util.Scanner;

public class CommunityTest {
	public static void main(String[] args) throws SQLException{
		Scanner scan = new Scanner(System.in);

		//System.out.println("community number: ");
		//int comm_num = Integer.parseInt(scan.nextLine());
		
		System.out.println("community number: ");
		int comm_num = Integer.parseInt(scan.nextLine());
		
		
		
		//CommunityDto test= new CommunityDto(comm_num, comm_title, comm_text, comm_date, comm_memberlimit,comm_leader);
		//CommunityDAO c = new CommunityDAO();
		
		
		//CommunityDto test= new CommunityDto(comm_title, comm_text, comm_date, comm_memberlimit, comm_num);
		//CommunityDAO c = new CommunityDAO();
		
		CommunityDto test= new CommunityDto(comm_num);
		CommunityDAO c = new CommunityDAO();
		
		//c. existingCommunity(test);
		//System.out.println(c. existingCommunity(test));
		//c.findCommunity(test);
		//System.out.println(c);
		scan.close();
	}
}
