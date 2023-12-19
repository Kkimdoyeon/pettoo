package model;

public class UserDto {
	private String userId;
	private String userPw;
	private String userName;
	private String address;
	private String gender;
	private String email;
	private String phoneNumber;
	private String userBirth;
	private String petId;
	private int comm_num;
	
	
	//생성자
	public UserDto() {}; //기본 생성자
	
	//커뮤니티에 속한 멤버 출력용 생성자
	public UserDto(String userId, String userName, String gender, String email, String petId) {
		this.userId = userId;
		this.userName = userName;
		this.gender = gender;
		this.email = email;
		this.petId = petId;
	}

	//전체 생성자
	public UserDto(String userId, String pw, String userName, String address, String gender, String email, String phoneNumber, String userBirth, String petId, int cNum) {
		this(userId, userName, gender, email, petId);
		this.userPw = pw;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.userBirth = userBirth;
		this.comm_num = cNum;
	}
	
	
	//getter & setter
	public String getUserId() {
		return userId;
	}
	public void setUserID(String userId) {
		this.userId = userId;
	}
	public String getuserPw() {
		return userPw;
	}
	public void setuserPw(String userPw) {
		this.userPw = userPw;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getUserBirth() {
		return userBirth;
	}
	public void setUserBirth(String userBirth) {
		this.userBirth = userBirth;
	}
	public String getPetId() {
		return petId;
	}
	public void setPetId(String petId) {
		this.petId = petId;
	}
	public int getComm_num() {
		return comm_num;
	}
	public void setComm_num(int comm_num) {
		this.comm_num = comm_num;
	}

	
	/* 비밀번호 검사 (사용 여부 아직 모름) */
	public boolean matchUserPw(String userPw) {
		if (userPw == null) {
			return false;
		}
		return this.userPw.equals(userPw);
	}
	
	public boolean isSameUser(String userid) {
        return this.userId.equals(userid);
    }

	@Override
	public String toString() {
		return "User [userId="+ userId +", userPw="+ userPw +", name="+ userName +", userBirth="+ userBirth +", email="+ email +", phone="
				+ phoneNumber +"gender="+ gender +"petId="+ petId +", comm_number="+ comm_num +"]";
	}

}
