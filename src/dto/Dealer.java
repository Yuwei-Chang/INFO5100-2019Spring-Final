package dto;

public class Dealer {
	private String name;
	private String address;
	private String id;
	private int zipCode;
	private int phoneNumber;
	
	public Dealer(String name, String address, String id, int zipCode, int phoneNumber) {
        this.setName(name);
        this.setAddress(address);
        this.setId(id);
        this.setZipCode(zipCode);
        this.setPhoneNumber(phoneNumber);
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
}
