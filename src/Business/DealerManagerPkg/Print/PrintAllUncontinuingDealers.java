package Business.DealerManagerPkg.Print;

import java.util.LinkedList;

import Database.Dealer.Dealer;


public class PrintAllUncontinuingDealers implements IPrint
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
            if (dealer.getIsContinuing() != true)
            {
                PrintDealer.Print(dealer);
                System.out.println();
            }
        }
    }
}
