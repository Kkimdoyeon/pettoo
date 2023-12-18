package friends;

public class UserInfo {
	private String userId;
	private String userName;
	private String address;
	private String gender;
	private String email;
	private String phoneNumber;
	private String userBirth;
	private String petId;
	
	
	//생성자
	public UserInfo() {}; //기본 생성자
	
	public UserInfo(String userId, String userName, String address, String gender, String email, String phoneNumber, String userBirth, String petId) {
		this.userId = userId;
		this.userName = userName;
		this.address = address;
		this.gender = gender;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.userBirth = userBirth;
		this.petId = petId;
	}
	
	//getter & setter
	public String getUserId() {
		return userId;
	}
	public void setUserID(String userId) {
		this.userId = userId;
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

}