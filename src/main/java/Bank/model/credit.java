package Bank.model;

public class credit {
	private int regNo;
	private float accBal;
	public credit(int regNo, float accBal) {
		super();
		this.regNo = regNo;
		this.accBal = accBal;
	}
	public int getRegNo() {
		return regNo;
	}
	public void setRegNo(int regNo) {
		this.regNo = regNo;
	}
	public float getAccBal() {
		return accBal;
	}
	public void setAccBal(float accBal) {
		this.accBal = accBal;
	}
	
	
}
