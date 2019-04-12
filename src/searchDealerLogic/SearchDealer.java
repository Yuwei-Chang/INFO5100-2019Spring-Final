package searchDealerLogic;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;
import dto.*;

public class SearchDealer {


    public static  ArrayList<String> searchDealer( int zipcode) throws IOException {

        // Logic code to retrieve all the distance based on zipcode
        String originZipCode = Integer.toString(zipcode); //Convert zipcode to string, used this as origin "addr"
        ArrayList<Double> distanceList = new ArrayList<>();  // Distancelist used to store call the calculated distance for each dealer
        String destZipCode; // Store the zipcode of the dealer
        ArrayList<Dealer> dealerList = RetriveDealerInfo.getDealerList(); // Get all dealer instances and store them in this Arraylist

        // Calculate the distance with all dealers and store the distance into Array
        for (Dealer dl : dealerList){
            destZipCode= Integer.toString(dl.getZipCode());
            String[] tempDistance = CalculateDistance.calculateDistance(originZipCode,destZipCode).split(" ");
            double currentDistance = Double.parseDouble(tempDistance[0]);
            distanceList.add(currentDistance);

        }

        // Logic code to sort the dealer based on distance and return the sorted arraylist.
        ArrayList<Double> sortedDistanceList = new ArrayList<>();
        ArrayList<Integer> trackIndex = new ArrayList<>();
        ArrayList<distanceElement> distanceElements = new ArrayList<>();
        ArrayList<String> searchResult = new ArrayList<>();
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
            searchResult.add(dealerList.get(trackIndex.get(i)).getId());
            searchResult.add(sdl+" Miles");
        }
        return searchResult;

    }

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



