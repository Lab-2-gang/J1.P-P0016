package Business.LoginPkg;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
            System.out.println("Enter username: ");
            username = ReadInput.ReadUserInput();

            System.out.println("Enter password: ");
            password = ReadInput.ReadUserInput();

            if (CheckPassword(password) != true || CheckUsername(username) != true)
            {
                // invalid format
                return null;
            }

            return new String[] {username, password};   // 0. username  1. password
        }
        catch (Exception e)
        {
            // cannot read
            return null;
        }
    }


    // check validity of username
    private Boolean CheckUsername(String username)
    {
        // Exxx and xxx are numbers
        // Return Boolean
        try
        {
            Pattern pattern = Pattern.compile("^E\\d{3}$");
            Matcher matcher = pattern.matcher(username);

            if (matcher.find() == true)
                return true;
            else
            {
                System.out.println("Invalid username.");
                return false;
            }
        }
        catch (Exception e)
        {
            // error
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
                return true;
            else
                return false;
        }
        catch (Exception e)
        {
            // error
            return false;
        }
    }
}
