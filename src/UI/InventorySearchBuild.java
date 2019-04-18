package finalprojectgroup2test2;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class InventorySearchBuild extends JFrame {
	
	protected JPanel westPanel, centerPanel, southPanel, northPanel, westPanelOut, centerPanelOut;
    protected JScrollPane westScrollPane, centerScrollPane;
    protected BoxLayout westLayout, southLayout;
	protected GridBagLayout centerLayout;
    protected GridBagConstraints centerConstraints;
    protected ArrayList<JComboBox> JCBList;
    protected List<ResultPanel> resultPanelList;
    
    protected JLabel labelCategory, labelEmpty, labelYear, labelTo, labelTo2, labelMileage, labelOrLess, labelPrice, labelLocation, labelZipcode, labelMake, labelModel, labelType, labelSeatCount, labelSortBy;
    protected JCheckBox bottonNew, bottonUsed;
    protected JComboBox JCBYear1, JCBYear2, JCBMileage1, JCBPrice1, JCBPrice2, JCBMake, JCBModel, JCBType, JCBSeatCount, JCBSortBy;
    protected JTextField JTFZipcode;
    
    protected JButton JBBack, JBPreviousPage, JBNextPage, JBSearch;
    
    protected TreeSet<String> makeSetItems = new TreeSet<>(), modelSetItems = new TreeSet<>(),
			typeSetItems = new TreeSet<>(),yearSetItems = new TreeSet<>(), mileageSetItems = new TreeSet<>(), seatCountItems = new TreeSet<>();
    
    protected String[] minPriceFilterResults, maxPriceFilterResults;
    
    protected InventorySearchBuild() {
    	this.setSize(2000, 1000);
		this.setTitle("Search Results");
    	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	
    	BorderLayout mainLayout = new BorderLayout();
        getContentPane().setLayout(mainLayout);
        westPanel = new JPanel();
        centerPanel = new JPanel();
        centerScrollPane = new JScrollPane();
        centerScrollPane.setViewportView(centerPanel);
        southPanel = new JPanel();
        northPanel = new JPanel();

        
    }

}
