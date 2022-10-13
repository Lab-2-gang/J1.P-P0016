package Business.DealerManagerPkg.Remove;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import Business.DealerManagerPkg.Tool.CheckDealer;
import Persistance.Database;
import Persistance.Entity.Dealer.Dealer;
import Presentation.Tool.Color;
import Presentation.Tool.Message;
import Tool.AskForInput;


public class RemoveDealer implements IRemoveDealer
{
    // get user input to remove
    @Override
    public void Remove()
    {
        // check is database is empty
        ArrayList<Dealer> tmp = Database.GetDatabase().GetDealerDatabase();
        
        if (tmp == null || tmp.isEmpty() == true)
        {
            // empty database
            Message.showMessage("Empty database!\n", Color.RED);
            return;
        }


        Message.showMessage("REMOVE A DEALER BY ID", Color.YELLOW_BACKGROUND);
        

        // get dealer ID
        String dealerID = AskForInput.Ask("Enter dealer's ID: ");
        
        if (CheckDealer.CheckDealerID(dealerID) != true)
        {
            // invalid dealer ID
            Message.showMessage("Invalid dealer ID\n", Color.RED);
            return;
        }
        

        // remove dealer
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
