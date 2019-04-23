package finalprojectgroup2test2;

import java.util.ArrayList;

import dto.Vehicle;

// After user select the Make and Model, this class can be used to return a relative ArrayList of years, which should be put in the setYearComboBox's listener.
public class YearSetItems {
	// Initialization of two helper integer
	private int minYear = 3000;
	private int maxYear = 0;
	
	public YearSetItems() {
	}
	
	// Function with input vehiclesCollection and Make and Model that used to return an ArrayList with String objects
	public ArrayList<Object> getYearItems(ArrayList<Vehicle> vehiclesCollection, String Make, String Model) {
		ArrayList<Object> yearItemsList = new ArrayList<>();
		
		if (Make.equals("") && Model.equals("")) {
			for (int i=0; i<vehiclesCollection.size(); i++) {
				if (Integer.parseInt(vehiclesCollection.get(i).getYear()) < this.minYear) {
					this.minYear = Integer.parseInt(vehiclesCollection.get(i).getYear());
				}
				if (Integer.parseInt(vehiclesCollection.get(i).getYear()) > this.maxYear) {
					this.maxYear = Integer.parseInt(vehiclesCollection.get(i).getYear());
				}
			}
		}
		
		else if ((!Make.equals("")) && Model.equals("")) {
			for (int i=0; i<vehiclesCollection.size(); i++) {
				if (vehiclesCollection.get(i).getMake().equals(Make)) {
					if (Integer.parseInt(vehiclesCollection.get(i).getYear()) < this.minYear) {
						this.minYear = Integer.parseInt(vehiclesCollection.get(i).getYear());
					}
					if (Integer.parseInt(vehiclesCollection.get(i).getYear()) > this.maxYear) {
						this.maxYear = Integer.parseInt(vehiclesCollection.get(i).getYear());
					}
				}
			}
		}
		
		else if ((!Make.equals("")) && (!Model.equals(""))) {
			for (int i=0; i<vehiclesCollection.size(); i++) {
				if (vehiclesCollection.get(i).getMake().equals(Make) && vehiclesCollection.get(i).getModel().equals(Model)) {
					if (Integer.parseInt(vehiclesCollection.get(i).getYear()) < this.minYear) {
						this.minYear = Integer.parseInt(vehiclesCollection.get(i).getYear());
					}
					if (Integer.parseInt(vehiclesCollection.get(i).getYear()) > this.maxYear) {
						this.maxYear = Integer.parseInt(vehiclesCollection.get(i).getYear());
					}
				}
			}
		}
		
		if (this.minYear == 3000 && this.maxYear == 0) {
			return yearItemsList;
		}
		
		for (int year=this.minYear; year<=this.maxYear; year++) {
			yearItemsList.add(year);
		}
		
		return yearItemsList;
	}
	
	// Main for testing
	public static void main(String[] args) {
		Vehicle vehicleDummy1 = new Vehicle();
		Vehicle vehicleDummy2 = new Vehicle();
		
		vehicleDummy1.setYear("2016");
		vehicleDummy1.setMake("Audi");
		vehicleDummy1.setModel("A8");
		vehicleDummy2.setMake("BMW");
		vehicleDummy2.setModel("X6");
		vehicleDummy2.setYear("2019");
		
		ArrayList<Vehicle> vehiclesCollectionTest = new ArrayList<>();
		
		vehiclesCollectionTest.add(vehicleDummy1);
		vehiclesCollectionTest.add(vehicleDummy2);
		
		YearSetItems ysiTest = new YearSetItems();

		for (Object i : ysiTest.getYearItems(vehiclesCollectionTest, "", "")) {
			System.out.println(i);
		}
	}

}
