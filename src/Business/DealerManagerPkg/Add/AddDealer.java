package Business.DealerManagerPkg.Add;

import java.util.Collections;
import Business.DealerManagerPkg.Tool.CheckDealer;
import Persistance.Database;
import Persistance.Entity.Dealer.Dealer;
import Presentation.Tool.Color;
import Presentation.Tool.Message;
import Tool.AskForInput;
import Tool.CheckNullOrBlank;
import Tool.PatternCheck;


public class AddDealer implements IAddDealer
{
    // const format
    private static final String TRUE = "^true$";


    // get dealer to add
    public void Add()
    {
        Message.showMessage("ADD A NEW DEALER", Color.YELLOW_BACKGROUND);


        // get dealer id
        String dealerID = AskForInput.Ask("Enter dealer's ID: ");

        if (CheckDealer.CheckDealerID(dealerID) != true)
        {
            // invalid dealerID
            Message.showMessage("Invalid dealer's ID\n", Color.RED);
            return;
        }
        else if (CheckDealer.CheckDealerAlreadyExist(dealerID) == true)
        {
            // duplicate dealer
            Message.showMessage("Dealer already exists\n", Color.RED);
            return;
        }
        

        // get dealer name
        String dealerName = AskForInput.Ask("Enter dealer's name: ");
        
        if (CheckNullOrBlank.Check(dealerName) == true)
        {
            // invalid dealer name
            Message.showMessage("Invalid dealer's name\n", Color.RED);
            return;
        }
        

        // get dealer house
        String dealerHouseNumber = AskForInput.Ask("Enter dealer's house number: ");
        
        if (CheckDealer.CheckDealerHouseNumber(dealerHouseNumber) != true)
        {
            // invalid house number
            Message.showMessage("Invalid dealer's house number\n", Color.RED);
            return;
        }
        

        // get dealer street name
        String dealerStreet = AskForInput.Ask("Enter dealer's street name: ");
        
        if (CheckNullOrBlank.Check(dealerStreet) == true)
        {
            // invalid dealer street
            Message.showMessage("Invalid dealer's street\n", Color.RED);
            return;
        }


        // get dealer phone number
        String dealerPhoneNumber = AskForInput.Ask("Enter dealer's phone number: ");
        
        if (CheckDealer.CheckDealerPhoneNumber(dealerPhoneNumber) != true)
        {
            // invalid dealer phone number
            Message.showMessage("Invalid dealer's phone number\n", Color.RED);
            return;
        }


        // get dealer status
        String dealerStatus = AskForInput.Ask("Enter dealer's status: ");

        if (CheckDealer.CheckDealerStatus(dealerStatus) != true)
        {
            // invalid dealer status
            Message.showMessage("Invalid dealer's status\n", Color.RED);
            return;
        }


        // convert dealer status to boolean
        Boolean dealerStatusBoolean = PatternCheck.Check(TRUE, dealerStatus) == true ? true : false;
        

        // add dealer to database
        AddDealerToDatabase(new Dealer(
            dealerID,
            dealerName,
            dealerHouseNumber,
            dealerStreet,
            dealerPhoneNumber,
            dealerStatusBoolean));


        Message.showMessage("Added!", Color.BLUE);
        Message.showMessage("Go back to main menu...\n", Color.BLUE);
    }
    
    
    // add dealer to database
    private void AddDealerToDatabase(Dealer dealer)
    {
        Database.GetDatabase().GetDealerDatabase().add(dealer);
        
        
        // sort after adding
        Collections.sort(Database.GetDatabase().GetDealerDatabase(), (dealer1, dealer2) ->
            {
                return dealer1.getDealerID().compareTo(dealer2.getDealerID());
            });
    }
}
