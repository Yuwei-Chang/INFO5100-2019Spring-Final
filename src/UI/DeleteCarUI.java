package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;



public class DeleteCarUI extends JFrame{

	public DeleteCarUI(){
		
		Container delcontainer= getContentPane();
		delcontainer.setLayout(new BorderLayout());
		delcontainer.setBackground(new Color(244, 167, 66));
		
		JPanel panel=new JPanel(new GridBagLayout());
		delcontainer.add(panel,BorderLayout.CENTER);
		JLabel label=new JLabel("Vehicleid:");
		Font f=new Font("Arial", Font.BOLD, 20);
		//label.setForeground(new Color(199, 139, 100));
		label.setFont(f);
		JLabel label2 = new JLabel("V1");
		label2.setFont(f);
		//label2.setForeground(new Color(199, 139, 100));
		GridBagConstraints c= new GridBagConstraints();
		c.insets= new Insets(10,10,10,10);
		c.gridx=5;
		c.gridy=7;
		panel.add(label, c);
		c.gridx=6;
		c.gridy=7;		
		panel.add(label2, c);
		//panel.setBounds(10, 10, 20, 20);
		panel.setOpaque(false);
		JPanel panel2=new JPanel(new GridBagLayout());	
		JButton OkayButton=new JButton("OK");
		JButton CancelButton=new JButton("Cancel");
		OkayButton.setFont(f);
		CancelButton.setFont(f);
		Color cl= new Color(244, 103, 65);
		OkayButton.setBackground(cl);
		CancelButton.setBackground(cl);
		OkayButton.setFocusPainted(false);
		OkayButton.setFocusPainted(false);
		c.insets= new Insets(10,10,10,10);
		c.gridx=4;
		c.gridy=8;
		panel2.add(OkayButton,c);
		c.gridx=5;
		c.gridy=8;
		panel2.add(CancelButton,c);
		//panel2.add(OkayButton, BorderLayout.CENTER);
		//panel2.setBounds(5, 5, 10, 10);
		panel2.setOpaque(false);
		delcontainer.add(panel2,BorderLayout.SOUTH);
		
		//set window size
		setSize(400, 200);
		setResizable(false);
		setUndecorated(true);
	    int windowWidth = this.getWidth();
	    int windowHeight = this.getHeight();   
	    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	    int screenWidth = screenSize.width;
	    int screenHeight = screenSize.height;
	    this.setLocation(screenWidth/2-windowWidth/2, screenHeight/2-windowHeight/2);
	    
		setTitle("Confirm Delete");	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		OkayButton.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent d) {
				
				dispose();
				
				String URL = "jdbc:sqlserver://is-swang01.ischool.uw.edu;databaseName=Car_Inventory";
				String USER = "INFO6210";
				String PASS = "NEUHusky!";
				
				try {
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					Connection conn = DriverManager.getConnection(URL, USER, PASS);
					PreparedStatement p = conn.prepareStatement("select * from  dbo.Inventory WHERE Vehicleid ="+"'"+label2.getText()+"'");
					ResultSet r=p.executeQuery();
					
					if(r.next()==true) {
					PreparedStatement ps = conn.prepareStatement("Delete from  dbo.Inventory WHERE Vehicleid ="+"'"+label2.getText()+"'");
					ps.executeUpdate();
					JOptionPane.showMessageDialog(null, "Vehicle Successfully Deleted from Inventory");
					setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

					}
					
					else {
						JOptionPane.showMessageDialog(null, "Vehicle not available in Inventory");
						setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

					}
					
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
				
				
		});
		
//		CancelButton.addActionListener(new ActionListener() {
//			
//			public void actionPerformed(ActionEvent c) {
//				
//				SwingTest.class
//			}
//			
//		});
//		
	}	

}


