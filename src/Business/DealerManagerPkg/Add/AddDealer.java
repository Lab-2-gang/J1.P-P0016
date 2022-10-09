package Business.DealerManagerPkg.Add;

import java.util.Collections;
import java.util.ArrayList;
import Database.Dealer.Dealer;
import Tool.PatternCheck;
import Tool.ReadInput;


public class AddDealer implements IAddDealer
{
    // const format
    private final String DEALER_ID = "^D\\d{3}$";
    private final String DEALER_HOUSENUMBER = "[\\w\\/&&[^_]]";
    
    
    // get dealer to add
    public void Add(ArrayList<Dealer> dealers)
    {
        System.out.print("Enter dealer's ID: ");
        String dealerID = ReadInput.ReadUserInput();

        if (CheckDealerID(dealerID, dealers) != true)
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
        if (PatternCheck.Check(DEALER_HOUSENUMBER, dealerHouseNumber) != true)
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
            true),
            dealers);
    }
    
    
    // check validity of dealer ID
    private Boolean CheckDealerID(String dealerID, ArrayList<Dealer> dealers)
    {
        Boolean isNullOrBlank = dealerID == null || dealerID.isBlank() == true;
        Boolean isDealerIDFormatValid = PatternCheck.Check(DEALER_ID, dealerID) == true;
        Boolean isDealerIDAlreadyExist = CheckDealerAlreadyExist(dealerID, dealers);
        
        return isNullOrBlank != true && isDealerIDFormatValid == true && isDealerIDAlreadyExist != true;
    }
    
    
    // check for the existence of dealer before adding
    private Boolean CheckDealerAlreadyExist(String dealerID, ArrayList<Dealer> dealers)
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
    private void AddDealerToDatabase(Dealer dealer, ArrayList<Dealer> dealers)
    {
        dealers.add(dealer);
        
        Collections.sort(dealers, (dealer1, dealer2) ->
            {
                return dealer1.getDealerID().compareTo(dealer2.getDealerID());
            });
    }
}
