package finalprojectgroup2test2;

import java.util.ArrayList;

public class FilterContent {
	
	private ArrayList<String> category;
	private ArrayList<String> make; 
	private ArrayList<String> model;
	private ArrayList<String> type;
	
	private ArrayList<String> mileage;
	private ArrayList<String> seatCount;
	
	private double highPrice;
	private double lowPrice; 
	private int highYear;
	private int lowYear;
	
	public FilterContent() {
		}
	
	public ArrayList<String>getCategory() {
	return category;
		}
	public void setCategory(ArrayList<String> category) {
	this.category = category;
		}
	public ArrayList<String> getMake(){
	return make;
		}
	public void setMake(ArrayList<String> make) {
	this.make = make;
		}
	public ArrayList<String> getModel(){
	return model;
		}
	public void setModel(ArrayList<String> model) {
	this.model = model;
		}
	public ArrayList<String> getType(){
	return type;
		}
	public void setType(ArrayList<String> type) {
	this.type = type;
		}
	public double getHighPrice() {
	return highPrice;
		}
	public void setHighPrice(double highPrice) {
	this.highPrice = highPrice;
		}
	public double getLowPrice() {
	return lowPrice;
		}
	public void setLowPrice(double lowPrice) {
	this.lowPrice = lowPrice;
		}
	public int getHighYear() {
	return highYear;
		}
	public void setHighYear(int highYear) {
	this.highYear = highYear;
		}
	public int getLowYear() {
	return lowYear;
		}
	public void setLowYear(int lowYear) {
	this.lowYear = lowYear;
		}
	//
	public ArrayList<String> getMileage() {
	return mileage;
		}
	public void setMileage(ArrayList<String> mileage) {
	this.mileage = mileage;
		}
	
	public ArrayList<String> getSeatCount() {
	return seatCount;
		}
	public void setSeatCount(ArrayList<String> seatCount) {
	this.seatCount = seatCount;
		}

}