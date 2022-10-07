package Database.Account;


public class Account
{
    // account info
    private String username;
    private String password;
    private AccountType accountType;


    // get, set
    public String getUsername()
    {
        return username;
    }

    public String getPassword()
    {
        return password;
    }

    public AccountType getAccountType()
    {
        return accountType;
    }
}
