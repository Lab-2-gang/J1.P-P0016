package Domain;

import java.util.ArrayList;

import Database.Dealer.Dealer;

public class Search {
    public Dealer SearchDealer(String id, ArrayList<Dealer> dealers) {
        for (Dealer dealer : dealers) {
            if (dealer.getId().equals(id)) {
                return dealer;
            }
        }
        return null;
        
    }
}
