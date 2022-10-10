package Business.DealerManagerPkg.Print;

import java.util.ArrayList;

import Persistance.Dealer.Dealer;
import Presentation.Tools.Color;
import Presentation.Tools.Message;


public class PrintAllDealers implements IPrint
{
    // print only continuing dealers
    public void Print(ArrayList<Dealer> dealers)
    {
        if (dealers.isEmpty() == true)
        {
            // empty list
            Message.showMessage("Empty list!", Color.RED);
            return;
        }

        Message.showMessage("LIST OF ALL DEALERS", Color.YELLOW_BACKGROUND);
        
        for (Dealer dealer : dealers)
        {
            PrintDealer.Print(dealer);
            System.out.println();
        }
    }
}
