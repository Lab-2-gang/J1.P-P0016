package Database;

//import enum//
import java.util.Vector;
import java.util.Enumeration;
import java.util.ArrayList; // import the ArrayList class
import java.util.Scanner;

public class Database {
    ArrayList<String> accounts = new ArrayList<String>();
    ArrayList<String> dealers = new ArrayList<String>();
    ArrayList<String> delieveries = new ArrayList<String>();

    public void ReadFileAccount(String filePath) {
        try {
            File myObj = new File(filePath);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                accounts.add(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

    public class CheckAccount extends Accounts {
        public boolean CheckAccount(String username, String password) {
            for (int i = 0; i < accounts.size(); i++) {
                String[] account = accounts.get(i).split(",");
                if (account[0].equals(username) && account[1].equals(password)) {
                    return true;
                }
            }
            return false;
        }
    }

    
    public void ReadFileDealers(String filePath) {
        try {
            File myObj = new File(filePath);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                dealers.add(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

    public class CheckDealers extends Dealers{
        public boolean CheckDealers(String username, String password){
            for (int i = 0; i < dealers.size(); i++) {
                String[] dealer = dealers.get(i).split(",");
                if (dealer[0].equals(username) && dealer[1].equals(password)) {
                    return true;
                }
            }
            return false;
        }
    }

    public void ReadFileDeliveries(String filePath) {
        try {
            File myObj = new File(filePath);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                delieveries.add(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    public class Delieveries extends Delieveries{
        public boolean CheckDelieveries(String username, String password){
            for (int i = 0; i < delieveries.size(); i++) {
                String[] delieveries = delieveries.get(i).split(",");
                if (delieveries[0].equals(username) && delieveries[1].equals(password)) {
                    return true;
                }
            }
            return false;
        }
    }
    //define enum//
    public class Enumeration {

        public static void main(String args[]) {
           Enumeration acc ;
           Vector AccountsType = new Vector();
           Vector Boss = new Vector();
           Vector Dealers = new Vector();
           Vector Delieveries = new Vector();
            AccountsType.add("AccountsType");
            Boss.add("Boss");
            Dealers.add("Dealers");
            Delieveries.add("Delieveries");
            acc = Accounts.elements();
            while (acc.hasMoreElements()) {
                System.out.println(acc.nextElement()); 
                }
     }
}
    public class Accounts {
        private String username;
        private String password;
        private AccountType accountType;
        //constructors//
        //null//
        public Accounts() {
            this.username = "";
            this.password = "";
            this.accountType = AccountType.CUSTOMER;
        }
        public Accounts(String username, String password, AccountType accountType) {
            this.username = username;
            this.password = password;
            this.accountType = accountType;
        }
        //getters//
        public String getUsername() {
            return username;
        }
        public String getPassword() {
            return password;
        }
        public AccountType getAccountType() {
            return accountType;
        }
        //setters//
        public void setUsername(String username) {
            this.username = username;
        }
        public void setPassword(String password) {
            this.password = password;
        }
        public void setAccountType(AccountType accountType) {
            this.accountType = accountType;
        }

    }
    public class Dealers {
        private String id;
        private String dealerName;
        private String address;
        private String phoneNumber;
        private boolean isContinuing;
        //constructors//
        //null values//
        public Dealers() {
            this.id = null;
            this.dealerName = null;
            this.address = null;
            this.phoneNumber = null;
            this.isContinuing = false;
        }
        public Dealers(String id, String dealerName, String address, String phoneNumber, boolean isContinuing) {
            this.id = id;
            this.dealerName = dealerName;
            this.address = address;
            this.phoneNumber = phoneNumber;
            this.isContinuing = isContinuing;
        }
        //getters//
        public String getId() {
            return id;
        }
        public String getDealerName() {
            return dealerName;
        }
        public String getAddress() {
            return address;
        }
        public String getPhoneNumber() {
            return phoneNumber;
        }
        public boolean getIsContinuing() {
            return isContinuing;
        }
        //setters//
        public void setId(String id) {
            this.id = id;
        }
        public void setDealerName(String dealerName) {
            this.dealerName = dealerName;
        }
        public void setAddress(String address) {
            this.address = address;
        }
        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }
        public void setIsContinuing(boolean isContinuing) {
            this.isContinuing = isContinuing;
        }

    }
}
