package Business.DealerManagerPkg.Print;

import Persistance.Entity.Dealer.Dealer;


public class PrintDealer
{
    private final static String FORMAT = "|%-10s|%-10s|%-20s|%-15s|%-10s|";
    // print single dealer
    public static void Print(Dealer dealer)
    {
        System.out.println(String.format(
            FORMAT, 
            dealer.getDealerID(),
            dealer.getDealerName(),
            dealer.getDealerHouseNumber(),
            dealer.getDealerStreetName(),
            dealer.getDealerNumber(),
            dealer.getIsContinuing()));    
    }
}
