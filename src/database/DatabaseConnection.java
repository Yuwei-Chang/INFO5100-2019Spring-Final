package database;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import dto.Dealer;
import dto.Inventory;
import dto.Vehicle;
import persist.DealersManager;

public class DatabaseConnection implements DealersManager{

	String URL = "jdbc:sqlserver://is-swang01.ischool.uw.edu;databaseName=Car_Inventory";
	String USER = "";
	String PASS = "";

	public void getUserNameAndPassword() {
		try {
			InputStream input = new FileInputStream(
					"D:\\eclipse-workspace\\JavaFinalProject\\src\\database\\connection.properties");
			Properties prop = new Properties();
			// load a properties file
			prop.load(input);

			USER = prop.getProperty("username");
			PASS = prop.getProperty("password");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Vehicle retriveVehicleFromDatabase(String vehicleId) {
		getUserNameAndPassword();
		Vehicle vehicle = new Vehicle();
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = DriverManager.getConnection(URL, USER, PASS);

			PreparedStatement statement = conn
					.prepareStatement("SELECT * from  dbo.Vehicle WHERE vehicleId = ? ");
			statement.setString(1, vehicleId);


			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				vehicle.setVehicleId(rs.getString("Vehicleid"));
				vehicle.setCategory(rs.getString("Category"));
				vehicle.setYear(String.valueOf(rs.getInt("Year")));
				vehicle.setMake(rs.getString("Make"));
				vehicle.setModel(rs.getString("Model"));
				vehicle.setType(rs.getString("Type"));
				vehicle.setSeatCount(String.valueOf(rs.getInt("SeatCount")));
				vehicle.setMilaege(rs.getString("Mileage"));
				vehicle.setPrice(rs.getString("Price"));
				vehicle.setZipCode(String.valueOf(rs.getInt("ZipCode")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vehicle;
	}

	public Dealer retriveDealerFromDatabase(String Dealerid) {
		getUserNameAndPassword();
		Dealer dealer = new Dealer();
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = DriverManager.getConnection(URL, USER, PASS);
			PreparedStatement statement = conn.prepareStatement("SELECT * from  dbo.Dealer WHERE  Dealerid = ?");
			statement.setString(1, Dealerid);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				dealer.setDealerId(rs.getString("Dealerid"));
				dealer.setDealerName(rs.getString("DealerName"));
				dealer.setDealerAddress(rs.getString("DealerAddress"));
				dealer.setZipCode(rs.getInt("ZipCode"));
				dealer.setPhoneNumber(rs.getInt("PhoneNumber"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dealer;
	}
	@Override
	public ArrayList<Dealer> getAllDealers() {
		ArrayList<Dealer> dealerObjList = new ArrayList<>();
		//Dealer dealer = new Dealer();
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = DriverManager.getConnection(URL, USER, PASS);
			PreparedStatement statement =conn.prepareStatement("SELECT * from  dbo.Dealer");
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {

				dealerObjList.add( new Dealer(rs.getString(2),rs.getString(3),rs.getString(1),rs.getInt(4),rs.getInt(5)));


			}

		}catch (Exception e) {
			e.printStackTrace();
		}
		return dealerObjList;
	}

	public Inventory retriveInventoryFromDatabase(String Dealerid, String Vehicleid) {
		getUserNameAndPassword();
		Inventory inventory = new Inventory();
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = DriverManager.getConnection(URL, USER, PASS);
			PreparedStatement statement = conn.prepareStatement("SELECT * from  dbo.Inventory WHERE  Dealerid = ? and Vehicleid = ?");
			statement.setString(1, Dealerid);
			statement.setString(1, Vehicleid);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				inventory.setDealerId(rs.getString("Dealerid"));
				inventory.setVehicleId(rs.getString("Vehicleid"));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return inventory;
	}

	public List<Vehicle> getVehiclesForDealer(String dealerId)
	{

		getUserNameAndPassword();
		List<Vehicle> vehicleList = new ArrayList<>();
		List<String> vehicleIds = new ArrayList<>();
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = DriverManager.getConnection(URL, USER, PASS);
			PreparedStatement statement = conn.prepareStatement("select * from dbo.Inventory where Dealerid = ?");
			statement.setString(1, dealerId);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				vehicleIds.add(rs.getString("Vehicleid"));
			}

			for(String vechileId : vehicleIds)
			{
				Vehicle vechile = retriveVehicleFromDatabase(vechileId);
				vehicleList.add(vechile);
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return vehicleList;
	}
}