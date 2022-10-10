package Business.LoginPkg;

import Persistance.Account.AccountType;


public interface ICheckLogin
{
    public AccountType Check(String[] login);
}
