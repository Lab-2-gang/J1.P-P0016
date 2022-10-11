package Persistance;

import java.util.ArrayList;

import Persistance.Entity.Account.Account;
import Persistance.Entity.Dealer.Dealer;
import Persistance.Entity.Delivery.Delivery;
import Persistance.ReadFile.IReadDatabase;
import Persistance.ReadFile.ReadAccountFile;
import Persistance.ReadFile.ReadDealerFile;
import Persistance.ReadFile.ReadDeliveryFile;
import Persistance.SaveFile.SaveDealerFile;
import Tool.DatabaseType;


public class Database
{
    // private Database object
    private static Database database = null;


    // path to config file
    private final String PATH_TO_CONFIG_FILE = "config.dat";
    
    
    // file paths
    private final IFilePath filePaths = new FilePath();
    
    
    // database
    private final ArrayList<Account> accountDatabse;
    private final ArrayList<Dealer> dealerDatabase;
    private final ArrayList<Delivery> deliveryDatabase;
    
    
    public static Database GetDatabase()
    {
        Database local = database;

        if (local == null)
        {
            synchronized(Database.class)
            {
                if (local == null)
                {
                    local = database = new Database();
                }
            }
        }

        return local;
    }


    // private constructor
    private Database()
    {
        filePaths.InitiateFilePath(PATH_TO_CONFIG_FILE);
        
        IReadDatabase<Account> readAccountFile = new ReadAccountFile();
        accountDatabse = readAccountFile.ReadDatabase(filePaths.GetPath(DatabaseType.Accounts));
        
        IReadDatabase<Dealer> readDealerFile = new ReadDealerFile();
        dealerDatabase = readDealerFile.ReadDatabase(filePaths.GetPath(DatabaseType.Dealers));
        
        IReadDatabase<Delivery> readDeliveryFile = new ReadDeliveryFile();
        deliveryDatabase = readDeliveryFile.ReadDatabase(filePaths.GetPath(DatabaseType.Deliveries));
    }
    
    
    // get
    public ArrayList<Account> GetAccountDatabase()
    {
        return accountDatabse;
    }


    public ArrayList<Dealer> GetDealerDatabase()
    {
        return dealerDatabase;
    }


    public ArrayList<Delivery> GetDeliveryDatabase()
    {
        return deliveryDatabase;
    }


    // save
    public void SaveAccountFile()
    {
        SaveDealerFile saveDealer = new SaveDealerFile();
        saveDealer.Save(filePaths.GetPath(DatabaseType.Dealers));
    }
}
