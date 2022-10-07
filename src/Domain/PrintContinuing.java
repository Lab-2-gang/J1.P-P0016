package Domain;

import java.util.ArrayList;
import Database.Dealer.Dealer;

public class PrintContinuing {
    public void PrintCont(ArrayList<Dealer> dealers) {
        for (Dealer dealer : dealers) {
            if (dealer.getCont().equals("Y")) {
                System.out.println(dealer.toString());
            }
        }
    }
}
