package Business.LoginPkg;

import Persistance.Database;
import Persistance.Account.Account;
import Persistance.Account.AccountType;


public class CheckLogin implements ICheckLogin
{
    // check login using database
    public AccountType Check(String[] login)
    {
        for (Account account : Database.GetDatabase().GetAccountDatabase())
        {
            if (account.getUsername().equals(login[0]) && account.getPassword().equals(login[1]))
            {
                // if true return AccountType
                System.out.println("Login success");
                return account.getAccountType();
                // else return null (cannot find the account)
            } 
        }

        System.out.println("Login failed");
        return null;
    }
}
