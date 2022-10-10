package Business.DealerManagerPkg.Print;

import Persistance.Database;
import Persistance.Entity.Dealer.Dealer;
import Presentation.Tools.Color;
import Presentation.Tools.Message;


public class PrintAllDealers implements IPrint
{
    // print only continuing dealers
    public void Print()
    {
        if (Database.GetDatabase().GetDealerDatabase().isEmpty() == true)
        {
            // empty list
            Message.showMessage("Empty list!", Color.RED);
            return;
        }

        Message.showMessage("LIST OF ALL DEALERS\n", Color.YELLOW_BACKGROUND);
        
        for (Dealer dealer : Database.GetDatabase().GetDealerDatabase())
        {
            PrintDealer.Print(dealer);
            System.out.println();
        }
    }
}
