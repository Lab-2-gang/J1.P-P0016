package Business.DealerManagerPkg.Print;

import Database.Dealer.Dealer;
import java.util.LinkedList;


public class PrintAllContinuingDealers implements IPrint
{
    public void Print(LinkedList<Dealer> dealers)
    {
        if (dealers.isEmpty() == true)
        {
            // empty list
            return;
        }
        
        for (Dealer dealer : dealers)
        {
            if (dealer.getIsContinuing() == true)
            {
                PrintDealer.Print(dealer);
                System.out.println();
            }
        }
    }
}
