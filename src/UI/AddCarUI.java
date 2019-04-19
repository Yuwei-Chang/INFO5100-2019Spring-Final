package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AddCarUI extends JFrame{
    public AddCarUI() {
        Container container = getContentPane();
        container.setLayout(null);


        JPanel top = new JPanel(new GridLayout(2, 1, 30, 30));
        top.setBounds(50, 70, 300, 80);
        top.setLocation(350, 120);
        JPanel main = new JPanel(new GridLayout(2, 1, 30, 30));
        main.setBounds(180, 70, 300, 80);
        main.setLocation(350, 230);
        JPanel bottom = new JPanel(new GridLayout(2, 1, 30, 30));
        bottom.setBounds(100, 70, 300, 200);
        bottom.setLocation(350, 340);

        //Brand
        JLabel VehicleIdLabel = new JLabel("VehicleID:");
        JTextField VehicleIdText = new JTextField();
        //Model
        JLabel ModelLabel = new JLabel("Model:");
        JTextField ModelText = new JTextField();
        //Make
        JLabel MakeLabel = new JLabel("Make:");
        JTextField MakeText = new JTextField();
        //Type
        JLabel TypeLabel = new JLabel("Type:");
        JTextField TypeText = new JTextField();
        //SeatCount
        JLabel SeatCountLabel = new JLabel("SeatCount:");
        JTextField SeatCountText = new JTextField();
        //Mileage
        JLabel MileageLabel = new JLabel("Mileage:");
        JTextField MileageText = new JTextField();
        //Price
        JLabel PriceLabel = new JLabel("Price:");
        JTextField PriceText = new JTextField();
        //Year
        JLabel YearLabel = new JLabel("Year:");
        JTextField YearText = new JTextField();
        //Category
        JLabel CategoryLabel = new JLabel("Category:");
        JTextField CategoryText = new JTextField();

        //Submit
        JButton submitButton = new JButton("Add");
        submitButton.setFocusPainted(false);
        submitButton.setBounds(150, 200, 90, 30);
        submitButton.setLocation(440, 590);

        top.add(VehicleIdLabel);
        top.add(VehicleIdText);
        top.add(ModelLabel);
        top.add(ModelText);
        main.add(PriceLabel);
        main.add(PriceText);
        main.add(YearLabel);
        main.add(YearText);
        bottom.add(CategoryLabel);
        bottom.add(CategoryText);
        bottom.add(SeatCountLabel);
        bottom.add(SeatCountText);
        bottom.add(MakeLabel);
        bottom.add(MakeText);
        bottom.add(MileageLabel);
        bottom.add(MileageText);
        bottom.add(TypeLabel);
        bottom.add(TypeText);


        container.add(top);
        container.add(main);
        container.add(bottom);
        container.add(submitButton);


        setSize(1300, 800);
        setTitle("Add Page");
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        submitButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				if(VehicleIdText.getText().isEmpty()) {
					dispose();
					JOptionPane.showMessageDialog(null, "Vehicle is not Added");
					 setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
				}
			
				String URL = "jdbc:sqlserver://is-swang01.ischool.uw.edu;databaseName=Car_Inventory";
				String USER = "INFO6210";
				String PASS = "NEUHusky!";
				
				
				try {
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					Connection conn = DriverManager.getConnection(URL, USER, PASS);
					PreparedStatement p = conn.prepareStatement("select * from  dbo.Vehicle WHERE Vehicleid ="+"'"+VehicleIdText.getText()+"'");
					ResultSet r=p.executeQuery();
					
					if(r.next()==false) {
					PreparedStatement ps = conn.prepareStatement("Insert into dbo.Vehicle values('"
											+VehicleIdText.getText()+"','"+CategoryText.getText()+"','"+YearText.getText()
											+"','"+MakeText.getText()+"','"+ModelText.getText()+"','"+TypeText.getText()
											+"','"+SeatCountText.getText()+"','"+MileageText.getText()+"','"+PriceText.getText()+"');");
					ps.executeUpdate();
					JOptionPane.showMessageDialog(null, "Vehicle is Successfully Added");
					
					}
					
				} catch (ClassNotFoundException c) {
					// TODO Auto-generated catch block
					c.printStackTrace();
				} catch (SQLException s) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "Vehicle alreay exists");
				}
			}
        });


    }
}
