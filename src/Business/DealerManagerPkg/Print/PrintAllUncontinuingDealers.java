package Business.DealerManagerPkg.Print;

import java.util.ArrayList;
import Database.Dealer.Dealer;


public class PrintAllUncontinuingDealers implements IPrint
{
    // print only uncontinuing dealers
    public void Print(ArrayList<Dealer> dealers)
    {
        if (dealers.isEmpty() == true)
        {
            // empty list
            return;
        }
        
        for (Dealer dealer : dealers)
        {
            if (dealer.getIsContinuing() != true)
            {
                PrintDealer.Print(dealer);
                System.out.println();
            }
        }
    }
}
