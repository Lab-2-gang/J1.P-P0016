package Domain;

import java.util.ArrayList;

import Database.Dealer.Dealer;

public class Update {
    public void UpdateDealer(Dealer updateDealer, ArrayList<Dealer> dealers) {
        int indexToSwap = 0;
        Boolean found = false;

        for (Dealer dealer : dealers) {
            if (dealer.getId().equals(updateDealer.getId())) {
                found = true;
                return;
            }

            indexToSwap++;
        }

        if (found == false) {
            return; // Dealer not found//
        }

        dealers.set(indexToSwap, updateDealer);
    }
}
