package finalprojectgroup2test2;


import static finalprojectgroup2test2.InventorySearchBuild.*;

public class FilterContent {
	private String category;
	private String make; 
	private String model;
	private String type;
	
	private double mileage;
	private String seatCount;
	
	private String highPrice;
	private String lowPrice; 
	private int highYear;
	private int lowYear;
	boolean needsNew, needsUsed;
	boolean yearValidate = false, priceValidate = false;
	public FilterContent() {
			this.lowPrice = "";
			this.highPrice = "";
			this.lowYear = 0;
			this.highYear = 3000;
			this.make = "";
			this.model = "";
			this.type = "";
			this.mileage = 0;
			this.seatCount = "";
			this.category = "";

			this.needsUsed = true;
			this.needsNew = true;
		}
	
	//category
	public String getCategory() {
	return category;
		}
	public void setNeedNew(boolean category) { this.needsNew = category; }
	public void setNeedUsed(boolean category){ this.needsUsed = category;}
	
	//make
	public String getMake(){
	return make;
		}
	public void setMake(String make) {
	this.make = make;
		}
	
	//model
	public String getModel(){
	return model;
		}
	public void setModel(String model) {
	this.model = model;
		}
	
	//type
	public String getType(){
	return type;
		}
	public void setType(String type) {
	this.type = type;
		}
	
	//highPrice
	public String getHighPrice() {
	return highPrice;
		}
	public void setHighPrice(String highPrice) {
	this.highPrice = highPrice;
		}
	
	//lowPrice
	public String getLowPrice() {
	return lowPrice;
		}
	public void setLowPrice(String lowPrice) {
	this.lowPrice = lowPrice;
		}
	
	//highYeat
	public int getHighYear() {
	return highYear;
		}
	public void setHighYear(Object highYear) {
		if(highYear.equals("--Please choose a year"))
			this.highYear = 3000;
		else
			this.highYear = (int)highYear;
		}
	
	//lowYear
	public int getLowYear() {
	return lowYear;
		}
	public void setLowYear(Object lowYear) {
		if(lowYear.equals("--Please choose a year"))
			this.lowYear = 0;
		else
			this.lowYear = (int)lowYear;
		}
	
	//mileage
	public double getMileage() {
	return mileage;
		}
	public void setMileage(double mileage) {
	this.mileage = mileage;
		}
	
	//seatCount
	public String getSeatCount() {
	return seatCount;
		}
	public void setSeatCount(String seatCount) {
	this.seatCount = seatCount;
		}

	@Override
	public String toString() {
		return getLowYear()+"\n"+getHighYear()+"\n"+getLowPrice()+"\n"+getHighPrice()+"\n"+"\n"+getMake()+"\n"+getMileage()+"\n"+getModel();
	}

	public boolean isValidate(){

			int startYear = this.getLowYear();
			int endYear = this.getHighYear();
			if (startYear > endYear) {
				this.yearValidate = false;
			}
			else
				this.yearValidate = true;


		//verify price filter validation
		if(this.getHighPrice().equals(maxPriceFilterResults.get(maxPriceFilterResults.size()-1))) {
			this.highPrice = "99999999";
		}
		if(this.getLowPrice().equals(minPriceFilterResults.get(minPriceFilterResults.size()-1))){
			this.lowPrice = "0";
		}

			double startPrice = Double.valueOf(this.getLowPrice().replace("$","").replace(",",""));
			double endPrice = Double.valueOf(this.getHighPrice().replace("$","").replace(",",""));
			if (startPrice > endPrice) {
				this.priceValidate = false;
			}
			else
				this.priceValidate = true;


		//verify mileage filter validation
		if(this.getMileage()==1000000) {
			this.mileage = 1000000;
		}

		if(this.getMake().equals("--Please choose a preferred make")) {
			this.make = "";
		}

		if(this.getSeatCount().equals(seatCountItems.get(seatCountItems.size()-1))) {
			this.seatCount = "";
		}

		if(this.getType().equals(typeSetItems.get(typeSetItems.size()-1))) {
			this.type = "";
		}

		if(this.getModel().equals("--Please choose a preferred model")) {
			this.model = "";
		}

		return this.priceValidate && this.yearValidate;
	}
}
