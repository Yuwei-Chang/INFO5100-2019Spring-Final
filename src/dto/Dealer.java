package dto;

public class Dealer {
	private String dealerId;
	private String dealerName;
	private String dealerAddress;
	private int zipCode;
	private long phoneNumber;
	private String distanceToCustomer;
	
	public Dealer(String dealerId, String dealerName, String dealerAddress, int zipCode, long phoneNumber) {
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

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	@Override
	public String toString() {
		return "Dealer [dealerId=" + dealerId + ", dealerName=" + dealerName + ", dealerAddress=" + dealerAddress
				+ ", zipCode=" + zipCode + ", phoneNumber=" + phoneNumber + "]";
	}

	public void setDistanceToCustomer(String distanceToCustomer) {
		this.distanceToCustomer = distanceToCustomer;
	}

	public String getDistanceToCustomer() {
		return distanceToCustomer;
	}
}
