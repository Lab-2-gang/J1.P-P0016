package Database.Dealer;
import Tool.PatternCheck;
public class CheckDealer {
 //check dealer id format
    public static boolean checkDealerID(String dealerID) {
        String regex = "^D\\d{3}$";
        PatternCheck.Check(regex, dealerID);
        return dealerID.matches(regex);
    }
}