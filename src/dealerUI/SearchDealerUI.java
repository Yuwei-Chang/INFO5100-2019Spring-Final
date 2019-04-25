package dealerUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import dto.Dealer;
import searchDealerLogic.SearchDealerResult;

public class SearchDealerUI extends JFrame{
	
	private JLabel distanceRange;
	private JTextField nameText, zipCodeText;
	private JComboBox c1;
	private JButton search;
	private JRadioButton radioButtonName;
	private JRadioButton radioButtonZipCode;
	private ButtonGroup myButtonGroup;
	private JPanel jpanel;
	private JButton dealerInventory;
	private SearchDealerResult newObj = new SearchDealerResult();
	private boolean isNameOption=false;
	private boolean isZipCodeOption=false;
	ArrayList<Dealer> nameMatchResult = new ArrayList<>();
	ArrayList<Dealer> zipCodeMatchResult = new ArrayList<>();
	String s1[] = { "10", "20", "30", "40"};

	public SearchDealerUI() {
		createComponents();
		addComponents();
		addListeners();
		makeItVisible();
		nameText.setEnabled(false);
		zipCodeText.setEnabled(false);
	}
	
	private void createComponents() {
		distanceRange = new JLabel("Distance Range", JLabel.LEFT);
		nameText = new JTextField(10);
		//nameText.setLocation(10,10);
		c1 = new JComboBox(s1);
		zipCodeText = new JTextField(10);
		search = new JButton("Search");
		radioButtonName= new JRadioButton("Select this option to enter Dealers Name");
		radioButtonZipCode= new JRadioButton("Select this option to search Dealers near you. Enter your Zipcode");
		myButtonGroup = new ButtonGroup();
		dealerInventory = new JButton("DealerInventory");
		
	}
	public void addComponents() {
		Container con = this.getContentPane();
		con.setLayout(new BorderLayout());

		jpanel = new JPanel();
		jpanel.setLayout(new GridLayout(4, 2));
		TitledBorder border = new TitledBorder("Dealers in Seattle, WA");
	    border.setTitleJustification(TitledBorder.CENTER);
	    border.setTitlePosition(TitledBorder.TOP);
	    jpanel.setBorder(border);
		jpanel.add(radioButtonName);
		jpanel.add(nameText);
		jpanel.add(radioButtonZipCode);
		jpanel.add(zipCodeText);
		jpanel.add(distanceRange);
		jpanel.add(c1);
		jpanel.add(search);
		jpanel.add(dealerInventory);
		con.add(jpanel, "Center");

		myButtonGroup.add(radioButtonName);
		myButtonGroup.add(radioButtonZipCode);



	}

	public void addListeners() {
		search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				if(isNameOption){
					
					nameMatchResult= newObj.getDealerObjListByName(nameText.getText());
					ListOfDealerUI listDealerDisplay= new ListOfDealerUI(nameMatchResult);
				}
				else if(isZipCodeOption){
					try {
						String text = (String)c1.getSelectedItem();
						int value = Integer.parseInt(text);
						zipCodeMatchResult= newObj.getDealerObjListByDistance(Integer.parseInt(zipCodeText.getText()),value);
						ListOfDealerUI listDealerDisplay= new ListOfDealerUI(zipCodeMatchResult);
					} catch (NumberFormatException | IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		radioButtonName.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (radioButtonName.isSelected()) {
					nameText.setEnabled(true);
					isNameOption=true;
					zipCodeText.setText("");
					zipCodeText.setEnabled(false);
			    }
			}
		});
		radioButtonZipCode.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (radioButtonZipCode.isSelected()) {
					zipCodeText.setEnabled(true);
					isZipCodeOption=true;
					nameText.setText("");
					nameText.setEnabled(false);
			    }
			}
		});
		
	}
	
	
	private void makeItVisible() {
		this.setSize(1000, 400);
		this.setVisible(true);
		//this.pack();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args)  {
		SearchDealerUI s= new SearchDealerUI();
		
		
	}
}
