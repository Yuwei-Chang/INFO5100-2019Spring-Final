package dto;

public class Dealer {
		private String dealerId;
	
	private String dealerName;
	
	private String dealerAddress;
	
	private String zipCode;
	
	private String phoneNumber;
	
	public String getdealerId() {
        return dealerId;
    }

    public void setdealerId(String id) {
        this.dealerId = id;
    }

    public String getdealerName() {
        return dealerName;
    }

    public void setdealerName(String name) {
        this.dealerName = name;
    }

    public String getdealerAddress() {
        return dealerAddress;
    }

    public void setdealerAddress(String address) {
        this.dealerAddress = address;
    }

    public String getzipCode() {
        return zipCode;
    }

    public void setzipCode(String zipcode) {
        this.zipCode = zipcode;
    }

    public String getPhoneNo() {
        return phoneNumber;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNumber = phoneNo;
    }
}
