/*package searchDealerLogic;

import dto.Dealer;

import java.util.ArrayList;
import java.util.Random;

import static java.lang.Math.abs;

public class DealerList {

    public static ArrayList<Dealer> getDealerList() {
        ArrayList<Dealer> dealerObjList = new ArrayList<>();

        for (int i = 0; i <= 5; i++) {

            Random rID = new Random();
            int randomID = abs(rID.nextInt());
            String idString = String.valueOf(randomID);

            dealerObjList.add(new Dealer("Honda", "22020 Hwy 99, Edmonds, WA 98026", idString, 98026+i+10, 425222277));
        }

        return dealerObjList;

    }
}*/
