package Database.Account;

import Tool.PatternCheck;

public class CheckAccount {
//check username format
    public static boolean checkUsername(String username) {
        String regex = "^E\\d{3}$";
        PatternCheck.Check(regex, username);
        return username.matches(regex);
    }
//check password format
    public static boolean checkPassword(String password) {
        String regex = "^[\\D]";
        PatternCheck.Check(regex, password);
        return password.matches(regex);
    }
//convert account type to enum
    public static AccountType convertAccountType(String accountType) {
        if (accountType.equals("Boss")) {
            return AccountType.Boss;
        } else if (accountType.equals("Dealer")) {
            return AccountType.Dealer;
        } else if (accountType.equals("Delivery")) {
            return AccountType.Delivery;
        } else {
            return null;
        }
    }
}


