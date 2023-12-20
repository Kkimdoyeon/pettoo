package model;

public class DiaryDto {
    private String photo;   // 사진을 저장하는 필드
    private String diaryTit; // 제목을 저장하는 필드
    private String diaryDate;       // 날짜를 저장하는 필드
    private String diaryText; // 긴 텍스트를 저장하는 필드
    private String userId;      // 작성자 id를 저장하는 필드
    private int walkingTime;
    private String place;

	// 생성자
    public DiaryDto() {};
    public DiaryDto(String photo, String diaryTit, String diaryDate, String diaryText, String userId, int walkingTime, String place) {
        this.photo = photo;
        this.diaryTit = diaryTit;
        this.diaryDate = diaryDate;
        this.diaryText = diaryText;
        this.userId = userId;
        this.walkingTime = walkingTime;
        this.place = place;
    }

    // Getter 메서드
    public String getPhoto() {
        return photo;
    }

    public String getDiaryTit() {
        return diaryTit;
    }

    public String getDiaryDate() {
        return diaryDate;
    }

    public String getDiaryText() {
        return diaryText;
    }

    public String getUserId() {
        return userId;
    }

	public int getWalkingTime() {
		return walkingTime;
	}
	
    public String getPlace() {
		return place;
	}
    
    // Setter 메서드
    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public void setDiaryTit(String diaryTit) {
        this.diaryTit = diaryTit;
    }

    public void setDiaryDate(String diaryDate) {
        this.diaryDate = diaryDate;
    }

    public void setDiaryText(String diaryText) {
        this.diaryText = diaryText;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

	public void setWalkingTime(int walkingTime) {
		this.walkingTime = walkingTime;
	}
	
	public void setPlace(String place) {
		this.place = place;
	}
	
    // toString 메서드
    @Override
    public String toString() {
        return "Diary{" +
                "photo=" + photo +
                ", diaryTit='" + diaryTit + '\'' +
                ", diaryDate=" + diaryDate +
                ", diaryText='" + diaryText + '\'' +
                ", userId=" + userId +
                ", walkingTime=" + walkingTime + '\'' +
                ", place=" + place + 
                '}';
    }
}