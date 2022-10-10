package Business.LoginPkg;

import Database.Account.AccountType;


public interface ICheckLogin
{
    public AccountType Check(String[] login);
}
