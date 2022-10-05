package Database.Account;

import Presentation.Program;
import java.io.*;
import java.util.*;


public class Account
{
    private String username;
    private String password;
    private AccountType accountType;


    public Account(String username2, String password2, AccountType accountType2) {
    }

    public Account(String username2, String name, String address, String number, Boolean isContinuing) {
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
    //validate the username and password inputted on Presentation.Program//
    public class Validation extends Program {
        public boolean validate(String username, String password) {
            boolean status = false;
            try {
                //read the file and check if the username and password are correct//
                BufferedReader br = new BufferedReader(new FileReader("src\\Database\\Account\\Account.txt"));
                String line = br.readLine();
                while (line != null) {
                    StringTokenizer st = new StringTokenizer(line, ",");
                    String user = st.nextToken();
                    String pass = st.nextToken();
                    if (username.equals(user) && password.equals(pass)) {
                        status = true;
                        break;
                    }
                    line = br.readLine();
                    br.close();
                }
            } catch (Exception e) {
                System.out.println(e);
            }
            return status;
        }

    }


}

