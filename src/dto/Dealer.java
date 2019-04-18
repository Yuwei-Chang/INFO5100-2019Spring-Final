package dto;

public class Dealer {
	private String dealerId;
	private String dealerName;
	private String dealerAddress;
	private int zipCode;
	private int phoneNumber;
	
	public Dealer(String dealerId, String dealerName, String dealerAddress, int zipCode, int phoneNumber) {
		this.setDealerId(dealerId);
		this.setDealerName(dealerName);
        this.setDealerAddress(dealerAddress);
        this.setZipCode(zipCode);
        this.setPhoneNumber(phoneNumber);
    }

	public Dealer() {
	}


	
	public String getName() {
		return dealerName;
	}

	public void setDealerName(String name) {
		this.dealerName = name;
	}

	public String getAddress() {
		return dealerAddress;
	}

	public void setDealerAddress(String address) {
		this.dealerAddress = address;
	}

	public String getId() {
		return dealerId;
	}

	public void setDealerId(String id) {
		this.dealerId = id;
	}

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	@Override
    public String toString(){
		return getName(); 
    	
    }
}
