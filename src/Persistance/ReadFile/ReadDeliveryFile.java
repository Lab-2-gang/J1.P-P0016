package Persistance.ReadFile;

import java.util.Collections;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.StringTokenizer;

import Persistance.Delivery.Delivery;
import Persistance.Tool.IReadFile;
import Persistance.Tool.ReadFile;
import Persistance.Tool.ReadFileTool;
import Tool.PatternCheck;


public class ReadDeliveryFile implements IReadDatabase<Delivery>
{
    // const format
    private final String ID_FORMAT = "^R\\d{3}$";
    private final String PHONE_NUMBER_FORMAT = "^\\d{9}$|^\\d{11}$";
    
    
    // delim
    private final String FIELD_DELIM = ";";
    
    
    // read delivery file
    @Override
    public ArrayList<Delivery> ReadDatabase(String filePath)
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
            
            ArrayList<Delivery> deliveries = new ArrayList<>();
            
            while (line != null)
            {
                StringTokenizer tokenizer = new StringTokenizer(line, FIELD_DELIM);
                
                String[] delivery = new String[]
                    {
                        ReadFileTool.GetNextToken(tokenizer),    // 0. id
                        ReadFileTool.GetNextToken(tokenizer),    // 1. name
                        ReadFileTool.GetNextToken(tokenizer),    // 2. homeNum
                        ReadFileTool.GetNextToken(tokenizer),    // 3. street
                        ReadFileTool.GetNextToken(tokenizer)     // 4. phoneNum
                    };
                
                if (CheckDelivery(delivery) != true)
                {
                    // error wrong data format
                    line = ReadFileTool.GetNextLine(fileContent);
                    continue;
                }
                
                deliveries.add(new Delivery(
                    delivery[0],
                    delivery[1],
                    delivery[2],
                    delivery[3],
                    delivery[4]));

                line = ReadFileTool.GetNextLine(fileContent);
            }
            
            Collections.sort(deliveries, (delivery1, delivery2) ->
                {
                    return delivery1.getDeliveryID().compareTo(delivery2.getDeliveryID());
                });
            
            if (CheckDuplicateDelivery(deliveries) != true)
            {
                // delivery file has duplicate item
                return null;
            }
            
            return deliveries;
        }
        catch (Exception e)
        {
            // error cannot read file
            return null;
        }
    }

    
    // check validity of dealer before adding to database
    private Boolean CheckDelivery(String[] delivery)
    {
        Boolean isNullOrBlank = false;
        Boolean isDeliveryIDValid = false;
        Boolean isRecipientPhoneNumberValid = false;
                
        try
        {
            isDeliveryIDValid = PatternCheck.Check(ID_FORMAT, delivery[0]) == true;
            isRecipientPhoneNumberValid = PatternCheck.Check(PHONE_NUMBER_FORMAT, delivery[5]) == true;
            
            for (String item : delivery)
            {
                if (item == null || item.isBlank())
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
        
        return isNullOrBlank == false && isDeliveryIDValid == true && isRecipientPhoneNumberValid == true;
    }
    
    
    // check duplicate delivery
    private Boolean CheckDuplicateDelivery(ArrayList<Delivery> deliveries)
    {
        Iterator<Delivery> deliveriesIterator = deliveries.iterator();
        String checkID = deliveriesIterator.hasNext() == true ? deliveriesIterator.next().getDeliveryID() : null;
        
        while (checkID != null)
        {
            String afterCheckID = deliveriesIterator.hasNext() == true ? deliveriesIterator.next().getDeliveryID() : null;
            
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
