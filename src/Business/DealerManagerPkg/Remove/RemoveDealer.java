package Business.DealerManagerPkg.Remove;

import java.util.Collections;
import java.util.Iterator;
import java.util.ArrayList;
import Database.Dealer.Dealer;
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
            return;
        }
        
        System.out.print("Enter dealer's ID: ");
        String dealerID = ReadInput.ReadUserInput();
        
        if (CheckDealerID(dealerID) != true)
        {
            // invalid dealer ID
            return;
        }
        
        Boolean isRemoved = RemoveDealerFromDatabase(dealerID, dealers);
        
        if (isRemoved == true)
        {
            // remove successful
        }
        else
        {
            // failed to remove
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
        else if (PatternCheck.Check(DEALER_ID, dealerID) != true)
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
                    throw new NullPointerException("Accessing null in dealers database");
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
