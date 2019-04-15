//package ui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.TitledBorder;

public class SearchDealerUI extends JFrame{
	
	//protected JLabel nameLabel, zipCodeLabel;
	protected JTextField nameText, zipCodeText;
	protected JButton search;
	protected JRadioButton someRadioButton1;
	protected JRadioButton someRadioButton2;
	protected ButtonGroup myButtonGroup;
	JPanel jpanel;
	protected JButton dealerInventory;
	
	public SearchDealerUI() {
		createComponents();
		addComponents();
		addListeners();
		makeItVisible();
		nameText.setEnabled(false);
		zipCodeText.setEnabled(false);
	}
	
	private void createComponents() {
		//nameLabel = new JLabel("Dealer Name", JLabel.RIGHT);
		//zipCodeLabel = new JLabel("Zip code", JLabel.RIGHT);
		nameText = new JTextField(10);
		//nameText.setLocation(10,10);
		
		zipCodeText = new JTextField(10);
		search = new JButton("Search");
		someRadioButton1= new JRadioButton("Dealers Name");
		someRadioButton2= new JRadioButton("ZipCode");
		myButtonGroup = new ButtonGroup();
		dealerInventory = new JButton("DealerInventory");
		
	}
	public void addComponents() {
		Container con = this.getContentPane();
		con.setLayout(new BorderLayout());

		// TODO Auto-generated method stub
		jpanel = new JPanel();
		jpanel.setLayout(new GridLayout(3, 2));
		TitledBorder border = new TitledBorder("Dealers in Seattle, WA");
	    border.setTitleJustification(TitledBorder.CENTER);
	    border.setTitlePosition(TitledBorder.TOP);
	 
	    jpanel.setBorder(border);
	    
		//jpanel.add(nameLabel);
		
		//jpanel.add(zipCodeLabel);
		
	
		jpanel.add(someRadioButton1);
		jpanel.add(nameText);
		jpanel.add(someRadioButton2);
		jpanel.add(zipCodeText);
		jpanel.add(search);
		jpanel.add(dealerInventory);
		con.add(jpanel, "Center");
		
		myButtonGroup.add(someRadioButton1);
		myButtonGroup.add(someRadioButton2);
		
		

	}
	public void addListeners() {
		search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String name = nameText.getText();
				String zipcode = zipCodeText.getText();
				System.out.println(name +"  "+zipcode);
			}
		});
		someRadioButton1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (someRadioButton1.isSelected()) {
					nameText.setEnabled(true);
					zipCodeText.setText("");
			    }
			}
		});
		someRadioButton2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (someRadioButton2.isSelected()) {
					zipCodeText.setEnabled(true);
					nameText.setText("");
			    }
			}
		});
		
	}
	
	
	private void makeItVisible() {
		this.setSize(500, 300);
		this.setVisible(true);
		//this.pack();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args)  {
		SearchDealerUI s= new SearchDealerUI();
		
		
	}
}
