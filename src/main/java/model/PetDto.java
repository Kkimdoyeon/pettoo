package model;

public class PetDto {
	private String petId;
	private String petName;
	private String userId;
	private String petGender;
	private String petSpecies;
	private float petHeight;
	private float petWeight;
	private String petImage;
	
	//생성자
	public PetDto() {};
	
	public PetDto(String pId, String name, String uId, String gen, String species, float height, float weight, String image) {
		this.petId = pId;
		this.petName = name;
		this.userId = uId;
		this.petGender = gen;
		this.petSpecies = species;
		this.petHeight = height;
		this.petWeight = weight;
		this.petImage = image;
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
	public String getpetImage() {
		return petImage;
	}
	public void setpetImage(String petImage) {
		this.petImage = petImage;
	}
	public String getPetSpecies() {
		return petSpecies;
	}
	public void setPetSpecies(String petSpecies) {
		this.petSpecies = petSpecies;
	}
	public float getPetHeight() {
		return petHeight;
	}
	public void setPetHeight(int petHeight) {
		this.petHeight = petHeight;
	}
	public float getPetWeight() {
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
