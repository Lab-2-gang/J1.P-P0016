package Business.DealerManagerPkg.Print;

import Presentation.Tools.Color;
import Presentation.Tools.Message;
import Persistance.Database;
import Persistance.Entity.Dealer.Dealer;



public class PrintAllContinuingDealers implements IPrint
{
    // print all dealers
    public void Print()
    {
        if (Database.GetDatabase().GetDealerDatabase().isEmpty() == true)
        {
            // empty list
            Message.showMessage("Empty list!", Color.RED);
            return;
        }
        
        Message.showMessage("LIST OF ALL CONTINUING DEALERS\n", Color.YELLOW_BACKGROUND);

        for (Dealer dealer : Database.GetDatabase().GetDealerDatabase())
        {
            if (dealer.getIsContinuing() == true)
            {
                PrintDealer.Print(dealer);
                System.out.println();
            }
        }
    }
}
