package Business.DealerManagerPkg.Remove;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import Persistance.Database;
import Persistance.Entity.Dealer.Dealer;
import Presentation.Tools.Color;
import Presentation.Tools.Message;
import Tool.PatternCheck;
import Tool.ReadInput;


public class RemoveDealer implements IRemoveDealer
{
    // const format
    private final String DEALER_ID = "^D\\d{3}$";
    
    
    // get user input to remove
    public void Remove()
    {
        ArrayList<Dealer> tmp = Database.GetDatabase().GetDealerDatabase();
        
        if (tmp == null || tmp.isEmpty() == true)
        {
            // empty database
            Message.showMessage("Empty database!\n", Color.RED);
            return;
        }

        Message.showMessage("REMOVE A DEALER BY ID", Color.YELLOW_BACKGROUND);
        
        System.out.print("Enter dealer's ID: ");
        String dealerID = ReadInput.ReadUserInput();
        
        if (CheckDealerID(dealerID) != true)
        {
            // invalid dealer ID
            Message.showMessage("Invalid dealer ID\n", Color.RED);
            return;
        }
        
        Boolean isRemoved = RemoveDealerFromDatabase(dealerID);
        
        if (isRemoved == true)
        {
            // remove successful
            Message.showMessage("Remove successful!\n", Color.GREEN);
        }
        else
        {
            // failed to remove
            Message.showMessage("Remove failed!\n", Color.RED);
        }
    }
    
    
    // check validity of dealerID
    private Boolean CheckDealerID(String dealerID)
    {
        Boolean isNullOrBlank = dealerID == null || dealerID.isBlank() == true;
        Boolean isDealerIDFormatValid = PatternCheck.Check(DEALER_ID, dealerID) == true;
        
        return isNullOrBlank == false && isDealerIDFormatValid == true;
    }

    
    // remove dealer from database
    private Boolean RemoveDealerFromDatabase(String dealerID)
    {
        Iterator<Dealer> dealersIterator = Database.GetDatabase().GetDealerDatabase().iterator();
        
        try
        {
            while (dealersIterator.hasNext() == true)
            {
                Dealer currentDealer = dealersIterator.next();

                if (currentDealer == null)
                {
                    // sth wrong
                    return false;
                }

                if (currentDealer.getDealerID().equals(dealerID) == true)
                {
                    dealersIterator.remove();
                    
                    Collections.sort(Database.GetDatabase().GetDealerDatabase(), (dealer1, dealer2) ->
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
