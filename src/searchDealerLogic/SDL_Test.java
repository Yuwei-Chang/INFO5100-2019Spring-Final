package searchDealerLogic;

import java.io.IOException;

/*

Below is the Driver code to test SearchDealerLogic.

How to use:

Create a new instance from SearchDealerResult class

Call "newSearchDealerResultInstance.getDealerObjListByDistance(integer zipcode)", the method will return an Dealer Object Arraylist which in below format:

{NearestDealerObj1,SecondNearestDealerObj2,........}

Be aware, the input parameter zipcode must be a VALID 5 digits US zipcode, random digits like 12345 will throw exception and incorrect distance data.

If there is an exception, use the method "DealerDistance.getDistance("userZipcode","dealerZipcode")" to check if both zipcode are valid. This method will return the distances in Miles by calculate two zipcodes.

Call "newSearchDealerResultInstance.getDealerObjListByName(String dealername)", the method will return an Dealer Object ArrayList of all the dealer objects contains the input name.




*/
public class SDL_Test {

    public static void main (String[] arg) throws IOException {

        DealerDistance.getDistance("97133","97109"); //Test if the Calculation Web service working. It should print our a distance
        SearchDealerResult newResult = new SearchDealerResult();
        System.out.println(newResult.getDealerObjListByDistance(98133)); // Test if the searchDealer method working. It should return an Arraylist
        System.out.println(newResult.getDistanceList().get(0));
        System.out.println(newResult.getDealerObjListByName("Honda"));



    }
}
