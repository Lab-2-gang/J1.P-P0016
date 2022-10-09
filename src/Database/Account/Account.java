package Database.Account;


public class Account {
    private String username;
    private String password;
    private AccountType accountType;

    public Account(String username, String password, AccountType accountType) {
        this.username = username;
        this.password = password;
        this.accountType = accountType;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {

        return password;
    }

    public AccountType getAccountType() {
        return accountType;
    }

}
