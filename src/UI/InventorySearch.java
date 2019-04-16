package finalprojectgroup2test2;

import java.awt.*;

import javax.swing.*;


public class InventorySearch extends InventorySearchBuild {
	String dealerName;
	Inventory inventory;
	
	public InventorySearch(String dealerName) {
		super();
		this.dealerName = dealerName;
		
		this.buildUI();
	}
	
	public void buildUI() {
		this.buildNorthPanel();
		this.createWestPanelComponents();
		this.defineWestPanelComponents();
		this.buildWestPanel();
		this.buildCentralPanel();
		this.defineSouthPanelComponents();
		this.buildSouthPanel();
	}

	public void buildNorthPanel() {
        //northPanel.setPreferredSize(new Dimension(500, 500));
		northPanel = new JPanel() {
			public void paintComponent(Graphics g) {
				ImageIcon backImage = new ImageIcon("//users/liulanze/Downloads/2019 Spring NEU Seattle/JAVA OOP/Final Project/cover1.jpeg");
				g.drawImage(backImage.getImage(), 0, 0, this.getSize().width, this.getSize().height, this);
			}
		};
		
		labelSortBy = new JLabel("Sort by:");
		JCBSortBy = new JComboBox(new String[] {"Distance: Nearest(Default)", "Price: Lowest", "Price: Highest", "Year: Newest", "Year: Oldest", "Mileage: Lowest", "Mileage: Highest"});
		
		northPanel.setOpaque(true);
        northPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        northPanel.add(labelSortBy, BorderLayout.EAST);
        northPanel.add(JCBSortBy, BorderLayout.EAST);
        
        northPanel.add(Box.createRigidArea(new Dimension(100, 150)));
		northPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

        getContentPane().add(northPanel, BorderLayout.NORTH);
	}
	
	
	public void createWestPanelComponents() {
		
        labelCategory = new JLabel("Category");
        labelEmpty = new JLabel("");
        labelYear = new JLabel("Year");
        labelTo = new JLabel("to");
        labelTo2 = new JLabel("to");
        labelMileage = new JLabel("Mileage");
        labelPrice = new JLabel("Price");
		labelMake = new JLabel("Make");
		labelModel = new JLabel("Model");
		labelType = new JLabel("Type");
		labelSeatCount = new JLabel("Seat Count");
		JBSearch = new JButton("Search");
	}
	
	public void defineWestPanelComponents() {
		for (int i=0; i<inventory.getVehicles().size(); i++) {
			makeSetItems.add(inventory.getVehicle(i).getMake());
			modelSetItems.add(inventory.getVehicle(i).getModel());
			typeSetItems.add(inventory.getVehicle(i).getType());
			yearSetItems.add(inventory.getVehicle(i).getYear());
			mileageSetItems.add(inventory.getVehicle(i).getMilaege());
			seatCountItems.add(inventory.getVehicle(i).getSeatCount());
		}
		
		minPriceFilterResults = new String[] { "5,000", "10,000", "15,000", "20,000", "30,000", "40,000","50,000","100,000", "200,000" };
		maxPriceFilterResults = new String[] { "200,000","100,000","50,000","40,000","30,000", "20,000", "15,000", "10,000", "5,000" };

		bottonNew = new JCheckBox("New");
		bottonUsed = new JCheckBox("Used");
		bottonNew.setSelected(true);
		JCBYear1 = new JComboBox(yearSetItems.toArray());
		JCBYear2 = new JComboBox(yearSetItems.toArray());
		JCBMileage1 = new JComboBox(mileageSetItems.toArray());
		JCBPrice1 = new JComboBox(minPriceFilterResults);
		JCBPrice2 = new JComboBox(maxPriceFilterResults);
		JCBMake = new JComboBox(makeSetItems.toArray());
		JCBModel = new JComboBox(modelSetItems.toArray());
		JCBType = new JComboBox(typeSetItems.toArray());
		JCBSeatCount = new JComboBox(seatCountItems.toArray());
	}

