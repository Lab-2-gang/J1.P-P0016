package Database.Config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;
import Database.Tool.IReadFile;
import Database.Tool.ReadFile;
import Database.Tool.ReadFileTool;
import Tool.DatabaseType;


public class ReadConfigFile implements IReadConfigFile
{
    // indicators for config file
    private final String ACCOUNTS_PATH_INDICATOR = "accounts_path";
    private final String DEALERS_PATH_INDICATOR = "dealers_path";
    private final String DELIVERIES_PATH_INDICATOR = "deliveries_path";
    private final String PRODUCTS_PATH_INDICATOR = "products_path";

    
    // delim
    private final String DELIM = "=";


    // read config file
    @Override
    public HashMap<DatabaseType, String> Read(String filePath)
    {
        IReadFile readFileConfig = new ReadFile();
        ArrayList<String> fileContent = readFileConfig.Read(filePath);
        
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
                // error file is blank
                return null;
            }
            
            HashMap<DatabaseType, String> filePaths = new HashMap<>();
            
            while (line != null)
            {
                StringTokenizer tokenizer = new StringTokenizer(line, DELIM);
                String fileIndicator = ReadFileTool.GetNextToken(tokenizer);
                
                if (fileIndicator == null)
                {
                    // error file is corrupted
                    line = ReadFileTool.GetNextLine(fileContent);
                    continue;
                }
                
                SelectFilePath(fileIndicator, tokenizer, filePaths);
                
                line = ReadFileTool.GetNextLine(fileContent);
            }
                    
            return filePaths;
        }
        catch (Exception e)
        {
            // error reading file
            return null;
        }
    }
    
    
    // select what file path is then save accordingly
    private void SelectFilePath(String fileIndicator, StringTokenizer tokenizer, HashMap<DatabaseType, String> filePaths)
    {
        switch (fileIndicator)
        {
            case ACCOUNTS_PATH_INDICATOR ->
            {
                filePaths.put(DatabaseType.Accounts, ReadFileTool.GetNextToken(tokenizer));
            }
            
            case DEALERS_PATH_INDICATOR ->
            {
                filePaths.put(DatabaseType.Dealers, ReadFileTool.GetNextToken(tokenizer));
            }
            
            case DELIVERIES_PATH_INDICATOR ->
            {
                filePaths.put(DatabaseType.Deliveries, ReadFileTool.GetNextToken(tokenizer));
            }
            
            case PRODUCTS_PATH_INDICATOR ->
            {
                filePaths.put(DatabaseType.Products, ReadFileTool.GetNextToken(tokenizer));
            }
            
            default ->
            {
                // error unknown file indicator
                break;
            }
        }
    }
}
