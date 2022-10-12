package Persistance;

import java.util.ArrayList;
import Persistance.Entity.Account.Account;
import Persistance.Entity.Dealer.Dealer;
import Persistance.ReadFile.*;
import Persistance.SaveFile.SaveDealerFile;
import Tool.DatabaseType;


public class Database
{
    // private Database object
    private static volatile Database database = null;
    
    
    // file paths
    private final IFilePath filePaths = new FilePath();
    
    
    // database
    private final ArrayList<Account> accountDatabse;
    private final ArrayList<Dealer> dealerDatabase;
    
    
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
        // initiate data
        InitializeData.Initiate();


        // get file paths
        filePaths.InitiateFilePath();
        

        // read account file
        IReadDatabase<Account> readAccountFile = new ReadAccountFile();
        accountDatabse = readAccountFile.ReadDatabase(filePaths.GetPath(DatabaseType.Accounts));
        

        // read dealers file
        IReadDatabase<Dealer> readDealerFile = new ReadDealerFile();
        dealerDatabase = readDealerFile.ReadDatabase(filePaths.GetPath(DatabaseType.Dealers));
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


    // save
    public void SaveAccountFile()
    {
        SaveDealerFile saveDealer = new SaveDealerFile();
        saveDealer.Save(filePaths.GetPath(DatabaseType.Dealers));
    }
}
