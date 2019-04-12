package database;

import dto.Vehicle;

public class MainClass {

	public static void main(String[] args) {
		DatabaseConnection connection = new DatabaseConnection();
		Vehicle vehicle = connection.retriveVehicleFromDatabase("V1");
		
		System.out.println(vehicle.getVehicleId() + " " + vehicle.getYear() + " " + vehicle.getPrice());
		
		
		
	}

}
