package vo;

import java.sql.Date;

public class TravelVo {

	private int travelNum;
	private int userNum;
	private String travelDate;
	private String country;
	private String region;
	
	private int current_Count;
	private int max_Count;
	
	public TravelVo()
	{
		country = null;
		region = null;
		travelDate = null;
	}
	
	public int getTravelNum() {
		return travelNum;
	}
	public void setTravelNum(int travelNum) {
		this.travelNum = travelNum;
	}
	public int getUserNum() {
		return userNum;
	}
	public void setUserNum(int userNum) {
		this.userNum = userNum;
	}
	public String getTravelDate() {
		return travelDate;
	}
	public void setTravelDate(String travelDate) {
		this.travelDate = travelDate;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public int getMax_Count() {
		return max_Count;
	}
	public void setMax_Count(int max_Count) {
		this.max_Count = max_Count;
	}
	public int getCurrent_Count() {
		return current_Count;
	}
	public void setCurrent_Count(int current_Count) {
		this.current_Count = current_Count;
	}
	
}
