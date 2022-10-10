package Business.DealerManagerPkg.Print;

import Presentation.Tools.Color;
import Presentation.Tools.Message;

import java.util.ArrayList;

import Persistance.Dealer.Dealer;


public class PrintAllContinuingDealers implements IPrint
{
    // print all dealers
    public void Print(ArrayList<Dealer> dealers)
    {
        if (dealers.isEmpty() == true)
        {
            // empty list
            Message.showMessage("Empty list!", Color.RED);
            return;
        }
        
        Message.showMessage("LIST OF ALL CONTINUING DEALERS", Color.YELLOW_BACKGROUND);

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
