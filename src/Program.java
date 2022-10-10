import Business.Business;
import Business.LoginPkg.*;
import Persistance.Entity.Account.AccountType;
import Presentation.Tools.Color;
import Presentation.Tools.Message;
import Tool.ReadInput;


public class Program
{
    public static void main(String[] args)
    {
        System.out.print("\033[H\033[2J");
        System.out.flush();

        Message.showMessage("Welcome to Dealer Management Program\n", Color.GREEN);

        Business business = new Business();
        
        while (true)
        {
            System.out.println("===============================================");
            System.out.println("1. Login");
            System.out.println("2. Exit");
            System.out.print("Enter your option: ");

            String userInput = ReadInput.ReadUserInput();

            if (userInput == null || userInput.isBlank() == true)
            {
                Message.showMessage("No input was founded\n", Color.RED);
                continue;
            }

            switch (userInput)
            {
                case "1" ->
                {
                    ILogin userLogin = new Login();
                    String[] userLoginInformation = userLogin.ReadLogin();

                    if (userLoginInformation == null)
                    {
                        // get login failed (reported)
                        continue;
                    }

                    ICheckLogin checkLogin = new CheckLogin();
                    AccountType accountType = checkLogin.Check(userLoginInformation);

                    if (accountType == null)
                    {
                        // account does not exist (reported)
                        continue;
                    }

                    switch (accountType)
                    {
                        case Boss ->
                        {
                            Message.showMessage("To be implemented\n", Color.RED);
                        }

                        case Dealer ->
                        {
                            business.BusinessDelegate(AccountType.Dealer);
                        }

                        case Delivery ->
                        {
                            Message.showMessage("To be implemented\n", Color.RED);
                        }

                        default ->
                        {
                            Message.showMessage("Unknown account type!\n", Color.RED);
                        }
                    }
                }

                case "2" ->
                {
                    Message.showMessage("Exiting program...\n", Color.GREEN);
                    System.exit(0);
                }

                default ->
                {
                    Message.showMessage("Invalid input\n", Color.RED);
                    continue;
                }
            }
        }
    }
}
