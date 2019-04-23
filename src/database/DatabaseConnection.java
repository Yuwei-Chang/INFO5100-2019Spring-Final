package database;
import dto.Dealer;
import dto.Inventory;
import dto.Vehicle;


import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class DatabaseConnection {

    String URL = "jdbc:sqlserver://is-swang01.ischool.uw.edu;databaseName=Car_Inventory";
    String USER = "";
    String PASS = "";

    public void getUserNameAndPassword() {
        try {
            InputStream input = new FileInputStream(
                    ".\\src\\database\\connection.properties");
            Properties prop = new Properties();
            // load a properties file
            prop.load(input);

            USER = prop.getProperty("username");
            PASS = prop.getProperty("password");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public Vehicle getVehicle(String vehicleId) {
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
                vehicle.setYear(rs.getInt("Year"));
                vehicle.setMake(rs.getString("Make"));
                vehicle.setModel(rs.getString("Model"));
                vehicle.setType(rs.getString("Type"));
                vehicle.setSeatCount(rs.getInt("SeatCount"));
                vehicle.setMileage(rs.getInt("Mileage"));
                vehicle.setPrice(rs.getString("Price"));
                vehicle.setZipCode(rs.getInt("ZipCode"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return vehicle;
    }

    public Dealer getDealer(String Dealerid) {
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
                dealer.setPhoneNumber(rs.getLong("PhoneNumber"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dealer;
    }

    public ArrayList<Dealer> getAllDealers() {
        getUserNameAndPassword();
        ArrayList<Dealer> dealerObjList = new ArrayList<>();
        //Deale000000r dealer = new Dealer();
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = DriverManager.getConnection(URL, USER, PASS);
            PreparedStatement statement =conn.prepareStatement("SELECT * from  dbo.Dealer");
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {

                dealerObjList.add( new Dealer(rs.getString("Dealerid"),rs.getString("DealerName"),rs.getString("DealerAddress"),rs.getInt("ZipCode"),rs.getLong("PhoneNumber")));
            }

        }catch (Exception e) {
            e.printStackTrace();
        }
        return dealerObjList;
    }

    public Inventory getInventory(String Dealerid, String Vehicleid) {
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

            for(String vehicleId : vehicleIds)
            {
                Vehicle vehicle = getVehicle(vehicleId);
                vehicleList.add(vehicle);
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return vehicleList;
    }
    public List<Vehicle> getVehicleForMakeMOdelCategory(String dealerId,String make,String model,String category)
    {

        getUserNameAndPassword();
        List<Vehicle> vehicleList1 = new ArrayList<>();
        List<String> vehicleIds = new ArrayList<>();
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = DriverManager.getConnection(URL, USER, PASS);
            PreparedStatement statement = conn.prepareStatement("select v.Vehicleid , v.Category, v.Make, v.Model from dbo.inventory i join dbo.Dealer d on i.Dealerid=d.Dealerid join dbo.Vehicle v on i.Vehicleid= v.vehicleid where d.Dealerid = ? and v.Category=? and v.Make=? and v.Model=?");
            statement.setString(1, dealerId);
            statement.setString(2, category);
            statement.setString(3, make);
            statement.setString(4, model);


            ResultSet rs = statement.executeQuery();
            System.out.println("Result Size " + rs.getFetchSize());
            while (rs.next()) {
                System.out.println("Vehicle Id " + rs.getString("Category"));
                vehicleIds.add(rs.getString("Vehicleid"));
            }

            for(String vehicleId : vehicleIds)
            {
                Vehicle vehicle = getVehicle(vehicleId);
                vehicleList1.add(vehicle);
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return vehicleList1;
    }

    public void saveImageForId(String vehicleId, String imageLocation) {
        try
        {
            getUserNameAndPassword();
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = DriverManager.getConnection(URL, USER, PASS);
            File file = new File(imageLocation);
            FileInputStream fis = new FileInputStream(file);
            int len = (int)file.length();
            String query = "INSERT INTO CARIMAGES values(?,?)";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1,vehicleId );
            pstmt.setBinaryStream(2, fis, len);
            pstmt.execute();
            pstmt.close();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }

    public void retrieveVehicleImage(String vehicleId)
    {
        try
        {
            getUserNameAndPassword();
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = DriverManager.getConnection(URL, USER, PASS);
            PreparedStatement statement = conn.prepareStatement("select * from CARIMAGES where Vehicleid=?");
            statement.setString(1, vehicleId);
            ResultSet rs = statement.executeQuery();
            byte[] fileBytes;
            while (rs.next()) {
                fileBytes = rs.getBytes("FileStreamCol");
                OutputStream targetFile=
                        new FileOutputStream(
                                "C://Users//A//Desktop//Cars//" + vehicleId + ".JPG");
                targetFile.write(fileBytes);
                targetFile.close();
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
}

