
	package dealerUI;

	import dto.Dealer;
import searchDealerLogic.SearchDealerResult;

import java.awt.Container;
	import java.awt.Font;
	import java.awt.GridLayout;
	import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

	public class ListOfDealerUI extends JFrame{
		
		public JFrame frame;
		private JButton clickForDetails;
		private Container c;
		private ArrayList<Dealer> dlist = new ArrayList<>();
		public ListOfDealerUI(ArrayList<Dealer> dealers) {
			
		  	dlist = dealers;

				
			createComponents();
			setLayout();
			addComponents();
			display();
		}
		
		private void display() {
			
			frame.setSize(800, 700);
			frame.setVisible(true);
			clickForDetails.setSize(10, 10);
		}

		private void addComponents() {
			frame.setTitle("List Of Dealers");
			
			for (int i = 0; i < dlist.size(); i++) {
		         c.add(new dealerUI.SingleDealerPanelUI(dlist.get(i)));
		    }
			
			c.add(clickForDetails);
		}

		private void setLayout() {
			
			GridLayout gl = new GridLayout(7,2);
			c = frame.getContentPane();
			c.setLayout(gl);
			
		}

		private void createComponents() {
			frame = new JFrame();
			c = new Container();
			clickForDetails = new JButton("Click For Details");
			
		}
	}

	

