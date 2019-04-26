package UI;

import database.DatabaseConnection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.*;
import java.util.*;
//import java.util.Properties;

public class AddCarUI extends JFrame {
    private JPanel top, main, bottom;
    private JLabel vehicleIdLabel, modelLabel, makeLabel, typeLabel, seatCountLabel, mileageLabel, priceLabel, yearLabel, categoryLabel,ZipcodeLabel;
    private JTextField vehicleIdText, modelText, makeText, typeText, seatCountText, mileageText, priceText, yearText, categoryText,ZipcodeText;
    private JButton submitButton;
    private String dealerID;
    DatabaseConnection dbObj=new DatabaseConnection();


    UUID uid=UUID.randomUUID();
    String uuid=Long.toString(uid.getMostSignificantBits(),1).replaceAll("-","").replaceAll("[a-z]", "");
    //int vehicleid=Integer.parseInt(uuid);

//    UUID uuid = UUID.randomUUID().;
//    //String vid = ByteBuffer.wrap(uuid.toString().getBytes()).toString();
//    //String vid=Long.toString(l, Integer.BYTES);

    public AddCarUI(String dealerID) {
        this.dealerID=dealerID;
        createComponents();
        addComponents();
        addListeners();
        makeItVisible();
    }

    void createComponents() {
        top = new JPanel(new GridLayout(2, 1, 30, 30));
        top.setBounds(50, 70, 300, 80);
        top.setLocation(350, 120);
        main = new JPanel(new GridLayout(2, 1, 30, 30));
        main.setBounds(180, 70, 300, 80);
        main.setLocation(350, 230);
        bottom = new JPanel(new GridLayout(6, 1, 30, 30));
        bottom.setBounds(100, 70, 300, 300);
        bottom.setLocation(350, 340);
System.out.println(dealerID);

        uuid="v"+uuid.substring(0, 3);


        //Brand
        vehicleIdLabel = new JLabel("VehicleID:");
        vehicleIdText = new JTextField(uuid);
        vehicleIdText.setEditable(false);

        //Model
        modelLabel = new JLabel("Model:");
        modelText = new JTextField();
        //Make
        makeLabel = new JLabel("Make:");
        makeText = new JTextField();
        //Type
        typeLabel = new JLabel("Type:");
        typeText = new JTextField();
        //SeatCount
        seatCountLabel = new JLabel("SeatCount:");
        seatCountText = new JTextField();
        //Mileage
        mileageLabel = new JLabel("Mileage:");
        mileageText = new JTextField();
        //Price
        priceLabel = new JLabel("Price:");
        priceText = new JTextField();
        //Year
        yearLabel = new JLabel("Year:");
        yearText = new JTextField();
        //Category
        categoryLabel = new JLabel("Category:");
        categoryText = new JTextField();

        //Zipcode
        ZipcodeLabel= new JLabel("Zipcode:");
        ZipcodeText=new JTextField();

        //Submit
        submitButton = new JButton("Add");
        submitButton.setFocusPainted(false);
        submitButton.setBounds(150, 200, 90, 30);
        submitButton.setLocation(450, 650);
    }
    void addComponents() {
        Container container = getContentPane();
        container.setLayout(null);
        top.add(vehicleIdLabel);
        top.add(vehicleIdText);
        top.add(modelLabel);
        top.add(modelText);
        main.add(priceLabel);
        main.add(priceText);
        main.add(yearLabel);
        main.add(yearText);
        bottom.add(categoryLabel);
        bottom.add(categoryText);
        bottom.add(seatCountLabel);
        bottom.add(seatCountText);
        bottom.add(makeLabel);
        bottom.add(makeText);
        bottom.add(mileageLabel);
        bottom.add(mileageText);
        bottom.add(typeLabel);
        bottom.add(typeText);
        bottom.add(ZipcodeLabel);
        bottom.add(ZipcodeText);
        container.add(top);
        container.add(main);
        container.add(bottom);
        container.add(submitButton);


    }
    void makeItVisible()
    {
        setSize(900, 1800);
        setTitle("Add Page");
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    void addListeners(){
        submitButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {


                String URL = "jdbc:sqlserver://is-swang01.ischool.uw.edu;databaseName=Car_Inventory";
                String USER = "";
                String PASS = "";
                try {
                    InputStream input = new FileInputStream("src/database/connection.properties");
                    Properties prop = new Properties();
                    prop.load(input);
                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                    Connection conn = DriverManager.getConnection(URL, prop.getProperty("username"), prop.getProperty("password"));

                    PreparedStatement p = conn.prepareStatement("select * from  dbo.Vehicle WHERE Vehicleid ="+"'"+ vehicleIdText.getText()+"'");
                    ResultSet r=p.executeQuery();

                    if(r.next()==false) {
                        PreparedStatement ps = conn.prepareStatement("Insert into dbo.Vehicle values('"
                                +uuid+"','"+ categoryText.getText()+"','"+ yearText.getText()
                                +"','"+ makeText.getText()+"','"+ modelText.getText()+"','"+ typeText.getText()
                                +"','"+ seatCountText.getText()+"','"+ mileageText.getText()+"','"+ priceText.getText()+"','"+ZipcodeText.getText()+"');\n"
                                +"Insert into dbo.Inventory values('"+dealerID+"','"+uuid+"');");
                        System.out.println("Insert into dbo.Vehicle values('"
                                +uuid+"','"+ categoryText.getText()+"','"+ yearText.getText()
                                +"','"+ makeText.getText()+"','"+ modelText.getText()+"','"+ typeText.getText()
                                +"','"+ seatCountText.getText()+"','"+ mileageText.getText()+"','"+ priceText.getText()+"','"+ZipcodeText.getText()+"');\n"
                                +"Insert into dbo.Inventory values('"+dealerID+"','"+uuid+"');");
                        ps.executeUpdate();
                        JOptionPane.showMessageDialog(null, "Vehicle is Successfully Added");
                    }

                } catch (ClassNotFoundException c) {
                    c.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Add Vehicle insert error");

                } catch (Exception s) {
                   s.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Vehicle already exists");
                }
                dispose();
            }
        });
    }

}

