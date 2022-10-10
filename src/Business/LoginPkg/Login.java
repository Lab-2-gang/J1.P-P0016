package Business.LoginPkg;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Presentation.Tools.Color;
import Presentation.Tools.Message;
import Tool.ReadInput;


public class Login implements ILogin
{
    // read user login
    public String[] ReadLogin()
    {
        String username;
        String password;
        
        try
        {
            System.out.print("Enter username: ");
            username = ReadInput.ReadUserInput();

            System.out.print("Enter password: ");
            password = ReadInput.ReadUserInput();

            if (CheckPassword(password) != true || CheckUsername(username) != true)
            {
                // error (reported)
                return null;
            }

            return new String[] {username, password};   // 0. username  1. password
        }
        catch (Exception e)
        {
            System.out.println("Error login!\n");
            return null;
        }
    }


    // check validity of username
    private Boolean CheckUsername(String username)
    {
        try
        {
            Pattern pattern = Pattern.compile("^E\\d{3}$");
            Matcher matcher = pattern.matcher(username);

            if (matcher.find() == true)
            {
                return true;
            }
            else
            {
                Message.showMessage("Invalid username\n", Color.RED);
                return false;
            }
        }
        catch (Exception e)
        {
            Message.showMessage("Error login!\n", Color.RED);
            return false;
        }
    }


    // check validity of password
    private Boolean CheckPassword(String password)
    {
        // Password is unlimited characters and numbers
        // Return Boolean

        try
        {
            Pattern pattern = Pattern.compile("^[\\D]");
            Matcher matcher = pattern.matcher(password);

            if (matcher.find() == true)
            {
                return true;
            }
            else
            {
                Message.showMessage("Invalid password\n", Color.RED);
                return false;
            }
        }
        catch (Exception e)
        {
            Message.showMessage("Error login!\n", Color.RED);
            return false;
        }
    }
}
