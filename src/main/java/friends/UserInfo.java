package friends;

public class UserInfo {
	private int userID;
	private String userName;
	private String address;
	private String gender;
	private String email;
	private String phoneNumber;
	private String userBirth;
	private int petID;
	private UserInfo[] friends = new UserInfo[100]; //최대 친구 수를 100명으로 제한
	
	
	//생성자
	public UserInfo() {}; //기본 생성자
	
	public UserInfo(int userID, String userName, String address, String gender, String email, String phoneNumber, String userBirth, int petID) {
		this.userID = userID;
		this.userName = userName;
		this.address = address;
		this.gender = gender;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.userBirth = userBirth;
		this.petID = petID;
	}
	
	//getter & setter
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
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
	public int getPetID() {
		return petID;
	}
	public void setPetID(int petID) {
		this.petID = petID;
	}

}
