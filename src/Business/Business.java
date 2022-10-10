package Business;

import Business.DealerManagerPkg.*;
import Persistance.Account.AccountType;


public class Business
{
    // delegate business
    public void BusinessDelegate(AccountType type)
    {
        switch (type)
        {
            case Boss ->
            {
                // TO-DO
            }

            case Dealer ->
            {
                IDealerManager dealerManager = new DealerManager();
                dealerManager.DealerManagerMenu();
            }

            case Delivery ->
            {
                // TO-DO
            }
        }
    }
}
