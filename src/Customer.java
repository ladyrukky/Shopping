public class Customer {
	
	private int customerID;
	private String name;
	private long cardNum;
	private String cardType;
	private boolean isMember;
	
	public Customer() {}
	
	public Customer(int customerID, String name, long cardNum, String cardType, boolean isMember) {
		this.customerID = customerID;
		this.name = name;
		this.cardNum = cardNum;
		this.cardType = cardType;
		this.isMember = isMember;
	}

	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getCardNum() {
		return cardNum;
	}

	public void setCardNum(long cardNum) {
		this.cardNum = cardNum;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public boolean isMember() {
		return isMember;
	}

	public void setMember(boolean isMember) {
		this.isMember = isMember;
	}

	@Override
	public String toString() {
		return "ID: " + customerID + ", Name: " + name + ", Card #: " + cardNum + ", Card Type: " + cardType + ", Member: " + isMember;
	}
}
