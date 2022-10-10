package Persistance.Account;

import Tool.PatternCheck;


public class CheckAccount
{
    //check username format
    public static boolean checkUsername(String username)
    {
        String regex = "^E\\d{3}$";
        return PatternCheck.Check(regex, username);
    }


    //check password format
    public static boolean checkPassword(String password)
    {
        String regex = "^[\\D]";
        return PatternCheck.Check(regex, password);
    }


    //convert account type to enum
    public static AccountType convertAccountType(String accountType)
    {
        switch (accountType)
        {
            case "Boss" ->
            {
                return AccountType.Boss;
            }

            case "Dealer" ->
            {
                return AccountType.Dealer;
            }

            case "Delivery" ->
            {
                return AccountType.Delivery;
            }

            default ->
            {
                // cannot get account type
                return null;
            }
        }
    }
}


