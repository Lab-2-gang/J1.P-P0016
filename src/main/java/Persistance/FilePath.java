package Persistance;

import java.util.HashMap;
import Persistance.Config.IReadConfigFile;
import Persistance.Config.ReadConfigFile;
import Tool.DatabaseType;


public class FilePath implements IFilePath
{
    // path to config file
    private String CONFIG_PATH = "config.dat";


    // paths to files
    private String pathToAccountsFile = null;
    private String pathToDealersFile = null;
    private String pathToDeliveriesFile = null;
    
    
    // initiate config file and get file paths
    @Override
    public void InitiateFilePath()
    {
        IReadConfigFile configFile = new ReadConfigFile();
        HashMap<DatabaseType, String> filePaths = configFile.Read(CONFIG_PATH);
        
        if (filePaths == null)
        {
            // error cannot read config file
            return;
        }
        
        for (HashMap.Entry<DatabaseType, String> item : filePaths.entrySet())
        {
            switch (item.getKey())
            {
                case Accounts -> pathToAccountsFile = item.getValue();
                
                case Dealers -> pathToDealersFile = item.getValue();
                
                case Deliveries -> pathToDeliveriesFile = item.getValue();
                
                default ->
                {
                    // error unknown value
                }
            }
        }
    }
    
    
    // get paths
    @Override
    public String GetPath(DatabaseType type)
    {
        switch (type)
        {
            case Accounts ->
            {
                return pathToAccountsFile;
            }
            
            case Dealers ->
            {
                return pathToDealersFile;
            }
            
            case Deliveries ->
            {
                return pathToDeliveriesFile;
            }
            
            default ->
            {
                return null;
            }
        }
    }
}
