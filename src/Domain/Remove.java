package Domain;

import java.util.ArrayList;
import Database.Dealer.Dealer;

public class Remove {
    public void RemoveDealer(String id, ArrayList<Dealer> dealers) {
        for (Dealer dealer : dealers) {
            if (dealer.getId().equals(id)) {
                dealers.remove(dealer);
                break;
            }
        }
    }
}
