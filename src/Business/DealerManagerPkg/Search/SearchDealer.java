package Business.DealerManagerPkg.Search;

import java.util.ArrayList;
import Business.DealerManagerPkg.Print.PrintDealer;
import Persistance.Database;
import Persistance.Entity.Dealer.Dealer;
import Presentation.Tools.Color;
import Presentation.Tools.Message;
import Tool.PatternCheck;
import Tool.ReadInput;


public class SearchDealer implements ISearchDealer
{
    // const format
    private final String DEALER_ID = "^D\\d{3}$";
    
    
    // get user input to search for dealer
    public void Search()
    {
        ArrayList<Dealer> tmp = Database.GetDatabase().GetDealerDatabase();
        
        if (tmp == null || tmp.isEmpty() == true)
        {
            // empty database
            Message.showMessage("Empty database!\n", Color.RED);
            return;
        }
        
        Message.showMessage("SEARCH A DEALER BY ID", Color.YELLOW_BACKGROUND);
        
        System.out.print("Enter dealer's ID: ");
        String dealerID = ReadInput.ReadUserInput();
        
        if (CheckDealerID(dealerID) != true)
        {
            // input is empty
            Message.showMessage("Invalid input\n", Color.RED);
            return;
        }

        SearchDealerFromDatabase(dealerID);
    }
    
    
    // check validity of dealerID
    private Boolean CheckDealerID(String dealerID)
    {
        Boolean isNullOrBlank = dealerID == null || dealerID.isBlank() == true;
        Boolean isDealerIDValid = PatternCheck.Check(DEALER_ID, dealerID) == true;
        
        return isNullOrBlank != true && isDealerIDValid == true;
    }

    
    // search from database
    private void SearchDealerFromDatabase(String dealerID)
    {
        for (Dealer dealer : Database.GetDatabase().GetDealerDatabase())
        {
            // if found
            if (dealer.getDealerID().equals(dealerID) == true)
            {
                Message.showMessage("Found!\n", Color.GREEN);
                PrintDealer.Print(dealer);
                return;
            }
        }
        
        // if cannot found
        Message.showMessage("Cannot found\n", Color.RED);
    }
}
