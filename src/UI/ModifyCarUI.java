package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;
import database.DatabaseConnection;

public class ModifyCarUI extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel top;
    private JPanel main;
    private JPanel bottom;
    private JLabel vehicleidLabel, modelLabel, priceLabel, yearLabel, categoryLabel;
    private JButton submitButton;
    private JTextField vehicleidText, modelText, priceText, yearText, categoryText;
    private Vehicle myVehicle;
    private String vehicleId;

    public ModifyCarUI(String vehicleId) {
        myVehicle = new DatabaseConnection().getVehicle(vehicleId); //get all the information of the modifyCar
//    	myVehicle = new Vehicle();      //just for test
//    	myVehicle.setPrice("889");		//just for test
        this.vehicleId = vehicleId;
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
        bottom = new JPanel(new GridLayout(2, 1, 30, 30));
        bottom.setBounds(100, 70, 300, 200);
        bottom.setLocation(350, 340);

        //Brand
        vehicleidLabel = new JLabel("VehicleID:");
        vehicleidText = new JTextField();
        vehicleidText.setText(myVehicle.getMake());
        //Model
        modelLabel = new JLabel("Model:");
        modelText = new JTextField();
        modelText.setText(myVehicle.getModel());
        //Price
        priceLabel = new JLabel("Price:");
        priceText = new JTextField();
        priceText.setText(myVehicle.getPrice());
        //Year
        yearLabel = new JLabel("Year:");
        yearText = new JTextField();
        yearText.setText(myVehicle.getYear());
        //Category
        categoryLabel = new JLabel("Category:");
        categoryText = new JTextField();
        categoryText.setText(myVehicle.getCategory());

        //Submit
        submitButton = new JButton("Modify");
        submitButton.setFocusPainted(false);
        submitButton.setBounds(150, 200, 90, 30);
        submitButton.setLocation(440, 590);

    }

    void addComponents() {
        Container container = getContentPane();
        container.setLayout(null);
        top.add(vehicleidLabel);
        top.add(vehicleidText);
        top.add(modelLabel);
        top.add(modelText);
        main.add(priceLabel);
        main.add(priceText);
        main.add(yearLabel);
        main.add(yearText);
        bottom.add(categoryLabel);
        bottom.add(categoryText);

        container.add(top);
        container.add(main);
        container.add(bottom);
        container.add(submitButton);
    }

    void makeItVisible() {
        setSize(1000, 800);
        setTitle("Modify Page");
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    void addListeners(){

        submitButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                dispose();

                String URL = "jdbc:sqlserver://is-swang01.ischool.uw.edu;databaseName=Car_Inventory";
                String USER = "";
                String PASS = "";

                try {
                    InputStream input = new FileInputStream("DB.properties");
                    Properties prop = new Properties();
                    prop.load(input);
                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                    Connection conn = DriverManager.getConnection(URL, prop.getProperty("USER"), prop.getProperty("PASS"));

                    PreparedStatement p = conn.prepareStatement("select * from  dbo.Vehicle WHERE Vehicleid ='"+vehicleidText.getText()+"'");
                    ResultSet r=p.executeQuery();

                    if(r.next()==true) {
                        PreparedStatement ps = conn.prepareStatement("select Model,Price, Category, Year from Vehicle where Vehicleid='"+vehicleidText.getText()+"';\n"
                                +"update dbo.Vehicle set Model='"+modelText.getText()
                                +"',Price='"+priceText.getText()+"',Category='"+categoryText.getText()
                                +"',Year='"+yearText.getText()+"' where Vehicleid='"+vehicleidText.getText()+"'");

                        ResultSet rs=ps.executeQuery();
                        JOptionPane.showMessageDialog(null, "Vehicle is Successfully Modified");
                    }

                    else {
                        JOptionPane.showMessageDialog(null,"Vehicle not found");
                    }

                } catch (ClassNotFoundException c) {
                    c.printStackTrace();
                } catch (SQLException s) {
                    s.printStackTrace();
                } catch (Exception exp) {
                    exp.printStackTrace();
                }
            }
        });


    }
}





