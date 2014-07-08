package vo;

public class Equipment {
    private String eTypeName;
    private int adminID;
    private int eNumber;
    private  int eRentFees;
    private int compensation;
    
	public String geteTypeName() {
		return eTypeName;
	}
	public void seteTypeName(String eTypeName) {
		this.eTypeName = eTypeName;
	}
	public int getAdminID() {
		return adminID;
	}
	public void setAdminID(int adminID) {
		this.adminID = adminID;
	}
	public int geteNumber() {
		return eNumber;
	}
	public void seteNumber(int eNumber) {
		this.eNumber = eNumber;
	}
	public int geteRentFees() {
		return eRentFees;
	}
	public void seteRentFees(int eRentFees) {
		this.eRentFees = eRentFees;
	}
	public int getCompensation() {
		return compensation;
	}
	public void setCompensation(int compensation) {
		this.compensation = compensation;
	}
	
    
}
