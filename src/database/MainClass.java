package database;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import dto.Dealer;
import dto.Vehicle;

public class MainClass {

	public static void main(String[] args) {
		DatabaseConnection connection = new DatabaseConnection();
		Vehicle vehicle = connection.getVehicle("V10");

		System.out.println(vehicle.getVehicleId() + " " + vehicle.getYear() + " " + vehicle.getPrice());
		
		  List<Vehicle> vehicleList = connection.getVehiclesForDealer("D1");
		  
		  System.out.print("Size" + vehicleList.size());
		  
		  for(Vehicle vechicle : vehicleList) {
		  System.out.println(vechicle.getCategory() + " " + vechicle.getMake() + " " +
		  vechicle.getModel()); }
		  
		  ArrayList<Dealer> list=new ArrayList<Dealer>();
			list=(ArrayList<Dealer>) connection.getAllDealers();
			Iterator<Dealer> itr=list.iterator();
			while(itr.hasNext())
	        {
	            System.out.println(itr.next());
	        }
		//images
		
		connection.saveImageForId("V1","C:\\Users\\A\\Desktop\\CarImage\\Audi A4.jpg"); 
		connection.retrieveVehicleImage("V1");
		connection.saveImageForId("V10","C:\\Users\\A\\Desktop\\CarImage\\Jaguar FPace.jpeg");
		connection.retrieveVehicleImage("V10");
		connection.saveImageForId("V11","C:\\Users\\A\\Desktop\\CarImage\\Kia Sedona.jpeg");
		connection.retrieveVehicleImage("V11"); 
		connection.saveImageForId("V12","C:\\Users\\A\\Desktop\\CarImage\\Kia EX.jpeg");
		connection.retrieveVehicleImage("V12"); 
		connection.saveImageForId("V13","C:\\Users\\A\\Desktop\\CarImage\\Land Rover Evoque.jpeg");
		connection.retrieveVehicleImage("V13");
		connection.saveImageForId("V14","C:\\Users\\A\\Desktop\\CarImage\\Land Rover V8.jpeg");
		connection.retrieveVehicleImage("V14");
		connection.saveImageForId("V15","C:\\Users\\A\\Desktop\\CarImage\\Mazda Mazda3.jpeg");
		connection.retrieveVehicleImage("V15");
		connection.saveImageForId("V16","C:\\Users\\A\\Desktop\\CarImage\\Mazda CX9.jpeg");
		connection.retrieveVehicleImage("V16");
		connection.saveImageForId("V17","C:\\Users\\A\\Desktop\\CarImage\\Volvo XC40.jpeg");
		connection.retrieveVehicleImage("V17");
		connection.saveImageForId("V18","C:\\Users\\A\\Desktop\\CarImage\\Volvo S90.jpeg");
		connection.retrieveVehicleImage("V18");
		connection.saveImageForId("V19","C:\\Users\\A\\Desktop\\CarImage\\Ford F150.jpeg");
		connection.retrieveVehicleImage("V19");
		connection.saveImageForId("V2","C:\\Users\\A\\Desktop\\CarImage\\BMW X6.jpeg");
		connection.retrieveVehicleImage("V2");
		connection.saveImageForId("V20","C:\\Users\\A\\Desktop\\CarImage\\Jeep Patriot.jpeg");
		connection.retrieveVehicleImage("V20");
		connection.saveImageForId("V21","C:\\Users\\A\\Desktop\\CarImage\\Tesla Model S.jpeg");
		connection.retrieveVehicleImage("V21");
		connection.saveImageForId("V22","C:\\Users\\A\\Desktop\\CarImage\\Porsche Cayenne.jpeg");
		connection.retrieveVehicleImage("V22");
		connection.saveImageForId("V23","C:\\Users\\A\\Desktop\\CarImage\\Acura ILX.jpeg");
		connection.retrieveVehicleImage("V23");
		connection.saveImageForId("V24","C:\\Users\\A\\Desktop\\CarImage\\Aston Martin DB9.jpeg");
		connection.retrieveVehicleImage("V24");
		connection.saveImageForId("V25","C:\\Users\\A\\Desktop\\CarImage\\Honda Civic LX.jpeg");
		connection.retrieveVehicleImage("V25");
		connection.saveImageForId("V26","C:\\Users\\A\\Desktop\\CarImage\\Chevrolet Trax.jpeg");
		connection.retrieveVehicleImage("V26");
		connection.saveImageForId("V27","C:\\Users\\A\\Desktop\\CarImage\\Chevrolet Express.jpeg");
		connection.retrieveVehicleImage("V27");
		connection.saveImageForId("V28","C:\\Users\\A\\Desktop\\CarImage\\Ford Fiesta.jpeg");
		connection.retrieveVehicleImage("V28");
		connection.saveImageForId("V29","C:\\Users\\A\\Desktop\\CarImage\\Ferrari Berlinetta.jpeg");
		connection.retrieveVehicleImage("V29");
		connection.saveImageForId("V3","C:\\Users\\A\\Desktop\\CarImage\\Cadilac ATS.jpeg");
		connection.retrieveVehicleImage("V3");
		connection.saveImageForId("V30","C:\\Users\\A\\Desktop\\CarImage\\Ferrari California.jpeg");
		connection.retrieveVehicleImage("V30");
		connection.saveImageForId("V31","C:\\Users\\A\\Desktop\\CarImage\\Infiniti Q40.jpeg");
		connection.retrieveVehicleImage("V31");
		connection.saveImageForId("V32","C:\\Users\\A\\Desktop\\CarImage\\Infiniti G35.jpeg");
		connection.retrieveVehicleImage("V32");
		connection.saveImageForId("V33","C:\\Users\\A\\Desktop\\CarImage\\Volkswagen Jetta.jpeg");
		connection.retrieveVehicleImage("V33");
		connection.saveImageForId("V34","C:\\Users\\A\\Desktop\\CarImage\\Volkswagen eGolf.jpeg");
		connection.retrieveVehicleImage("V34");
		connection.saveImageForId("V35","C:\\Users\\A\\Desktop\\CarImage\\Subaru Impreza.jpeg");
		connection.retrieveVehicleImage("V35");
		connection.saveImageForId("V36","C:\\Users\\A\\Desktop\\CarImage\\Subaru Ascent.jpeg");
		connection.retrieveVehicleImage("V36");
		connection.saveImageForId("V37","C:\\Users\\A\\Desktop\\CarImage\\Nissan Versa.jpeg");
		connection.retrieveVehicleImage("V37");
		connection.saveImageForId("V38","C:\\Users\\A\\Desktop\\CarImage\\Nissan Armada.jpeg");
		connection.retrieveVehicleImage("V38");
		connection.saveImageForId("V39","C:\\Users\\A\\Desktop\\CarImage\\Mercedes Benz GLC300.jpeg");
		connection.retrieveVehicleImage("V39");
		connection.saveImageForId("V4","C:\\Users\\A\\Desktop\\CarImage\\Toyota Highlander.jpeg");
		connection.retrieveVehicleImage("V4");
		connection.saveImageForId("V5","C:\\Users\\A\\Desktop\\CarImage\\Audi A5.jpeg");
		connection.retrieveVehicleImage("V5");
		connection.saveImageForId("V6","C:\\Users\\A\\Desktop\\CarImage\\Toyota Camry.jpeg");
		connection.retrieveVehicleImage("V6");
		connection.saveImageForId("V7","C:\\Users\\A\\Desktop\\CarImage\\Acura TLX.jpeg");
		connection.retrieveVehicleImage("V7");
		connection.saveImageForId("V8","C:\\Users\\A\\Desktop\\CarImage\\Buick Lacrosse.jpeg");
		connection.retrieveVehicleImage("V8");
		connection.saveImageForId("V9","C:\\Users\\A\\Desktop\\CarImage\\Toyota Corolla.jpeg");
		connection.retrieveVehicleImage("V9");
	}
	
}
