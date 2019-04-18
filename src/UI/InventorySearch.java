package finalprojectgroup2test2;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;



public class InventorySearch extends InventorySearchBuild {
	String Dealerid;
	Inventory inventory;
	
	
	public InventorySearch(String Dealerid) {
		super();
		this.Dealerid = Dealerid;
		this.buildUI();
	}
	
	public void buildUI() {
		this.inventoryConnection();
		this.buildNorthPanel();
		this.createWestPanelComponents();
		this.defineWestPanelComponents();
		this.initializationWestPanelButtonCodition();
		this.buildWestPanel();
		this.buildCentralPanel();
		this.defineSouthPanelComponents();
		this.buildSouthPanel();
	}

	public void inventoryConnection() {
		Vehicle v1 = new Vehicle();
		v1.setCategory("New");
		v1.setMake("Audi");
		v1.setMilaege("0");
		v1.setModel("A4");
		v1.setPrice("$42,492");
		v1.setSeatCount("4");
		v1.setType("Sedan");
		v1.setVehicleId("V1");
		v1.setYear("2019");
		v1.setZipCode("WA 98168");
		
		Vehicle v2 = new Vehicle();
		v2.setCategory("New");
		v2.setMake("BMW");
		v2.setMilaege("0");
		v2.setModel("X6");
		v2.setPrice("$62,832");
		v2.setSeatCount("4");
		v2.setType("SUV");
		v2.setVehicleId("V2");
		v2.setYear("2019");
		v2.setZipCode("WA 98168");
		
		ArrayList<Vehicle> vehiclesCollection = new ArrayList<>();
		vehiclesCollection.add(v1);
		vehiclesCollection.add(v2);
		
		Inventory i = new Inventory("D1");
		i.setVehicles(vehiclesCollection);
		
		this.inventory = i;
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
        
        northPanel.add(Box.createRigidArea(new Dimension(100, 100)));
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
        labelOrLess = new JLabel("or less");
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
	JCBYear1 = new JComboBox(yearSetItems.toArray());
	JCBYear1.addItem("--Please choose a start year");
	JCBYear2 = new JComboBox(yearSetItems.toArray());
	JCBYear2.addItem("--Please choose a end year");
	JCBMileage1 = new JComboBox(mileageSetItems.toArray());
	JCBMileage1.addItem("--Please choose a prefered mileage");
	JCBPrice1 = new JComboBox(minPriceFilterResults);
	JCBPrice1.addItem("--Please choose a start price");
	JCBPrice2 = new JComboBox(maxPriceFilterResults);
	JCBPrice2.addItem("--Please choose a end price");
	JCBMake = new JComboBox(makeSetItems.toArray());
	JCBMake.addItem("--Please choose a prefered make");
	JCBModel = new JComboBox(modelSetItems.toArray());
	JCBModel.addItem("--Please choose a prefered model");
	JCBType = new JComboBox(typeSetItems.toArray());
	JCBType.addItem("--Please choose a prefered type");
	JCBSeatCount = new JComboBox(seatCountItems.toArray());
	JCBSeatCount.addItem("--Please choose a prefered seat count");
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
	
	public void initializationWestPanelButtonCodition() {
		bottonNew.setSelected(true);
		bottonUsed.setSelected(true);
		JCBYear1.setSelectedIndex(JCBYear1.getItemCount()-1);
		JCBYear2.setSelectedIndex(JCBYear2.getItemCount()-1);
		JCBMileage1.setSelectedIndex(JCBMileage1.getItemCount()-1);
		JCBPrice1.setSelectedIndex(JCBPrice1.getItemCount()-1);
		JCBPrice2.setSelectedIndex(JCBPrice2.getItemCount()-1);
		JCBMake.setSelectedIndex(JCBMake.getItemCount()-1);
		JCBModel.setSelectedIndex(JCBModel.getItemCount()-1);
		JCBType.setSelectedIndex(JCBType.getItemCount()-1);
		JCBSeatCount.setSelectedIndex(JCBSeatCount.getItemCount()-1);
		
	}
	
	
	
	

	/*
	get user's filter search result and save it on filtercontent
	*/
	public Inventory getFilterValue() {
		FilterContent filtercontent=new FilterContent();
		ArrayList<String> category=new ArrayList<>();
		ArrayList<String>make=new ArrayList<>();
		ArrayList<String>model=new ArrayList<>();
		ArrayList<String>type=new ArrayList<>();
		ArrayList<String>mileage=new ArrayList<>();
		ArrayList<String>seatCount=new ArrayList<>();
		//Category
		while(true) {
			if(bottonNew.isSelected()) {
				category.add("new");
			}else if(bottonUsed.isSelected()) {
				category.add("used");
			}
			filtercontent.setCategory(category);
			//Make
			make.add((String)JCBMake.getSelectedItem());
			filtercontent.setMake(make);
			//Model
			model.add((String)JCBModel.getSelectedItem());
			filtercontent.setModel(model);
			//Type
			type.add((String)JCBType.getSelectedItem());
			filtercontent.setType(type);
			//year
			filtercontent.setLowYear(Integer.valueOf(JCBYear1.getSelectedItem().toString()));
			filtercontent.setHighYear(Integer.valueOf(JCBYear2.getSelectedItem().toString()));
			//price
			filtercontent.setLowPrice(Double.valueOf(JCBPrice1.getSelectedItem().toString()));
			filtercontent.setHighPrice(Double.valueOf(JCBPrice2.getSelectedItem().toString()));
			//Mileage
			mileage.add((String)JCBMileage1.getSelectedItem());
			filtercontent.setMileage(mileage);
			//Seat Count
			seatCount.add((String)JCBSeatCount.getSelectedItem());
			filtercontent.setSeatCount(seatCount);
			//verify year filer validation
			if(filtercontent.getLowYear()>filtercontent.getHighYear()) {
				YearErrorMessage();
				
			}
			//verify price filter validation
			if(filtercontent.getLowPrice()>filtercontent.getHighPrice()) {
				PriceErrorMessage();
				
			}
		}
	}
	//show YearErrorMessage if year range is not valid
	public void YearErrorMessage() {
		String message=" Please enter a valid year range!";
		JOptionPane.showMessageDialog(new JFrame(), message,"Dialog",JOptionPane.ERROR_MESSAGE);
	}
	//show PriceErrorMessage if price range is not valid
	public void PriceErrorMessage() {
		String message=" Please enter a valid price range!";
		JOptionPane.showMessageDialog(new JFrame(), message,"Dialog",JOptionPane.ERROR_MESSAGE);
		
	}
	//show NoMatchingResultErrorMessage if there is no matching search result
	public void NoMatchingResultErrorMessage() {
		String message="Sorry, no matching search result found!";
		JOptionPane.showMessageDialog(new JFrame(), message,"Dialog",JOptionPane.ERROR_MESSAGE);
	}
	
	//add actionListener to JBSearch
	public void setActionListener() {
		JBSearch.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Inventory searchResult=getFilterValue();
				//*****need a function to apply searchResult to central panel*****
				
				//if there is no matching search result
				if(searchResult.getVehicles().size()==0) {
					NoMatchingResultErrorMessage();
				}
				
			}	
		});
	}
	
	
	
	
	
	
	public void buildCentralPanel() {
		centerPanel.setBorder(BorderFactory.createTitledBorder("Results"));
		//centerPanel.setPreferredSize(new Dimension(getWidth(),764));
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

        //display results test
        this.resultPanelList = new ArrayList<>();
		for(int j=0;j<30;j++) {
			for (int i = 1; i < 4; i++) {
				String imagePath = i + ".jpeg";
				ResultPanel resultPanel = new ResultPanel(imagePath);
                this.resultPanelList.add(resultPanel);
                resultPanel.number.setText(Integer.toString(this.resultPanelList.size()));
				this.centerPanel.add(this.resultPanelList.get(this.resultPanelList.size()-1));
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
	}
	
	public void buildSouthPanel() {
        southPanel.add(JBBack);
        getContentPane().add(southPanel, BorderLayout.SOUTH);
        getContentPane().setVisible(true);
	}

	public static void main(String[] args) {
		InventorySearch is = new InventorySearch("D1");
		is.setVisible(true);
	}

}

class ResultPanel extends JPanel{

	ImageIcon imageIcon;
	Image image;
	JLabel resultPrice, resultLocation, resultMake, resultYear, resultMileage, resultCondition, number;
	JButton checkButton;
    String imagePath;
	ResultPanel(String imagePath) {
		this.showImage(imagePath);
		this.showInfo();
	}

	private void showImage(String imagePath){
	    this.imagePath = imagePath;
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
		this.number = new JLabel();
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

	protected void removeCheckButton(){
	    this.remove(this.checkButton);
    }

	private void addListeners(){
		this.checkButton.addActionListener((e -> {DetailTest detailTest = new DetailTest(this);}));
	}
}

//This class is for test only
class DetailTest extends JFrame{
    ResultPanel carDetail;
	DetailTest(ResultPanel result){
		this.showDetail(result);
	}

	private void showDetail(ResultPanel result){
        this.setTitle(result.number.getText());
        this.setSize(400,300);
        this.setLocation(790,380);
        this.carDetail = new ResultPanel(result.imagePath);
        this.carDetail.resultPrice = result.resultPrice;
        this.carDetail.resultCondition = result.resultCondition;
        this.carDetail.number = result.number;
        this.carDetail.resultMake = result.resultMake;
        this.carDetail.resultLocation = result.resultLocation;
        this.carDetail.resultMileage = result.resultMileage;
        this.carDetail.resultYear = result.resultYear;
        this.carDetail.add(this.carDetail.number);
        this.carDetail.removeCheckButton();
        this.add(this.carDetail);
        this.setVisible(true);
    }
}