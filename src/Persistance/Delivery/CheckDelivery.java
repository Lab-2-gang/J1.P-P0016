package Persistance.Delivery;
import Tool.PatternCheck;
public class CheckDelivery {
    //check delivery id format
    public static boolean checkDeliveryID(String deliveryID) {
        String regex = "^D\\d{3}$";
        PatternCheck.Check(regex, deliveryID);
        return deliveryID.matches(regex);
    } 
    //check delivery name format
    public static boolean checkDeliveryName(String deliveryName) {
        String regex = "^[\\D]";
        PatternCheck.Check(regex, deliveryName);
        return deliveryName.matches(regex);
    }
    //check delivery phone format
    public static boolean checkDeliveryHouseNumber(String deliveryHouseNumber) {
        String regex = "[^\\D]";
        PatternCheck.Check(regex, deliveryHouseNumber);
        return deliveryHouseNumber.matches(regex);
    }
    //check delivery address format
    public static boolean checkDeliveryAddress(String deliveryAddress) {
        String regex = "^[\\D]";
        PatternCheck.Check(regex, deliveryAddress);
        return deliveryAddress.matches(regex);
    }

}
