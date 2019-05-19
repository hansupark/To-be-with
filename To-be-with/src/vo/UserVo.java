package vo;

import java.sql.Date;

public class UserVo {

	private int userNum;
	private String email;
	private String password;
	private String name;
	private int gender;
	private Date date_Of_Birth;
	private String phone_Number;
	private String kakao_ID;
	private String passport_Image;
	private String identification_Image;
	
	public int getUserNum() {
		return userNum;
	}
	public void setUserNum(int userNum) {
		this.userNum = userNum;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public Date getDate_Of_Birth() {
		return date_Of_Birth;
	}
	public void setDate_Of_Birth(Date date_Of_Birth) {
		this.date_Of_Birth = date_Of_Birth;
	}
	public String getPhone_Number() {
		return phone_Number;
	}
	public void setPhone_Number(String phone_Number) {
		this.phone_Number = phone_Number;
	}
	public String getKakao_ID() {
		return kakao_ID;
	}
	public void setKakao_ID(String kakao_ID) {
		this.kakao_ID = kakao_ID;
	}
	public String getPassport_Image() {
		return passport_Image;
	}
	public void setPassport_Image(String passport_Image) {
		this.passport_Image = passport_Image;
	}
	public String getIdentification_Image() {
		return identification_Image;
	}
	public void setIdentification_Image(String identification_Image) {
		this.identification_Image = identification_Image;
	}
}
