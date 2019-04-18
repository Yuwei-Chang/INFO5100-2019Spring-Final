package searchDealerLogic;

import dto.Dealer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import database.DatabaseConnection;

public class SearchDealerResult {
	
	DatabaseConnection retrieveDataObj = new DatabaseConnection();

    ArrayList<String> DealerDistanceList = new ArrayList<>();
    ArrayList<Dealer> searchResult = new ArrayList<>();



    public ArrayList<Dealer> getDealerObjListByDistance(int zipcode) throws IOException {

        DealerDistanceList.clear();

        // Logic code to retrieve all the distance based on zipcode
        String originZipCode = Integer.toString(zipcode); //Convert zipcode to string, used this as origin "addr"
        ArrayList<Double> distanceList = new ArrayList<>();  // Distancelist used to store call the calculated distance for each dealer
        String destZipCode; // Store the zipcode of the dealer
       // ArrayList<Dealer> dealerList = DealerList.getDealerList(); // Get all dealer instances and store them in this Arraylist
        ArrayList<Dealer> dealerList = retrieveDataObj.getAllDealers(); // using database dealers list

        for (Dealer dl : dealerList){
            destZipCode= Integer.toString(dl.getZipCode());
            String[] tempDistance = DealerDistance.getDistance(originZipCode,destZipCode).split(" ");
            double currentDistance = Double.parseDouble(tempDistance[0]);
            distanceList.add(currentDistance);

        }

        // Logic code to sort the dealer based on distance and return the sorted arraylist.
        ArrayList<Double> sortedDistanceList = new ArrayList<>();
        ArrayList<Integer> trackIndex = new ArrayList<>();
        ArrayList<distanceElement> distanceElements = new ArrayList<>();

        for (Double dist : distanceList){
            int i = 0;
            distanceElements.add(new distanceElement(i,dist));
        }
        Collections.sort(distanceElements);

        for (distanceElement ele: distanceElements){
            sortedDistanceList.add(ele.value);
            trackIndex.add(ele.index);
        }

        for (Double sdl : sortedDistanceList){
            int i = 0;
            searchResult.add(dealerList.get(trackIndex.get(i)));
            DealerDistanceList.add(sdl+" Miles");
        }
        return searchResult;

    }

    public ArrayList<Dealer> getDealerObjListByName(String dealerName){

        //ArrayList<Dealer> dealerList = DealerList.getDealerList();	// commented this dummy data
    	 ArrayList<Dealer> dealerList = retrieveDataObj.getAllDealers(); // using database dealers list
        ArrayList<Dealer> dealerObjList = new ArrayList<>();
        String searchCriteria = dealerName.toLowerCase();
        for (Dealer dl : dealerList){
            String dealerLowerCaseName = dl.getName().toLowerCase();
            if (dealerLowerCaseName.contains(searchCriteria)){
                dealerObjList.add(dl);
            }
        }

        return dealerObjList;


    }

    public  ArrayList<String> getDistanceList (){
        return DealerDistanceList;
    }
    
   


    // Class to provide function to sort array
    public class distanceElement implements Comparable<distanceElement>{
        int index;
        double value;
        distanceElement(int index, double value){
            this.index = index;
            this.value = value;
        }
        public int compareTo(distanceElement d){
            if (this.value < d.value){
                return -1;
            }else if (this.value > d.value){
                return 1;
            }else {
                return 0;
            }
        }


    }




}
