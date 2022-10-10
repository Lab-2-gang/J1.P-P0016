package Business.DealerManagerPkg.Search;

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
    public Dealer Search()
    {
        if (Database.GetDatabase().GetDealerDatabase().isEmpty() == true)
        {
            // database is empty
            return null;
        }

        Message.showMessage("SEARCH A DEALER BY ID", Color.YELLOW);
        
        System.out.print("Enter dealer's ID: ");
        String dealerID = ReadInput.ReadUserInput();
        
        if (CheckDealerID(dealerID) != true)
        {
            // input is empty
            return null;
        }
        
        Dealer resultFromSearch = SearchDealerFromDatabase(dealerID);
        
        if (resultFromSearch == null)
        {
            // dealer cannot be found
            return null;
        }

        Message.showMessage("Found!", Color.BLUE);
        
        return resultFromSearch;
    }
    
    
    // check validity of dealerID
    private Boolean CheckDealerID(String dealerID)
    {
        Boolean isNullOrBlank = dealerID == null || dealerID.isBlank() == true;
        Boolean isDealerIDValid = PatternCheck.Check(DEALER_ID, dealerID) == true;
        
        return isNullOrBlank != true && isDealerIDValid == true;
    }

    
    // search from database
    private Dealer SearchDealerFromDatabase(String dealerID)
    {
        for (Dealer dealer : Database.GetDatabase().GetDealerDatabase())
        {
            // if found
            if (dealer.getDealerID().equals(dealerID) == true)
            {
                return dealer;
            }
        }
        
        // if cannot found
        return null;
    }
}
