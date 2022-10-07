package Domain;

import java.util.ArrayList;
import Database.Dealer.Dealer;

public class PrintAll {
    public void PrintAllDealer(ArrayList<Dealer> dealers) {
        for (Dealer dealer : dealers) {
            System.out.println(dealer.toString());
        }
    }
}
