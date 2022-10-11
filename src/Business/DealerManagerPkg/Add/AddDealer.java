package Business.DealerManagerPkg.Add;

import java.util.ArrayList;
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
    private final String DEALER_PHONENUMBER = "^\\d{9}$|^\\d{11}$";
    private final String DEALER_HOUSENUMBER = "[[\\W_]&&[^/]]";
    private final String TRUE = "^true$";
    private final String FALSE = "^false$";
    
    
    // get dealer to add
    public void Add()
    {
        ArrayList<Dealer> tmp = Database.GetDatabase().GetDealerDatabase();

        if (tmp == null || tmp.isEmpty() == true)
        {
            // empty database
            Message.showMessage("Empty database!\n", Color.RED);
            return;
        }

        Message.showMessage("ADD A NEW DEALER", Color.YELLOW);

        System.out.print("Enter dealer's ID: ");
        String dealerID = ReadInput.ReadUserInput();

        if (CheckDealerID(dealerID) != true)
        {
            // invalid dealerID
            Message.showMessage("Invalid dealer's ID\n", Color.RED);
            return;
        }
        else if (CheckDealerAlreadyExist(dealerID) == true)
        {
            // duplicate dealer
            Message.showMessage("Dealer already exists\n", Color.RED);
            return;
        }
        
        System.out.print("Enter dealer's name: ");
        String dealerName = ReadInput.ReadUserInput();
        
        if (dealerName == null || dealerName.isBlank() == true)
        {
            // invalid dealer name
            Message.showMessage("Invalid dealer's name\n", Color.RED);
            return;
        }
        
        System.out.print("Enter dealer's house number: ");
        String dealerHouseNumber = ReadInput.ReadUserInput();
        
        if (CheckDealerHouseNumber(dealerHouseNumber) != true)
        {
            // invalid house number
            Message.showMessage("Invalid dealer's house number\n", Color.RED);
            return;
        }
        
        System.out.print("Enter dealer's street name: ");
        String dealerStreet = ReadInput.ReadUserInput();
        
        if (dealerStreet == null || dealerStreet.isBlank() == true)
        {
            // invalid dealer street
            Message.showMessage("Invalid dealer's street\n", Color.RED);
            return;
        }

        System.out.print("Enter dealer's phone number: ");
        String dealerPhoneNumber = ReadInput.ReadUserInput();
        
        if (CheckDealerPhoneNumber(dealerPhoneNumber) != true)
        {
            // invalid dealer phone number
            Message.showMessage("Invalid dealer's phone number\n", Color.RED);
            return;
        }

        System.out.print("Enter dealer's status: ");
        String dealerStatus = ReadInput.ReadUserInput();

        if (CheckDealerStatus(dealerStatus) != true)
        {
            // invalid dealer status
            Message.showMessage("Invalid dealer's status\n", Color.RED);
            return;
        }

        Boolean dealerStatusBoolean = PatternCheck.Check(TRUE, dealerStatus) == true ? true : false;
        
        AddDealerToDatabase(new Dealer(
            dealerID,
            dealerName,
            dealerHouseNumber,
            dealerStreet,
            dealerHouseNumber,
            dealerStatusBoolean));

        Message.showMessage("Added!", Color.BLUE);
        Message.showMessage("Go back to main menu...\n", Color.BLUE);
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
    private Boolean CheckDealerAlreadyExist(String dealerID)
    {
        for (Dealer dealer : Database.GetDatabase().GetDealerDatabase())
        {
            if (dealer.getDealerID().equals(dealerID) == true)
            {
                // duplicate dealer
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
