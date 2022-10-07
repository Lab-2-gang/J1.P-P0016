package Database;

import java.util.ArrayList;

import Database.Account.Account;
import Database.Dealer.Dealer;
import Database.Delivery.Delivery;

public class Database
{
    // data
    private ArrayList<Account> accounts;
    private ArrayList<Dealer> dealers;
    private ArrayList<Delivery> deliveries;


    // get, set
    public ArrayList<Account> getAccounts()
    {
        return accounts;
    }
    
    public ArrayList<Dealer> getDealers()
    {
        return dealers;
    }

    public ArrayList<Delivery> getDeliveries()
    {
        return deliveries;
    }
}
