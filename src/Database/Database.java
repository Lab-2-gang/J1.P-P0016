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
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import Database.Account.Account;
import Database.Account.AccountType;
import Database.Dealer.Dealer;
import Database.Delivery.Delivery;
import Tool.ReadFile;

public class Database {
    private ArrayList<Account> accounts;
    private ArrayList<Dealer> dealers;
    private ArrayList<Delivery> deliveries;

    public Database(){

    }
    public Database(ArrayList<Account> accounts, ArrayList<Dealer> dealers, ArrayList<Delivery> deliveries) {
        this.accounts = accounts;
        this.dealers = dealers;
        this.deliveries = deliveries;
    }
    public ArrayList<Account> getAccounts() {
        return accounts;
    }
    public ArrayList<Dealer> getDealers() {
        return dealers;
    }
    public ArrayList<Delivery> getDeliveries() {
        return deliveries;
    }
    public ArrayList<Account> ReadFileAccount(String filename){
        ReadFile readFile = new ReadFile();
        ArrayList<String> fileContent = readFile.Read(filename);
        ArrayList<Account> accounts = new ArrayList<>();
        for (String line : fileContent) {
            StringTokenizer stringTokenizer = new StringTokenizer(line, ",");
            String username = stringTokenizer.nextToken();
            String password = stringTokenizer.nextToken();
            String accountType = stringTokenizer.nextToken();
            Account account = new Account(username, password, AccountType.valueOf(accountType));
            accounts.add(account);
        }
        return accounts;
    }

        
    public ArrayList<Dealer> ReadFileDealers (String filename){
        ArrayList<Dealer> dealers = new ArrayList<Dealer>();
        File file = new File(filename);
        try (Scanner sc = new Scanner(file)){
            while(sc.hasNextLine()){
                String line = sc.nextLine();
                StringTokenizer stk = new StringTokenizer(line, ",");
                String dealerID = stk.nextToken();
                String dealerName = stk.nextToken();
                String dealerHouseNumber = stk.nextToken();
                String dealerStreetName = stk.nextToken();
                String dealerNumber = stk.nextToken();
                Boolean isContinuing = Boolean.parseBoolean(stk.nextToken());
                Dealer dealer = new Dealer(dealerID, dealerName, dealerHouseNumber, dealerStreetName, dealerNumber, isContinuing);
                dealers.add(dealer);
            }
            return dealers;
        } catch (Exception e){
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }
    public ArrayList<Delivery> ReadFileDeliveries (String filename){
        ArrayList<Delivery> deliveries = new ArrayList<Delivery>();
        File file = new File(filename);
        try (Scanner sc = new Scanner(file)){
            while(sc.hasNextLine()){
                String line = sc.nextLine();
                StringTokenizer stk = new StringTokenizer(line, ",");
                String deliveryID = stk.nextToken();
                String deliveryName = stk.nextToken();
                String deliveryHouseNumber = stk.nextToken();
                String deliveryStreetName = stk.nextToken();
                String deliveryNumber = stk.nextToken();
                Delivery delivery = new Delivery(deliveryID, deliveryName, deliveryHouseNumber, deliveryStreetName, deliveryNumber);
                deliveries.add(delivery);
            }
            return deliveries;
        } catch (Exception e){
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }
    public void saveAccount(String filename) {
        if (this.size() == 0) {
            System.out.println("No account to save");
            return;
        }
        try {
            File f = new File(filename);// create a file object
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
  
    
    private Account get(int i) {
        return null;
    }
    private int size() {
        return 0;
    }
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
                    System.out.println("Invalid input");
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

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

    private void add(Account account) {

    }

    // get, set
    public ArrayList<Account> getAccounts()
    {
        return accounts;
    }
    
    public ArrayList<Dealer> getDealers()
    {
        return dealers;
    }

    public ArrayList<Delivery> getDeliveries()
    {
        return deliveries;
    }
}

