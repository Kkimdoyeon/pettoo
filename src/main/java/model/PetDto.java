package model;

public class PetDto {
	private String petName;
	private String userId;
	private String petGender;
	private String petData;
	private String petSpecies;
	private int petHeight;
	private int petWeight;
	private String petId;
	
	//생성자
	public PetDto() {};
	
	public PetDto(String name, String uId, String gen, String data, String species, int height, int weight, String pId) {
		this.petName = name;
		this.userId = uId;
		this.petGender = gen;
		this.petData = data;
		this.petSpecies = species;
		this.petHeight = height;
		this.petWeight = weight;
		this.petId = pId;
	}

	//getter & setter
	public String getPetName() {
		return petName;
	}
	public void setPetName(String petName) {
		this.petName = petName;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPetGender() {
		return petGender;
	}
	public void setPetGender(String petGender) {
		this.petGender = petGender;
	}
	public String getPetData() {
		return petData;
	}
	public void setPetData(String petData) {
		this.petData = petData;
	}
	public String getPetSpecies() {
		return petSpecies;
	}
	public void setPetSpecies(String petSpecies) {
		this.petSpecies = petSpecies;
	}
	public int getPetHeight() {
		return petHeight;
	}
	public void setPetHeight(int petHeight) {
		this.petHeight = petHeight;
	}
	public int getPetWeight() {
		return petWeight;
	}
	public void setPetWeight(int petWeight) {
		this.petWeight = petWeight;
	}
	public String getPetId() {
		return petId;
	}
	public void setPetId(String petId) {
		this.petId = petId;
	}
	


}
