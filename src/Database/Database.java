package Database;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import Database.Account.Account;
import Database.Account.AccountType;
import Database.Dealer.Dealer;
import Database.Delivery.Delivery;

public class Database {
    private Account accounts;
    private ArrayList<Delivery> deliveries = new ArrayList<Delivery>();
    private ArrayList<Dealer> dealers = new ArrayList<Dealer>();

    public Account getAccounts() {
        return accounts;
    }

    public ArrayList<Delivery> getDeliveries() {
        return deliveries;
    }

    public ArrayList<Dealer> getDealers() {
        return dealers;
    }

    public ArrayList<Account> ReadFileAccount(String fName) {
        try {
            ArrayList<Account> accounts = new ArrayList<Account>();
            File file = new File(fName);
            try (Scanner sc = new Scanner(file)) {
                while (sc.hasNextLine()) {
                    String line = sc.nextLine();
                    StringTokenizer st = new StringTokenizer(line, ",");
                    String username = st.nextToken();
                    String password = st.nextToken();
                    String accountType = st.nextToken();
                    Account account = new Account(username, password, AccountType.valueOf(accountType));
                    accounts.add(account);
                    return accounts;
                }
            }
            return accounts;
        } catch (Exception e) {
            System.out.println("Error");
            return null;
        }
    }

    public ArrayList<Dealer> ReadFileDealer(String fName) {
        try {
            ArrayList<Dealer> dealers = new ArrayList<Dealer>();
            File file = new File(fName);
            try (Scanner sc = new Scanner(file)) {
                while (sc.hasNextLine()) {
                    String line = sc.nextLine();
                    StringTokenizer st = new StringTokenizer(line, ",");
                    String dealerID = st.nextToken();
                    String dealerName = st.nextToken();
                    String dealerHouseNumber = st.nextToken();
                    String dealerStreetName = st.nextToken();
                    String dealerNumber = st.nextToken();
                    Boolean isContinuing = Boolean.parseBoolean(st.nextToken());
                    Dealer dealer = new Dealer(dealerID, dealerName, dealerHouseNumber, dealerStreetName, dealerNumber,
                            isContinuing);
                    dealers.add(dealer);
                    return dealers;
                }
            }
            return dealers;
        } catch (Exception e) {
            System.out.println("Error");
            return null;
        }
    }

    public ArrayList<Delivery> ReadFileDelivery(String fName) {
        try {
            ArrayList<Delivery> deliveries = new ArrayList<Delivery>();
            File file = new File(fName);
            try (Scanner sc = new Scanner(file)) {
                while (sc.hasNextLine()) {
                    String line = sc.nextLine();
                    StringTokenizer st = new StringTokenizer(line, ",");
                    String deliveryID = st.nextToken();
                    String deliveryName = st.nextToken();
                    String deliveryHouseNumber = st.nextToken();
                    String deliveryStreetName = st.nextToken();
                    String deliveryNumber = st.nextToken();
                    Delivery delivery = new Delivery(deliveryID, deliveryName, deliveryHouseNumber, deliveryStreetName,
                            deliveryNumber);
                    deliveries.add(delivery);
                    return deliveries;
                }
            }
            return deliveries;
        } catch (Exception e) {
            System.out.println("Error");
            return null;
        }
    }

    // validate account
    public boolean validateAccount(Account acc) {
        return accounts.equals(acc);
    }

    // validate dealer
    public boolean validateDealer(Dealer dealer) {
        return dealers.contains(dealer);
    }

    // validate delivery
    public boolean validateDelivery(Delivery delivery) {
        return deliveries.contains(delivery);
    }

    // save signed in accounts into an ArrayList
    public void saveAccount(Account acc) {
        accounts = acc;
    }

    // save signed in dealers into an ArrayList
    public void saveDealer(Dealer dealer) {
        dealers.add(dealer);
    }

    // save signed in deliveries into an ArrayList
    public void saveDelivery(Delivery delivery) {
        deliveries.add(delivery);
    }

    // remove signed out dealers from an ArrayList
    public void removeDealer(Dealer dealer) {
        dealers.remove(dealer);
    }

    // remove signed out deliveries from an ArrayList
    public void removeDelivery(Delivery delivery) {
        deliveries.remove(delivery);
    }

    // save account into an ArrayList
    public class AccountList extends Vector<Account> {
        Account[] list; // list of accounts
        int NumberOfAccounts; // number of accounts
        final int MAX = 10000; // maximum number of accounts

        public AccountList() {
            super();
        }

        // get the list size//
        public int getSize() {
            return size();
        }

        public void saveAccount(String fName) {
            if (this.size() == 0) {
                System.out.println("No account to save");
                return;
            }
            try {
                File f = new File(fName);// create a file object
                FileWriter fw = new FileWriter(f);// write file
                PrintWriter pw = new PrintWriter(fw);// print file
                for (int i = 0; i < this.size(); i++) {
                    pw.println(this.get(i).getUsername() + "," + this.get(i).getPassword() + ","
                            + this.get(i).getAccountType());
                }
                pw.close(); // close file
                fw.close();

            } catch (IOException e) {
                System.out.println("Error: " + e.getMessage()); // report error in saving
            }
        }
        // load account from an ArrayList

        public void LoadFileAccount(String fName) {
            // read file from text and add to the current list//
            try {
                FileReader fr = new FileReader(fName);
                BufferedReader br = new BufferedReader(fr);
                String line;
                while ((line = br.readLine().trim()) != null) {
                    StringTokenizer st = new StringTokenizer(line, ",");
                    String username = st.nextToken();
                    String password = st.nextToken();
                    String accountType = st.nextToken();
                    Pattern pattern = Pattern.compile("^E\\d{3}$");// start with E and 3 digits
                    Matcher match = pattern.matcher(username);

                    if (match.find() == false) {
                        System.out.println("Invalid username");
                        continue;
                    }

                    if (username.isBlank() || password.isBlank() || accountType.isBlank()) {
                        continue;
                    }
                    switch (accountType) {
                        case "Boss":
                            this.add(new Account(username, password, AccountType.Boss));
                            break;
                        case "Dealer":
                            this.add(new Account(username, password, AccountType.Dealer));
                            break;
                        case "Delivery":
                            this.add(new Account(username, password, AccountType.Delivery));
                            break;
                    }
                    // Account acc = new Account(username, password, AccountType.(accountType));
                    // this.add(acc);
                }

                br.close();
                fr.close();
            } catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
            }

        }

    }

}
