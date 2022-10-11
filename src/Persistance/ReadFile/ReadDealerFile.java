package Persistance.ReadFile;

import java.util.Collections;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.StringTokenizer;

import Persistance.Entity.Dealer.Dealer;
import Persistance.Tool.IReadFile;
import Persistance.Tool.ReadFile;
import Persistance.Tool.ReadFileTool;
import Tool.PatternCheck;


public class ReadDealerFile implements IReadDatabase<Dealer>
{
    // const format
    private final String ID_FORMAT = "^D\\d{3}$";
    private final String PHONE_NUMBER_FORMAT = "^\\d{9}$|^\\d{11}$";
    private final String DEALER_HOUSENUMBER = "[[\\W_]&&[^/]]";
    private final String TRUE = "^true$";
    private final String FALSE = "^false$";
    
    
    // const delim
    private final String DELIM = ";";
    
    
    // read dealers file
    @Override
    public ArrayList<Dealer> ReadDatabase(String filePath)
    {
        IReadFile readFile = new ReadFile();
        ArrayList<String> fileContent = readFile.Read(filePath);
        
        if (fileContent == null)
        {
            // error file is empty
            return null;
        }
        
        try
        {
            String line = ReadFileTool.GetNextLine(fileContent);
            
            if (line == null)
            {
                // error file is empty
                return null;
            }
            
            ArrayList<Dealer> dealers = new ArrayList<>();
            
            while (line != null)
            {
                StringTokenizer tokenizer = new StringTokenizer(line, DELIM);
                
                String[] dealer = new String[]
                    {
                        ReadFileTool.GetNextToken(tokenizer),   // 0. id
                        ReadFileTool.GetNextToken(tokenizer),   // 1. name
                        ReadFileTool.GetNextToken(tokenizer),   // 2. homeNum
                        ReadFileTool.GetNextToken(tokenizer),   // 3. street
                        ReadFileTool.GetNextToken(tokenizer),   // 4. phoneNum
                        ReadFileTool.GetNextToken(tokenizer),   // 5. is continuing ?
                    };
                
                if (CheckDealer(dealer) == false)
                {
                    // error wrong account format
                    line = ReadFileTool.GetNextLine(fileContent);
                    continue;
                }
                
                dealers.add(new Dealer(
                    dealer[0],
                    dealer[1],
                    dealer[2],
                    dealer[3],
                    dealer[4],
                    dealer[5].equals("true")));

                line = ReadFileTool.GetNextLine(fileContent);
            }
            
            Collections.sort(dealers, (dealer1, dealer2) ->
                {
                    return dealer1.getDealerID().compareTo(dealer2.getDealerID());
                });
            
            if (CheckDuplicateDealer(dealers) != true)
            {
                // has duplicate dealer
                return null;
            }
            
            return dealers;
        }
        catch (Exception e)
        {
            // error cannot read file
            return null;
        }
    }
    
    
    // check validity of dealer before adding to database
    private Boolean CheckDealer(String[] dealer)
    {
        Boolean isNullOrBlank = false;
        Boolean isDealerIDValid = false;
        Boolean isDealerHouseNumberValid = false;
        Boolean isDealerPhoneNumberValid = false; 
        Boolean isDealerContinuingValid = false; 
              
        try
        {
            isDealerIDValid = PatternCheck.Check(ID_FORMAT, dealer[0]) == true;
            isDealerPhoneNumberValid = PatternCheck.Check(PHONE_NUMBER_FORMAT, dealer[4]) == true;
            isDealerContinuingValid = PatternCheck.Check(TRUE, dealer[5]) == true
                || PatternCheck.Check(FALSE, dealer[5]) == true;
            
            isDealerHouseNumberValid = PatternCheck.Check(DEALER_HOUSENUMBER, dealer[2]) != true;
            
            for (String item : dealer)
            {
                if (item == null || item.isEmpty())
                {
                    isNullOrBlank = true;
                    break;
                }
            }
        }
        catch (Exception e)
        {
            // error null pointer
        }
        
        return isNullOrBlank == false
            && isDealerIDValid == true
            && isDealerPhoneNumberValid == true
            && isDealerContinuingValid == true
            && isDealerHouseNumberValid == true;
    }


    // check duplicate dealer
    private Boolean CheckDuplicateDealer(ArrayList<Dealer> dealers)
    {
        Iterator<Dealer> deliveriesIterator = dealers.iterator();

        String checkID = deliveriesIterator.hasNext() == true ?
            deliveriesIterator.next().getDealerID() : null;
        
        while (checkID != null)
        {
            String afterCheckID = deliveriesIterator.hasNext() == true ?
                deliveriesIterator.next().getDealerID() : null;
            
            if (checkID.equals(afterCheckID) == true)
            {
                // has duplicate
                return false;
            }
            
            checkID = afterCheckID;
        }
        
        return true;
    }
}
