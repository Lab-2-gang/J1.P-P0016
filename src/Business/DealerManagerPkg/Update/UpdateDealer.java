package Business.DealerManagerPkg.Update;

import java.util.Collections;
import Persistance.Database;
import Persistance.Entity.Dealer.Dealer;
import java.util.ArrayList;
import Presentation.Tools.Color;
import Presentation.Tools.Message;
import Tool.PatternCheck;
import Tool.ReadInput;


public class UpdateDealer implements IUpdateDealer
{
    // const format
    private final String DEALER_ID = "^D\\d{3}$";
    private final String DEALER_HOUSENUMBER = "[[\\W_]&&[^/]]";
    private final String DEALER_PHONENUMBER = "^\\d{9}$|^\\d{11}$";
    private final String TRUE = "^true$";
    private final String FALSE = "^false$";
    
    
    // get user input to update
    public void Update()
    {
        ArrayList<Dealer> tmp = Database.GetDatabase().GetDealerDatabase();
        
        if (tmp == null || tmp.isEmpty() == true)
        {
            // empty database
            Message.showMessage("Empty database!\n", Color.RED);
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
        else if (CheckDealerExist(dealerID) != true)
        {
            // dealer does not exist to update
            Message.showMessage("Dealer does not exist!", Color.RED);
            return;
        }
        
        Message.showMessage("Found dealer!", Color.GREEN);
        Message.showMessage("Update initialized...\n", Color.GREEN);

        System.out.print("Enter dealer's ID: ");
        String dealerIDUpdate = ReadInput.ReadUserInput();

        if (CheckDealerID(dealerIDUpdate) != true)
        {
            // invalid dealerID
            Message.showMessage("Invalid dealer's ID\n", Color.RED);
            return;
        }
        
        System.out.print("Enter dealer's name: ");
        String dealerNameUpdate = ReadInput.ReadUserInput();
        
        if (dealerNameUpdate == null || dealerNameUpdate.isBlank() == true)
        {
            // invalid dealer name
            Message.showMessage("Invalid dealer's name\n", Color.RED);
            return;
        }
        
        System.out.print("Enter dealer's house number: ");
        String dealerHouseNumberUpdate = ReadInput.ReadUserInput();
        
        if (CheckDealerHouseNumber(dealerHouseNumberUpdate) != true)
        {
            // invalid dealer house
            Message.showMessage("Invalid dealer's house number\n", Color.RED);
            return;
        }
        
        System.out.print("Enter dealer's street name: ");
        String dealerStreetUpdate = ReadInput.ReadUserInput();
        
        if (dealerStreetUpdate == null || dealerStreetUpdate.isBlank() == true)
        {
            // invalid dealer street
            Message.showMessage("Invalid dealer's street\n", Color.RED);
            return;
        }

        System.out.print("Enter dealer's phone number: ");
        String dealerPhoneNumberUpdate = ReadInput.ReadUserInput();
        
        if (CheckDealerPhoneNumber(dealerPhoneNumberUpdate) != true)
        {
            // invalid dealer phone number
            Message.showMessage("Invalid dealer's phone number\n", Color.RED);
            return;
        }

        System.out.print("Enter dealer's status: ");
        String dealerStatusUpdate = ReadInput.ReadUserInput();

        if (CheckDealerStatus(dealerStatusUpdate) != true)
        {
            // invalid dealer status
            Message.showMessage("Invalid dealer's status\n", Color.RED);
            return;
        }

        Boolean dealerStatusBoolean = PatternCheck.Check(TRUE, dealerStatusUpdate) == true ? true : false;
        
        Dealer dealer = new Dealer(
            dealerIDUpdate,
            dealerNameUpdate,
            dealerHouseNumberUpdate,
            dealerStreetUpdate,
            dealerPhoneNumberUpdate,
            dealerStatusBoolean);
        
        Boolean isUpdate = UpdateDealerToDatabase(dealer, dealerID);
        
        if (isUpdate == true)
        {
            // update successful
            Message.showMessage("Update successful!\n", Color.GREEN);
        }
        else
        {
            // failed to update
            Message.showMessage("Cannot update\n", Color.RED);
        }
    }
    
    
    // check validity of dealer ID
    private Boolean CheckDealerID(String dealerID)
    {
        Boolean isNullOrBlank = dealerID == null || dealerID.isBlank() == true;
        Boolean isDealerIDFormatValid = PatternCheck.Check(DEALER_ID, dealerID) == true;
        
        return isNullOrBlank != true && isDealerIDFormatValid == true;
    }


    // check validity of dealer house number
    private Boolean CheckDealerHouseNumber(String dealerHouseNumber)
    {
        Boolean isNullOrBlank = dealerHouseNumber == null || dealerHouseNumber.isBlank() == true;
        Boolean isDealerHouseNumberFormatValid = PatternCheck.Check(DEALER_HOUSENUMBER, dealerHouseNumber) != true;

        return isNullOrBlank != true && isDealerHouseNumberFormatValid == true;
    }


    // check validity of dealer phone number
    private Boolean CheckDealerPhoneNumber(String dealerPhoneNumber)
    {
        Boolean isNullOrBlank = dealerPhoneNumber == null || dealerPhoneNumber.isBlank() == true;
        Boolean isDealerPhoneNumberValid = PatternCheck.Check(DEALER_PHONENUMBER, dealerPhoneNumber) == true;

        return isNullOrBlank != true && isDealerPhoneNumberValid == true;
    }


    // check validity of dealer status
    private Boolean CheckDealerStatus(String dealerStatus)
    {
        Boolean isNullOrBlank = dealerStatus == null || dealerStatus.isBlank() == true;
        Boolean isDealerStatusValid = PatternCheck.Check(TRUE, dealerStatus)
            || PatternCheck.Check(FALSE, dealerStatus);

        return isNullOrBlank != true && isDealerStatusValid == true;
    }
    
    
    // check for the existence of dealer before adding
    public Boolean CheckDealerExist(String dealerID)
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
    private Boolean UpdateDealerToDatabase(Dealer dealer, String dealerIDToUpdate)
    {
        ArrayList<Dealer> dealers = Database.GetDatabase().GetDealerDatabase();

        for (Dealer traverseDealer : dealers)
        {
            if (traverseDealer.getDealerID().equals(dealerIDToUpdate) == true)
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
