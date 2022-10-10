package Business.DealerManagerPkg.Update;

import java.util.Collections;

import Persistance.Dealer.Dealer;

import java.util.ArrayList;

import Presentation.Tools.Color;
import Presentation.Tools.Message;
import Tool.PatternCheck;
import Tool.ReadInput;


public class UpdateDealer implements IUpdateDealer
{
    // const format
    private final String DEALER_ID = "^D\\d{3}$";
    private final String DEALER_HOUSENUMBER = "[\\w\\/&&[^_]]";
    
    
    // get user input to update
    public void Update(ArrayList<Dealer> dealers)
    {
        if (dealers.isEmpty() == true)
        {
            // empty database
            return;
        }

        Message.showMessage("UPDATE A DEALER BY ID", Color.YELLOW_BACKGROUND);

        System.out.print("Enter dealer's ID: ");
        String dealerID = ReadInput.ReadUserInput();

        if (CheckDealerID(dealerID) != true)
        {
            // invalid dealerID
            Message.showMessage("Invalid dealer's ID", Color.RED);
            return;
        }
        else if (CheckDealerExist(dealerID, dealers) != true)
        {
            // dealer does not exist to update
            Message.showMessage("Dealer does not exist!", Color.RED);
            return;
        }
        
        System.out.println("Found dealer");
        System.out.println("Update initialized");
        System.out.print("Enter dealer's ID: ");
        String dealerIDUpdate = ReadInput.ReadUserInput();

        if (CheckDealerID(dealerIDUpdate) != true)
        {
            // invalid dealerID
            Message.showMessage("Invalid dealer's ID", Color.RED);
            return;
        }
        
        System.out.print("Enter dealer's name: ");
        String dealerNameUpdate = ReadInput.ReadUserInput();
        
        if (dealerNameUpdate == null || dealerNameUpdate.isBlank() == true)
        {
            // invalid dealer name
            Message.showMessage("Invalid dealer's name", Color.RED);
            return;
        }
        
        System.out.print("Enter dealer's house number: ");
        String dealerHouseNumberUpdate = ReadInput.ReadUserInput();
        
        if (dealerHouseNumberUpdate == null || dealerHouseNumberUpdate.isBlank() == true)
        {
            // invalid dealer house
            Message.showMessage("Invalid dealer's house number", Color.RED);
            return;
        }
        if (PatternCheck.Check(DEALER_HOUSENUMBER, dealerHouseNumberUpdate) != true)
        {
            // wrong house number format
            Message.showMessage("Wrong dealer's house number format", Color.RED);
            return;
        }
        
        System.out.print("Enter dealer's street name: ");
        String dealerStreetUpdate = ReadInput.ReadUserInput();
        
        if (dealerStreetUpdate == null || dealerStreetUpdate.isBlank() == true)
        {
            // invalid dealer street
            Message.showMessage("Invalid dealer's street", Color.RED);
            return;
        }
        
        Dealer dealer = new Dealer(
            dealerIDUpdate,
            dealerNameUpdate,
            dealerHouseNumberUpdate,
            dealerStreetUpdate,
            dealerHouseNumberUpdate,
            true);
        
        Boolean isUpdate = UpdateDealerToDatabase(dealer, dealers);
        
        if (isUpdate == true)
        {
            // update successful
            Message.showMessage("Update successful!", Color.BLUE);
        }
        else
        {
            // failed to update
            Message.showMessage("Cannot update", Color.RED);
        }
    }
    
    
    // check validity of dealer ID
    private Boolean CheckDealerID(String dealerID)
    {
        Boolean isNullOrBlank = dealerID == null || dealerID.isBlank() == true;
        Boolean isDealerIDFormatValid = PatternCheck.Check(DEALER_ID, dealerID) == true;
        
        return isNullOrBlank != true && isDealerIDFormatValid == true;
    }
    
    
    // check for the existence of dealer before adding
    public Boolean CheckDealerExist(String dealerID, ArrayList<Dealer> dealers)
    {
        for (Dealer dealer : dealers)
        {
            if (dealer.getDealerID().equals(dealerID) == true)
            {
                return true;
            }
        }
        
        return false;
    }
    
    
    // add dealer to database
    private Boolean UpdateDealerToDatabase(Dealer dealer, ArrayList<Dealer> dealers)
    {
        for (Dealer traverseDealer : dealers)
        {
            if (traverseDealer.getDealerID().equals(dealer.getDealerID()) == true)
            {
                dealers.set(dealers.indexOf(traverseDealer), dealer);
                
                Collections.sort(dealers, (dealer1, dealer2) ->
                    {
                        return dealer1.getDealerID().compareTo(dealer2.getDealerID());
                    });
                
                return true;
            }
        }
        
        return false;
    }
}
