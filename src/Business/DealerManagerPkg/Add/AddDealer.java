package Business.DealerManagerPkg.Add;

import java.util.Collections;
import Persistance.Database;
import Persistance.Entity.Dealer.Dealer;
import Presentation.Tools.Color;
import Presentation.Tools.Message;
import Tool.PatternCheck;
import Tool.ReadInput;


public class AddDealer implements IAddDealer
{
    // const format
    private final String DEALER_ID = "^D\\d{3}$";
    private final String DEALER_HOUSENUMBER = "[\\W_]&&[^/]";
    
    
    // get dealer to add
    public void Add()
    {
        Message.showMessage("ADD A NEW DEALER", Color.YELLOW);

        System.out.print("Enter dealer's ID: ");
        String dealerID = ReadInput.ReadUserInput();

        if (CheckDealerID(dealerID) != true)
        {
            // invalid dealerID
            return;
        }
        
        System.out.print("Enter dealer's name: ");
        String dealerName = ReadInput.ReadUserInput();
        
        if (dealerName == null || dealerName.isBlank() == true)
        {
            // invalid dealer name
            return;
        }
        
        System.out.print("Enter dealer's house number: ");
        String dealerHouseNumber = ReadInput.ReadUserInput();
        
        if (dealerHouseNumber == null || dealerHouseNumber.isBlank() == true)
        {
            // invalid dealer house
            return;
        }

        if (PatternCheck.Check(DEALER_HOUSENUMBER, dealerHouseNumber) == true)
        {
            // wrong house number format
            return;
        }
        
        System.out.print("Enter dealer's street name: ");
        String dealerStreet = ReadInput.ReadUserInput();
        
        if (dealerStreet == null || dealerStreet.isBlank() == true)
        {
            // invalid dealer street
            return;
        }
        
        AddDealerToDatabase(new Dealer(
            dealerID,
            dealerName,
            dealerHouseNumber,
            dealerStreet,
            dealerHouseNumber,
            true));

        Message.showMessage("Added!", Color.BLUE);
        Message.showMessage("Go back to main menu...", Color.BLUE);
    }
    
    
    // check validity of dealer ID
    private Boolean CheckDealerID(String dealerID)
    {
        Boolean isNullOrBlank = dealerID == null || dealerID.isBlank() == true;
        Boolean isDealerIDFormatValid = PatternCheck.Check(DEALER_ID, dealerID) == true;
        Boolean isDealerIDAlreadyExist = CheckDealerAlreadyExist(dealerID);
        
        return isNullOrBlank != true
            && isDealerIDFormatValid == true
            && isDealerIDAlreadyExist != true;
    }
    
    
    // check for the existence of dealer before adding
    private Boolean CheckDealerAlreadyExist(String dealerID)
    {
        for (Dealer dealer : Database.GetDatabase().GetDealerDatabase())
        {
            if (dealer.getDealerID().equals(dealerID) == true)
            {
                return true;
            }
        }
        
        return false;
    }
    
    
    // add dealer to database
    private void AddDealerToDatabase(Dealer dealer)
    {
        Database.GetDatabase().GetDealerDatabase().add(dealer);
        
        Collections.sort(Database.GetDatabase().GetDealerDatabase(), (dealer1, dealer2) ->
            {
                return dealer1.getDealerID().compareTo(dealer2.getDealerID());
            });
    }
}
