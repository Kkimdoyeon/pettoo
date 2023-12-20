package model.dao;

import java.sql.SQLException;
import java.util.Date;
import java.util.Scanner;

import model.DiaryDto;

public class DiaryTest {
	public static void main(String[] args) throws SQLException {
		Scanner scanner = new Scanner(System.in);
		
		/*
		//새 다이어리 생성
		System.out.print("추가할 사진 주소(?)를 입력하시오: ");
		String photo = scanner.nextLine();
		System.out.print("다이어리의 제목을 입력하시오: ");
		String diaryTit = scanner.nextLine();
		System.out.print("산책한 날짜를 입력하시오: ");
		String diaryDate = scanner.nextLine();
		System.out.print("추가할 다이어리 내용을 입력하시오: ");
		String diaryText = scanner.nextLine();
		System.out.print("사용자 ID를 입력하시오: ");
		String userId = scanner.nextLine();
		System.out.print("산책한 시간(분)을 입력하시오: ");
		int walkingTime = scanner.nextInt();
		System.out.print("산책한 장소의 이름을 입력하시오: ");
		String place = scanner.next();
		
		DiaryDto diary = new DiaryDto(photo, diaryTit, diaryDate, diaryText, userId, walkingTime, place);
		DiaryDAO test = new DiaryDAO();
		test.createDiary(diary);
		System.out.println("추가 완료");
		*/
		
		
		/*
		//다이어리 삭제
		System.out.print("삭제할 다이어리의 제목을 입력하시오: ");
		String title = scanner.nextLine();
		DiaryDAO test = new DiaryDAO();
		test.deleteDiary(title);
		System.out.println("삭제 완료");
		*/
		
		
		 //다이어리 수정
		System.out.print("사진 주소(?)를 입력하시오: ");
		String photo = scanner.nextLine();
		System.out.print("다이어리의 제목을 입력하시오: ");
		String diaryTit = scanner.nextLine();
		System.out.print("산책한 날짜를 입력하시오: ");
		String diaryDate = scanner.nextLine();
		System.out.print("다이어리 내용을 입력하시오: ");
		String diaryText = scanner.nextLine();
		System.out.print("사용자 ID를 입력하시오: ");
		String userId = scanner.nextLine();
		System.out.print("산책한 시간(분)을 입력하시오: ");
		int walkingTime = scanner.nextInt();
		System.out.print("산책한 장소의 이름을 입력하시오: ");
		String place = scanner.next();
		
		DiaryDto diary = new DiaryDto(photo, diaryTit, diaryDate, diaryText, userId, walkingTime, place);
		DiaryDAO test = new DiaryDAO();
		test.updateDiary(diary);
		//System.out.println("수정 완료");
		
		scanner.close();
		
	}
}

