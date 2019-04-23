package searchDealerLogic;

import database.DatabaseConnection;
import dto.Dealer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class SearchDealerResult {

    ArrayList<String> dealerDistanceList = new ArrayList<>();
    ArrayList<Dealer> searchResult = new ArrayList<>();
    DatabaseConnection allDealerObj = new DatabaseConnection();


    public ArrayList<Dealer> getDealerObjListByDistance(int zipcode, int range) throws IOException {

        dealerDistanceList.clear();
        searchResult.clear();

        // Logic code to retrieve all the distance based on zipcode
        String originZipCode = Integer.toString(zipcode); //Convert zipcode to string, used this as origin "addr"
        ArrayList<Double> distanceList = new ArrayList<>();  // Distancelist used to store call the calculated distance for each dealer
        String destZipCode; // Store the zipcode of the dealer
        ArrayList<Dealer> dealerList = allDealerObj.getAllDealers(); // Get all dealer instances and store them in this Arraylist


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

        for (int i = 0; i < distanceList.size(); i++){

            distanceElements.add(new distanceElement(i,distanceList.get(i)));
        }
        Collections.sort(distanceElements);

        for (distanceElement ele: distanceElements){
            sortedDistanceList.add(ele.value);
            trackIndex.add(ele.index);
        }


        for (int m =0; m < sortedDistanceList.size();m++){

            if (sortedDistanceList.get(m) >= range){

                break;
            }else {
                searchResult.add(dealerList.get(trackIndex.get(m)));

                dealerDistanceList.add(sortedDistanceList.get(m) + " Miles");

                dealerList.get(trackIndex.get(m)).setDistanceToCustomer(dealerDistanceList.get(m));
            }
        }
        return searchResult;

    }

    public ArrayList<Dealer> getDealerObjListByName(String dealerName){

        ArrayList<Dealer> dealerList = allDealerObj.getAllDealers();
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
        return dealerDistanceList;
    }



    // Class to provide function to sort array
    class distanceElement implements Comparable<distanceElement>{
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
