package searchDealerLogic;

import dto.Dealer;

import java.io.IOException;
import java.util.ArrayList;

/*

Below is the Driver code to test SearchDealerLogic.

How to use:

Create a new instance from SearchDealerResult class

Call "newSearchDealerResultInstance.getDealerObjListByDistance(integer zipcode)", the method will return an Dealer Object Arraylist which in below format:

{NearestDealerObj1,SecondNearestDealerObj2,........}

Call "newSearchDealerResultInstance.getDistanceList()" to get the corresponding distance list of above dealers, the index will be matching the dealerObject Arraylist.

Be aware, the input parameter zipcode must be a VALID 5 digits US zipcode, random digits like 12345 will throw exception and incorrect distance data.

If there is an exception, use the method "DealerDistance.getDistance("userZipcode","dealerZipcode")" to check if both zipcode are valid. This method will return the distances in Miles by calculate two zipcodes.

Call "newSearchDealerResultInstance.getDealerObjListByName(String dealername)", the method will return an Dealer Object ArrayList of all the dealer objects contains the input name.




*/
public class SDL_Test {

    public static void main (String[] arg) throws IOException {

        DealerDistance.getDistance("97133","97109"); //Test if the Calculation Web service working. It should print our a distance
        SearchDealerResult newResult = new SearchDealerResult();
        ArrayList<Dealer> sortedDealerList = newResult.getDealerObjListByDistance(98133,30);
        //System.out.println(sortedDealerList); // Test if the searchDealer method working. It should return an Arraylist
        //System.out.println(newResult.getDistanceList());
        //System.out.println(newResult.getDealerObjListByName("Honda"));

        for (int i =0; i< sortedDealerList.size();i++){
            System.out.print(sortedDealerList.get(i).getName() +   "    "+  sortedDealerList.get(i).getDistanceToCustomer() +" ");
        }


    }
}
