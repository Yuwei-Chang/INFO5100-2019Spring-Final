package dealerUI;

import dto.Dealer;
import searchDealerLogic.SearchDealerResult;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;


public class SingleDealerPanelUI extends JPanel{
	
	private JButton clickForDetails;
	private JLabel name, url, phoneNumber, zipcode, address,distance;

	public JRadioButton getRadioButtonDealersName() {
		return radioButtonDealersName;
	}

	private JRadioButton radioButtonDealersName;
	SearchDealerResult disSearchResult = new SearchDealerResult();

	
	public SingleDealerPanelUI(Dealer dealer) {
		
		radioButtonDealersName = new JRadioButton(dealer.getName());
		radioButtonDealersName.putClientProperty("DealerId", dealer.getId());
		phoneNumber = new JLabel(String.valueOf((dealer.getPhoneNumber())));
		zipcode = new JLabel(Integer.toString(dealer.getZipCode()));
		address = new JLabel(dealer.getAddress());

		distance = new JLabel(dealer.getDistanceToCustomer());

		JPanel p = new JPanel();

		
		this.setLayout(new GridLayout(5, 0));
		this.add(radioButtonDealersName);
		this.add(phoneNumber);
		this.add(zipcode);
		this.add(address);
		this.add(distance);
		this.setBorder(BorderFactory.createMatteBorder(0,0,1,0, Color.BLUE));
	}


}
