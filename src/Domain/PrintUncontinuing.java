package Domain;

import java.util.ArrayList;
import Database.Dealer.Dealer;

public class PrintUncontinuing {
    public void PrintUncontinuingDealer(ArrayList<Dealer> dealers) {
        for (Dealer dealer : dealers) {
            if (dealer.getCont().equals("N")) {
                System.out.println(dealer.toString());
            }
        }
    }
        
}

