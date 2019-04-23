package finalprojectgroup2test2;

import java.util.ArrayList;

import dto.Vehicle;

public class ModelSetItems {
	
	
	
	private ModelSetItems() {
		
	}
	
	private ArrayList<String> getModelItems(ArrayList<Vehicle> vehiclesCollection, String Make) {
		ArrayList<String> modelItemsList = new ArrayList<>();
		
		if (Make.equals("")) return modelItemsList;
		
		else if (!Make.equals("")) {
			for (int i=0; i<vehiclesCollection.size(); i++) {
				if (vehiclesCollection.get(i).getMake().equals(Make)) {
					modelItemsList.add(vehiclesCollection.get(i).getModel());
				}
			}
		}
		
		return modelItemsList;
	}
	
	
	
	public static void main(String[] args) {
		Vehicle vehicleDummy1 = new Vehicle();
		Vehicle vehicleDummy2 = new Vehicle();
		
		vehicleDummy1.setMake("Audi");
		vehicleDummy1.setModel("A8");
		vehicleDummy2.setMake("BMW");
		vehicleDummy2.setModel("X6");
		
		ArrayList<Vehicle> vehiclesCollectionTest = new ArrayList<>();
		
		vehiclesCollectionTest.add(vehicleDummy1);
		vehiclesCollectionTest.add(vehicleDummy2);

		ModelSetItems msiTest = new ModelSetItems();
		
		
		for (String i : msiTest.getModelItems(vehiclesCollectionTest, "Audi")) {
			System.out.println(i);
		}

	}

}
