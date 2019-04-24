package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class AddCarUI extends JFrame {
    private JPanel top, main, bottom;
    private JLabel vehicleIdLabel, modelLabel, makeLabel, typeLabel, seatCountLabel, mileageLabel, priceLabel, yearLabel, categoryLabel;
    private JTextField vehicleIdText, modelText,makeText, typeText, seatCountText, mileageText, priceText, yearText, categoryText;
    private JButton submitButton;

    public AddCarUI() {
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
        bottom = new JPanel(new GridLayout(5, 1, 30, 30));
        bottom.setBounds(100, 70, 300, 250);
        bottom.setLocation(350, 340);

        //Brand
        vehicleIdLabel = new JLabel("VehicleID:");
        vehicleIdText = new JTextField();
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

        //Submit
        submitButton = new JButton("Add");
        submitButton.setFocusPainted(false);
        submitButton.setBounds(150, 200, 90, 30);
        submitButton.setLocation(440, 590);
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

               // dispose();

                String URL = "jdbc:sqlserver://is-swang01.ischool.uw.edu;databaseName=Car_Inventory";
                String USER = "";
                String PASS = "";
                try {
                    InputStream input = new FileInputStream("DB.properties");
                    Properties prop = new Properties();
                    prop.load(input);
                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                    Connection conn = DriverManager.getConnection(URL, prop.getProperty("USER"), prop.getProperty("PASS"));

                    PreparedStatement p = conn.prepareStatement("select * from  dbo.Vehicle WHERE Vehicleid ="+"'"+vehicleIdText.getText()+"'");
                    ResultSet r=p.executeQuery();

                    if(r.next()==false) {
                        PreparedStatement ps = conn.prepareStatement("Insert into dbo.Vehicle values('"
                                +vehicleIdText.getText()+"','"+categoryText.getText()+"','"+yearText.getText()
                                +"','"+makeText.getText()+"','"+modelText.getText()+"','"+typeText.getText()
                                +"','"+seatCountText.getText()+"','"+mileageText.getText()+"','"+priceText.getText()+"');");
                        ps.executeUpdate();
                        JOptionPane.showMessageDialog(null, "Vehicle is Successfully Added");

                    }

                } catch (ClassNotFoundException c) {
                    c.printStackTrace();
                } catch (Exception s) {
                    JOptionPane.showMessageDialog(null, "Vehicle already exists");
                }
            }
        });
    }




}
