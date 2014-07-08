package vo;

public class EquipmentRent {
	private int eRentID;
	private String eTypeName;
    private String eStartTime;
    private String eEndTime;
    private int rentNumber;
    private String eRentPeople;
    
	public int geteRentID() {
		return eRentID;
	}
	public void seteRentID(int eRentID) {
		this.eRentID = eRentID;
	}
	public String geteTypeName() {
		return eTypeName;
	}
	public void seteTypeName(String eTypeName) {
		this.eTypeName = eTypeName;
	}
	public String geteStartTime() {
		return eStartTime;
	}
	public void seteStartTime(String eStartTime) {
		this.eStartTime = eStartTime;
	}
	public String geteEndTime() {
		return eEndTime;
	}
	public void seteEndTime(String eEndTime) {
		this.eEndTime = eEndTime;
	}
	public int getRentNumber() {
		return rentNumber;
	}
	public void setRentNumber(int rentNumber) {
		this.rentNumber = rentNumber;
	}
	public String geteRentPeople() {
		return eRentPeople;
	}
	public void seteRentPeople(String eRentPeople) {
		this.eRentPeople = eRentPeople;
	}
    
    
}
