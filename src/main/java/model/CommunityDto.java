package model;

import java.util.List;

/**
 * 커뮤티니 관리를 위해 필요한 도메인 클래스. Community 테이블과 대응됨
 */
public class CommunityDto {
	private int comm_num;
	private String comm_title;
	private String comm_text;
	private String comm_date;
	private int comm_memberLimit;
	private String comm_leader;
	private int numOfMembers;
	private List<UserDto> memberList;

	public CommunityDto() { }		// 기본 생성자
	
	public CommunityDto(int comm_num, String comm_title, String comm_text, String comm_date, int comm_memberLimit, String comm_leader) {
		super();
		this.comm_num = comm_num;
		this.comm_title = comm_title;
		this.comm_text = comm_text;
		this.comm_date = comm_date;
		this.comm_memberLimit = comm_memberLimit;
		this.comm_leader = comm_leader;

	}

	public CommunityDto(String comm_title, String comm_text, String comm_date, int comm_memberLimit, int comm_num) {
		super();
		this.comm_title = comm_title;
		this.comm_text = comm_text;
		this.comm_date = comm_date;
		this.comm_memberLimit = comm_memberLimit;
		this.comm_num = comm_num;
	}
	
	public CommunityDto(int comm_num) {
		super();
		this.comm_num = comm_num;
	}
	
	public int getComm_num() {
		return comm_num;
	}

	public void setComm_num(int comm_num) {
		this.comm_num = comm_num;
	}

	public String getComm_title() {
		return comm_title;
	}

	public void setComm_title(String comm_title) {
		this.comm_title = comm_title;
	}
	
	public String getComm_text() {
		return comm_text;
	}
	
	public void setComm_text(String comm_text) {
		this.comm_text = comm_text;
	}

	public String getComm_date() {
		return comm_date;
	}

	public void setComm_date(String comm_date) {
		this.comm_date = comm_date;
	}

	public int getComm_memberLimit() {
		return comm_memberLimit;
	}

	public void setComm_memberLimit(int comm_memberLimit) {
		this.comm_memberLimit = comm_memberLimit;
	}

	public String getComm_leader() {
		return comm_leader;
	}

	public void setComm_leader(String comm_leader) {
		this.comm_leader = comm_leader;
	}

	public int getNumOfMembers() {
		return numOfMembers;
	}

	public void setNumOfMembers(int numOfMembers) {
		this.numOfMembers = numOfMembers;
	}

	public List<UserDto> getMemberList() {
		return memberList;
	}

	public void setMemberList(List<UserDto> memberList) {
		this.memberList = memberList;
	}

	@Override
	public String toString() {
		return "Community [" +"comm_num=" + comm_num + ", comm_title=" + comm_title + ", comm_date=" + comm_date
				+ ", comm_memberLimit=" + comm_memberLimit + ", comm_leader=" + comm_leader + ", comm_memberList="+ "]";
	}
}
