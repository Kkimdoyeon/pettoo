package no_use;

import model.PetDto;
import model.dao.PetDAO;

import java.sql.SQLException;
import java.util.Scanner;

public class UserTest {

	public static void main(String[] args) throws SQLException {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("petId: ");
		String petId = scan.nextLine();
		
		System.out.print("name: ");
		String name = scan.nextLine();
		System.out.print("userId: ");
		String userId = scan.nextLine();
		System.out.print("gen: ");
		String gen = scan.nextLine();
		System.out.print("species: ");
		String spe = scan.nextLine();
		System.out.print("height: ");
		float height = scan.nextFloat();
		System.out.print("weight: ");
		float weight = scan.nextFloat();
		System.out.print("image: ");
		String image = scan.next();
		
		PetDto pet = new PetDto(petId, name, userId, gen, spe, height, weight, image);
		
		PetDAO test = new PetDAO();
		
		test.update(pet);
		System.out.println("작업 완료");
		
		scan.close();
	}

}
