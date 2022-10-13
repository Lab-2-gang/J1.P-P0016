package Business.DealerManagerPkg.DealerOperation;

import Business.DealerManagerPkg.Tool.PrintDealer;
import java.util.ArrayList;
import Persistance.Database;
import Persistance.Entity.Dealer.Dealer;
import Presentation.Tool.Color;
import Presentation.Tool.Message;


public class PrintAllUncontinuingDealers implements IOperation
{
    // print only uncontinuing dealers
    @Override
    public void Operate()
    {
        ArrayList<Dealer> tmp = Database.GetDatabase().GetDealerDatabase();
        
        if (tmp == null || tmp.isEmpty() == true)
        {
            // empty database
            Message.showMessage("Error. Empty database\n", Color.RED);
            return;
        }
        
        Message.showMessage("LIST OF ALL UN-CONTINUING DEALERS\n", Color.YELLOW_BACKGROUND);

        for (Dealer dealer : Database.GetDatabase().GetDealerDatabase())
        {
            if (dealer.getIsContinuing() != true)
            {
                PrintDealer.Print(dealer);
            }
        }
    }
}
