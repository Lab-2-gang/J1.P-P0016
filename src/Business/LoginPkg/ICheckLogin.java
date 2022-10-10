package Business.LoginPkg;

import java.util.ArrayList;
import Database.Account.Account;
import Database.Account.AccountType;


public interface ICheckLogin
{
    public AccountType Check(String[] login, ArrayList<Account> accounts);
}
