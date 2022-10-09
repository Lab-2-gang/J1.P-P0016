package Business.DealerManagerPkg.Print;

import java.util.ArrayList;
import Database.Dealer.Dealer;


public class PrintAllDealers implements IPrint
{
    // print only continuing dealers
    public void Print(ArrayList<Dealer> dealers)
    {
        if (dealers.isEmpty() == true)
        {
            // empty list
            return;
        }
        
        for (Dealer dealer : dealers)
        {
            PrintDealer.Print(dealer);
            System.out.println();
        }
    }
}
