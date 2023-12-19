package model;

public class PlaceDTO {
	private String placeName;
	private String placeLoc;
	private String placeType;
	private int comm_num;
	public PlaceDTO(String placeName, String placeLoc, String placeType, int comm_num) {
		this.placeName = placeName;
		this.placeLoc = placeLoc;
		this.placeType = placeType;
		this.comm_num = comm_num;
	}
	public String getPlaceLoc() {
		return placeLoc;
	}
	public void setPlaceLoc(String placeLoc) {
		this.placeLoc = placeLoc;
	}
	public String getPlaceName() {
		return placeName;
	}
	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}
	public String getPlaceType() {
		return placeType;
	}
	public void setPlaceType(String placeType) {
		this.placeType = placeType;
	}
	public int getComm_num() {
		return comm_num;
	}
	public void setComm_num(int comm_num) {
		this.comm_num = comm_num;
	}
	
	
}
