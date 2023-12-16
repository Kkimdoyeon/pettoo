package model;

import java.util.*;

public class DiaryDto {
    private byte[] photo;   // 사진을 저장하는 필드
    private String diaryTit; // 제목을 저장하는 필드
    private Date date;       // 날짜를 저장하는 필드
    private String diaryText; // 긴 텍스트를 저장하는 필드
    private String userId;      // 작성자 id를 저장하는 필드
    private int walkingTime;
    private String place;

    public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public int getWalkingTime() {
		return walkingTime;
	}
	public void setWalkingTime(int walkingTime) {
		this.walkingTime = walkingTime;
	}
	// 생성자
    public DiaryDto() {}
    public DiaryDto(byte[] photo, String diaryTit, Date date, String diaryText, String userId, int walkingTime, String place) {
        this.photo = photo;
        this.diaryTit = diaryTit;
        this.date = date;
        this.diaryText = diaryText;
        this.userId = userId;
        this.walkingTime = walkingTime;
        this.place = place;
    }

    // Getter 메서드
    public byte[] getPhoto() {
        return photo;
    }

    public String getDiaryTit() {
        return diaryTit;
    }

    public Date getDate() {
        return date;
    }

    public String getDiaryText() {
        return diaryText;
    }

    public String getUserId() {
        return userId;
    }

    // Setter 메서드
    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public void setDiaryTit(String diaryTit) {
        this.diaryTit = diaryTit;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setDiaryText(String diaryText) {
        this.diaryText = diaryText;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    // toString 메서드
    @Override
    public String toString() {
        return "Diary{" +
                "photo=" + Arrays.toString(photo) +
                ", diaryTit='" + diaryTit + '\'' +
                ", date=" + date +
                ", diaryText='" + diaryText + '\'' +
                ", userId=" + userId +
                '}';
    }
}