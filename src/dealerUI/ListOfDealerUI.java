
	package dealerUI;

	import UI.InventorySearch;
	import dto.Dealer;

	import java.awt.Container;
	import java.awt.GridLayout;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import java.io.FileNotFoundException;
	import java.util.ArrayList;
	import java.util.Enumeration;

	import javax.swing.*;

	public class ListOfDealerUI extends JFrame{
		
		public JFrame frame;
		private JButton clickForDetails;
		private Container c;
		private ButtonGroup radioButtonGroup = new ButtonGroup();
		private ArrayList<Dealer> dealerList = new ArrayList<>();

		public ListOfDealerUI(ArrayList<Dealer> dealers) {
			
		  	dealerList = dealers;

				
			createComponents();
			setLayout();
			addComponents();
			display();
			addListeners();
		}

		private void addListeners() {
			clickForDetails.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent ae) {

					try {
						Enumeration<AbstractButton> elements = radioButtonGroup.getElements();
						while(elements.hasMoreElements()){
							AbstractButton button = elements.nextElement();
							if(button.isSelected()){
								String dealerId = (String)button.getClientProperty("DealerId");
								InventorySearch dealerObj= new InventorySearch(dealerId);
								break;
							}
						}

					} catch (FileNotFoundException e) {
						e.printStackTrace();
					}

				}
			});



		}

		private void display() {
			
			frame.setSize(800, 700);
			frame.setVisible(true);
			clickForDetails.setSize(10, 10);
		}

		private void addComponents() {
			frame.setTitle("List Of Dealers");


			for (int i = 0; i < dealerList.size(); i++) {
				SingleDealerPanelUI singleDealerPanelUI = new SingleDealerPanelUI(dealerList.get(i));
				radioButtonGroup.add(singleDealerPanelUI.getRadioButtonDealersName());
				c.add(singleDealerPanelUI);
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

	

