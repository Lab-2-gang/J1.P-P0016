package Business.DealerManagerPkg.Search;

import java.util.ArrayList;
import Database.Dealer.Dealer;
import Tool.PatternCheck;
import Tool.ReadInput;


public class SearchDealer implements ISearchDealer
{
    // const format
    private final String DEALER_ID = "^D\\d{3}$";
    
    
    // get user input to search for dealer
    public Dealer Search(ArrayList<Dealer> dealers)
    {
        if (dealers.isEmpty() == true)
        {
            // database is empty
            return null;
        }
        
        System.out.print("Enter dealer's ID: ");
        String dealerID = ReadInput.ReadUserInput();
        
        if (CheckDealerID(dealerID) != true)
        {
            // input is empty
            return null;
        }
        
        Dealer resultFromSearch = SearchDealerFromDatabase(dealerID, dealers);
        
        if (resultFromSearch == null)
        {
            // dealer cannot be found
            return null;
        }
        
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
    private Dealer SearchDealerFromDatabase(String dealerID, ArrayList<Dealer> dealers)
    {
        for (Dealer dealer : dealers)
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
