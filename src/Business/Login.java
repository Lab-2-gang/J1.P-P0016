package Business;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Login {

    String username = null;
    String password = null;

    // Class Login can read username and password as string
    // return String [] with username and password

    public String[] ReadInput() {
        String[] input = new String[2];
        try {
            System.out.println("Enter username: ");
            username = new ReadInput().ReadInput();
            System.out.println("Enter password: ");
            password = new ReadInput().ReadInput();
            input[0] = username;
            input[1] = password;
            return input;
        } catch (Exception e) {
            // cannot read
            return null;
        }
    }

    public void CheckUsername(String username) {
        // Exxx and xxx are numbers
        // Return Boolean
        Pattern pattern = Pattern.compile("^E\\d{3}$");
        Matcher matcher = pattern.matcher(username);
        if (matcher.find() == true)
            System.out.println("Username is valid");
        else
            System.out.println("Username is invalid");

    }

    public void CheckPassword(String password) {
        // Password is unlimited characters and numbers
        // Return Boolean
        Pattern pattern = Pattern.compile("^[\\D]");
        Matcher matcher = pattern.matcher(password);
        if (matcher.find() == true)
            System.out.println("Password is valid");
        else
            System.out.println("Password is invalid");
    }
}