	public void buildWestPanel() {
		westLayout = new BoxLayout(westPanel, BoxLayout.Y_AXIS);
        westPanel.setLayout(westLayout);

        //adding filters
		westPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        westPanel.add(labelCategory);
        westPanel.add(bottonNew);
        westPanel.add(bottonUsed);
        
    	westPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        westPanel.add(labelYear);
        westPanel.add(JCBYear1);
        westPanel.add(labelTo2);
        westPanel.add(JCBYear2);
        
    	westPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        westPanel.add(labelMileage);
        westPanel.add(JCBMileage1);

    	westPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        westPanel.add(labelPrice);
        westPanel.add(JCBPrice1);
        westPanel.add(labelTo);
        westPanel.add(JCBPrice2);

    	westPanel.add(Box.createRigidArea(new Dimension(0, 10)));
    	westPanel.add(labelModel);
    	westPanel.add(JCBModel);
    	
    	westPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        westPanel.add(labelMake);
        westPanel.add(JCBMake);
        
        westPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        westPanel.add(labelType);
        westPanel.add(JCBType);
        
        westPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        westPanel.add(labelSeatCount);
        westPanel.add(JCBSeatCount);
        
        westPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        westPanel.add(JBSearch);
        
        westPanel.setBorder(BorderFactory.createTitledBorder("Filter Results"));

        /*
        when the window is max, westScrollPanel will contain all filters(does not need to scroll down)
        with height of 764, the height may be changed when adding new filters
         */
        westPanel.setPreferredSize(new Dimension(300, 764));


        /*
        westPanelOut should be BorderLayout to make sure the filters wont collapse when there are too many
         */
        westPanelOut = new JPanel();
        westPanelOut.setLayout(new BorderLayout());
        westPanelOut.add(westPanel, BorderLayout.NORTH);
        westScrollPane = new JScrollPane(westPanelOut, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        westScrollPane.getVerticalScrollBar().setUnitIncrement(15);
        getContentPane().add(westScrollPane, BorderLayout.WEST);
	}
	
	public void buildCentralPanel() {
		centerPanel.setBorder(BorderFactory.createTitledBorder("Results"));
		//centerPanel.setPreferredSize(new Dimension(getWidth(),764));
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

        //display results test
		for(int j=0;j<30;j++) {
			for (int i = 1; i < 4; i++) {
				String imagePath = i + ".jpeg";
				ResultPanel resultPanel = new ResultPanel(imagePath);
				this.centerPanel.add(resultPanel);
			}
		}

		centerPanelOut = new JPanel();
		centerPanelOut.setLayout(new BorderLayout());
		centerPanelOut.add(centerPanel, BorderLayout.NORTH);
		centerScrollPane = new JScrollPane(centerPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		centerScrollPane.getVerticalScrollBar().setUnitIncrement(15);
		getContentPane().add(centerScrollPane, BorderLayout.CENTER);
	}
	
	public void defineSouthPanelComponents() {
		JBBack = new JButton("Back");
		JBPreviousPage = new JButton("Previous Page");
		JBNextPage = new JButton("Next Page");
	}
	
	public void buildSouthPanel() {
        southPanel.add(JBBack);
        southPanel.add(JBPreviousPage);
        southPanel.add(JBNextPage);
        getContentPane().add(southPanel, BorderLayout.SOUTH);
        getContentPane().setVisible(true);
	}

	public static void main(String[] args) {
		
		InventorySearch is = new InventorySearch("dealer1");
		is.setVisible(true);
	}

}

class ResultPanel extends JPanel{

	ImageIcon imageIcon;
	Image image;
	JLabel resultPrice, resultLocation, resultMake, resultYear, resultMileage, resultCondition;
	JButton checkButton;

	ResultPanel(String imagePath) {
		this.showImage(imagePath);
		this.showInfo();
	}

	private void showImage(String imagePath){
		this.setBorder(BorderFactory.createLineBorder(Color.black));
		this.imageIcon = new ImageIcon(imagePath);
		this.image = this.imageIcon.getImage();
		Image newImage = this.image.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		this.imageIcon = new ImageIcon(newImage);
		JLabel jLabel = new JLabel(this.imageIcon);
		this.add(jLabel);
		this.setBorder(BorderFactory.createEmptyBorder(10,0,10,10));

	}

	private void showInfo(){
		this.createComponents();
		this.addComponents();
		this.addListeners();
	}

	private void createComponents(){
		this.checkButton = new JButton("Check Availability");
		this.resultCondition = new JLabel("Condition: ");
		this.resultLocation = new JLabel("Location: ");
		this.resultMake = new JLabel("Make: ");
		this.resultMileage = new JLabel("Mileage: ");
		this.resultYear = new JLabel("Year: ");
		this.resultPrice = new JLabel("Price: ");
		this.checkButton.setPreferredSize(new Dimension(200,50));
		this.resultPrice.setPreferredSize(new Dimension(100,50));
		this.resultLocation.setPreferredSize(new Dimension(150,50));
		this.resultMileage.setPreferredSize(new Dimension(150,50));
		this.resultCondition.setPreferredSize(new Dimension(150,50));
		this.resultYear.setPreferredSize(new Dimension(100,50));
		this.resultMake.setPreferredSize(new Dimension(100,50));
	}

	private void addComponents(){
		this.add(this.resultPrice);
		this.add(this.resultCondition);
		this.add(this.resultMake);
		this.add(this.resultYear);
		this.add(this.resultMileage);
		this.add(this.resultLocation);
		this.add(this.checkButton);
	}

	private void addListeners(){
		this.checkButton.addActionListener((e -> {DetailTest detailTest = new DetailTest();}));
	}
}

//This class is for test only
class DetailTest extends JFrame{
	DetailTest(){
		this.setSize(400,300);
		this.setLocation(790,380);
		this.setVisible(true);
	}
}