package Business.DealerManagerPkg.Remove;

import java.util.Collections;
import java.util.Iterator;
import Persistance.Entity.Dealer.Dealer;
import java.util.ArrayList;
import Presentation.Tools.Color;
import Presentation.Tools.Message;
import Tool.PatternCheck;
import Tool.ReadInput;


public class RemoveDealer implements IRemoveDealer
{
    // const format
    private final String DEALER_ID = "^D\\d{3}$";
    
    
    // get user input to remove
    public void Remove(ArrayList<Dealer> dealers)
    {
        if (dealers.isEmpty() == true)
        {
            // database is empty
            Message.showMessage("Empty database!", Color.RED);
            return;
        }

        Message.showMessage("REMOVE A DEALER BY ID", Color.YELLOW_BACKGROUND);
        
        System.out.print("Enter dealer's ID: ");
        String dealerID = ReadInput.ReadUserInput();
        
        if (CheckDealerID(dealerID) != true)
        {
            // invalid dealer ID
            Message.showMessage("Invalid dealer ID", Color.RED);
            return;
        }
        
        Boolean isRemoved = RemoveDealerFromDatabase(dealerID, dealers);
        
        if (isRemoved == true)
        {
            // remove successful
            Message.showMessage("Remove successful!", Color.BLUE);
        }
        else
        {
            // failed to remove
            Message.showMessage("Remove failed!", Color.BLUE);
        }
    }
    
    
    // check validity of dealerID
    private Boolean CheckDealerID(String dealerID)
    {
        Boolean isNullOrBlank = false;
        Boolean isDealerIDFormatValid = false;
        
        if (dealerID == null || dealerID.isBlank())
        {
            // input is empty
            isNullOrBlank = true;
        }

        if (PatternCheck.Check(DEALER_ID, dealerID) != true)
        {
            // invalid format
            isDealerIDFormatValid = true;
        }
        
        return isNullOrBlank == false && isDealerIDFormatValid == true;
    }

    
    // remove dealer from database
    private Boolean RemoveDealerFromDatabase(String dealerID, ArrayList<Dealer> dealers)
    {
        Iterator<Dealer> dealersIterator = dealers.iterator();
        
        try
        {
            while (dealersIterator.hasNext() == true)
            {
                Dealer currentDealer = dealersIterator.next();

                if (currentDealer == null)
                {
                    // sth wrong
                }

                if (currentDealer.getDealerID().equals(dealerID) == true)
                {
                    dealersIterator.remove();
                    
                    Collections.sort(dealers, (dealer1, dealer2) ->
                        {
                            return dealer1.getDealerID().compareTo(dealer2.getDealerID());
                        });
                    
                    return true;
                }
            }
        }
        catch (Exception e)
        {
            // error removing
            return false;
        }
        
        return false;
    }
}
