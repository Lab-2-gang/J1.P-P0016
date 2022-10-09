package Database;

import java.util.ArrayList;
import Database.Account.Account;
import Database.Dealer.Dealer;
import Database.Delivery.Delivery;


public interface IDatabase
{
    public ArrayList<Account> GetAccountDatabase();

    public ArrayList<Dealer> GetDealerDatabase();

    public ArrayList<Delivery> GetDeliveryDatabase();
}
