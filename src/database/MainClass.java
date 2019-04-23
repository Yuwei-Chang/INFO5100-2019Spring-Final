package database;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import dto.Dealer;
import dto.Vehicle;

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
		  
		  ArrayList<Dealer> list=new ArrayList<Dealer>();
			list=(ArrayList<Dealer>) connection.getAllDealers();
			Iterator<Dealer> itr=list.iterator();
			while(itr.hasNext())
	        {
	            System.out.println(itr.next());
	        }
		//images
		
		connection.saveImageForId("V1","C:\\Users\\A\\Desktop\\CarImage\\Audi A4.jpg"); 
		connection.retriveVehicleImage("V1");
		connection.saveImageForId("V10","C:\\Users\\A\\Desktop\\CarImage\\Jaguar FPace.jpeg");
		connection.retriveVehicleImage("V10");
		connection.saveImageForId("V11","C:\\Users\\A\\Desktop\\CarImage\\Kia Sedona.jpeg");
		connection.retriveVehicleImage("V11"); 
		connection.saveImageForId("V12","C:\\Users\\A\\Desktop\\CarImage\\Kia EX.jpeg");
		connection.retriveVehicleImage("V12"); 
		connection.saveImageForId("V13","C:\\Users\\A\\Desktop\\CarImage\\Land Rover Evoque.jpeg");
		connection.retriveVehicleImage("V13");
		connection.saveImageForId("V14","C:\\Users\\A\\Desktop\\CarImage\\Land Rover V8.jpeg");
		connection.retriveVehicleImage("V14");
		connection.saveImageForId("V15","C:\\Users\\A\\Desktop\\CarImage\\Mazda Mazda3.jpeg");
		connection.retriveVehicleImage("V15");
		connection.saveImageForId("V16","C:\\Users\\A\\Desktop\\CarImage\\Mazda CX9.jpeg");
		connection.retriveVehicleImage("V16");
		connection.saveImageForId("V17","C:\\Users\\A\\Desktop\\CarImage\\Volvo XC40.jpeg");
		connection.retriveVehicleImage("V17");
		connection.saveImageForId("V18","C:\\Users\\A\\Desktop\\CarImage\\Volvo S90.jpeg");
		connection.retriveVehicleImage("V18");
		connection.saveImageForId("V19","C:\\Users\\A\\Desktop\\CarImage\\Ford F150.jpeg");
		connection.retriveVehicleImage("V19");
		connection.saveImageForId("V2","C:\\Users\\A\\Desktop\\CarImage\\BMW X6.jpeg");
		connection.retriveVehicleImage("V2");
		connection.saveImageForId("V20","C:\\Users\\A\\Desktop\\CarImage\\Jeep Patriot.jpeg");
		connection.retriveVehicleImage("V20");
		connection.saveImageForId("V21","C:\\Users\\A\\Desktop\\CarImage\\Tesla Model S.jpeg");
		connection.retriveVehicleImage("V21");
		connection.saveImageForId("V22","C:\\Users\\A\\Desktop\\CarImage\\Porsche Cayenne.jpeg");
		connection.retriveVehicleImage("V22");
		connection.saveImageForId("V23","C:\\Users\\A\\Desktop\\CarImage\\Acura ILX.jpeg");
		connection.retriveVehicleImage("V23");
		connection.saveImageForId("V24","C:\\Users\\A\\Desktop\\CarImage\\Aston Martin DB9.jpeg");
		connection.retriveVehicleImage("V24");
		connection.saveImageForId("V25","C:\\Users\\A\\Desktop\\CarImage\\Honda Civic LX.jpeg");
		connection.retriveVehicleImage("V25");
		connection.saveImageForId("V26","C:\\Users\\A\\Desktop\\CarImage\\Chevrolet Trax.jpeg");
		connection.retriveVehicleImage("V26");
		connection.saveImageForId("V27","C:\\Users\\A\\Desktop\\CarImage\\Chevrolet Express.jpeg");
		connection.retriveVehicleImage("V27");
		connection.saveImageForId("V28","C:\\Users\\A\\Desktop\\CarImage\\Ford Fiesta.jpeg");
		connection.retriveVehicleImage("V28");
		connection.saveImageForId("V29","C:\\Users\\A\\Desktop\\CarImage\\Ferrari Berlinetta.jpeg");
		connection.retriveVehicleImage("V29");
		connection.saveImageForId("V3","C:\\Users\\A\\Desktop\\CarImage\\Cadilac ATS.jpeg");
		connection.retriveVehicleImage("V3");
		connection.saveImageForId("V30","C:\\Users\\A\\Desktop\\CarImage\\Ferrari California.jpeg");
		connection.retriveVehicleImage("V30");
		connection.saveImageForId("V31","C:\\Users\\A\\Desktop\\CarImage\\Infiniti Q40.jpeg");
		connection.retriveVehicleImage("V31");
		connection.saveImageForId("V32","C:\\Users\\A\\Desktop\\CarImage\\Infiniti G35.jpeg");
		connection.retriveVehicleImage("V32");
		connection.saveImageForId("V33","C:\\Users\\A\\Desktop\\CarImage\\Volkswagen Jetta.jpeg");
		connection.retriveVehicleImage("V33");
		connection.saveImageForId("V34","C:\\Users\\A\\Desktop\\CarImage\\Volkswagen eGolf.jpeg");
		connection.retriveVehicleImage("V34");
		connection.saveImageForId("V35","C:\\Users\\A\\Desktop\\CarImage\\Subaru Impreza.jpeg");
		connection.retriveVehicleImage("V35");
		connection.saveImageForId("V36","C:\\Users\\A\\Desktop\\CarImage\\Subaru Ascent.jpeg");
		connection.retriveVehicleImage("V36");
		connection.saveImageForId("V37","C:\\Users\\A\\Desktop\\CarImage\\Nissan Versa.jpeg");
		connection.retriveVehicleImage("V37");
		connection.saveImageForId("V38","C:\\Users\\A\\Desktop\\CarImage\\Nissan Armada.jpeg");
		connection.retriveVehicleImage("V38");
		connection.saveImageForId("V39","C:\\Users\\A\\Desktop\\CarImage\\Mercedes Benz GLC300.jpeg");
		connection.retriveVehicleImage("V39");
		connection.saveImageForId("V4","C:\\Users\\A\\Desktop\\CarImage\\Toyota Highlander.jpeg");
		connection.retriveVehicleImage("V4");
		connection.saveImageForId("V5","C:\\Users\\A\\Desktop\\CarImage\\Audi A5.jpeg");
		connection.retriveVehicleImage("V5");
		connection.saveImageForId("V6","C:\\Users\\A\\Desktop\\CarImage\\Toyota Camry.jpeg");
		connection.retriveVehicleImage("V6");
		connection.saveImageForId("V7","C:\\Users\\A\\Desktop\\CarImage\\Acura TLX.jpeg");
		connection.retriveVehicleImage("V7");
		connection.saveImageForId("V8","C:\\Users\\A\\Desktop\\CarImage\\Buick Lacrosse.jpeg");
		connection.retriveVehicleImage("V8");
		connection.saveImageForId("V9","C:\\Users\\A\\Desktop\\CarImage\\Toyota Corolla.jpeg");
		connection.retriveVehicleImage("V9");
	}
	
}
