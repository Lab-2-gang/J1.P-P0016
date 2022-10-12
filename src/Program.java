import Business.Business;
import Business.LoginPkg.*;
import Persistance.Entity.Account.AccountType;
import Presentation.Tool.Color;
import Presentation.Tool.Message;
import Tool.ClearConsole;
import Tool.ReadInput;


public class Program
{
    public static void main(String[] args)
    {
        ClearConsole.Clear();

        Business business = new Business();
        
        while (true)
        {
            Message.showMessage("Welcome to Dealer Management Program\n", Color.GREEN);

            System.out.println("===============================================");
            System.out.println("1. Login");
            System.out.println("2. Exit");
            System.out.print("Enter your option: ");

            String userInput = ReadInput.Read();

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

                    ClearConsole.Clear();
                    
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
                            Message.showMessage("To be implemented\n", Color.BLUE);
                        }

                        case Dealer ->
                        {
                            business.BusinessDelegate(AccountType.Dealer);
                        }

                        case Delivery ->
                        {
                            Message.showMessage("To be implemented\n", Color.BLUE);
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
