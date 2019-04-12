package searchDealerLogic;

import java.io.IOException;

/*

Below is the Driver code to test calculateDistance and searchDealer method.

Method Description:

Call "SearchDealer.searchDealer(integer zipcode)", the method will return an String Arraylist which in below format:

{NearestDealerID1, NearestDealerDistance,SecondNearestDealerID2, SecondNearestDealerDistance,........}

Be aware, the input parameter zipcode must be a VALID 5 digits US zipcode, random digits like 12345 will throw exception and incorrect distance data.

If there is an exception, use the method "CalculateDistance.calculateDistance("userZipcode","dealerZipcode")" to check if both zipcode are valid. This method will return the distances in Miles by calculate two zipcodes.


*/
public class SDL_Test {

    public static void main (String[] arg) throws IOException {

        CalculateDistance.calculateDistance("97133","97109"); //Test if the Calculation Web service working. It should print our a distance
        System.out.println(SearchDealer.searchDealer(98133)); // Test if the searchDealer method working. It should return an Arraylist

    }
}
