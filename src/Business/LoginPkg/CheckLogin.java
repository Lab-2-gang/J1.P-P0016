package Business.LoginPkg;

import java.util.ArrayList;
import Database.Account.Account;
import Database.Account.AccountType;


public class CheckLogin implements ICheckLogin
{
    // check login using database
    public AccountType checkLogin(String[] login, ArrayList<Account> accounts)
    {
        for (Account account : accounts)
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
