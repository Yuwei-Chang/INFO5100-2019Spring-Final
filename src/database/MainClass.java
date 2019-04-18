package car.dabase;

import java.util.List;

public class MainClass {

	public static void main(String[] args) {
		DatabaseConnection connection = new DatabaseConnection();
		Vehicle vehicle = connection.retriveVehicleFromDatabase("V10");

		System.out.println(vehicle.getVehicleId() + " " + vehicle.getYear() + " " + vehicle.getPrice());
		
		
		
		  List<Vehicle> vehicleList = connection.getVehiclesForDealer("D1");
		  
		  System.out.print("Size" + vehicleList.size());
		  
		  for(Vehicle vechicle : vehicleList) {
		  System.out.println(vechicle.getCategory() + " " + vechicle.getMake() + " " +
		  vechicle.getModel()); }
		 
		 
		
	}

}
