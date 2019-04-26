package database;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class VehiclesSearchResult {

    DatabaseConnection dbObj =new DatabaseConnection();

    String URL = "jdbc:sqlserver://is-swang01.ischool.uw.edu;"
            + "databaseName=Car_Inventory";
    String USER = "";
    String PASS = "";

    public List getMake() {
//        List makeList=new ArrayList<String>();
//        try {
//            InputStream input = new FileInputStream("src/database/connection.properties");
//            Properties prop=new Properties();
//            prop.load(input);
//            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//            Connection conn = DriverManager.getConnection(URL, prop.getProperty("username"), prop.getProperty("password"));
//
//            PreparedStatement statement =conn.prepareStatement("SELECT DISTINCT Make from  dbo.vehicle" );
//            ResultSet rs = statement.executeQuery();
//
//            while (rs.next()) {
//                makeList.add(rs.getString(1));
//            }
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
//        return makeList;

        return  dbObj.getMake1();
    }

    public List getModel() {
//        List modelList=new ArrayList<String>();
//
//        // GetMakeandModel makeandModel = new GetMakeandModel();
//        try {
//            InputStream input = new FileInputStream("src/database/connection.properties");
//            Properties prop=new Properties();
//            prop.load(input);
//            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//            Connection conn = DriverManager.getConnection(URL, prop.getProperty("username"), prop.getProperty("password"));
//
//            PreparedStatement statement =conn.prepareStatement("SELECT DISTINCT Model from  dbo.vehicle" );
//            ResultSet rs = statement.executeQuery();
//
//            while(rs.next()) {
//                modelList.add(rs.getString(1));
//            }
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
//        return modelList;

   return dbObj.getModel1();
   }
}
