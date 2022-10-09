package Business.DealerManagerPkg.Print;

import Database.Dealer.Dealer;


public class PrintDealer
{
    // print single dealer
    public static void Print(Dealer dealer)
    {
        System.out.println("Dealer's ID: " + dealer.getDealerID());
        System.out.println("Dealer's name: " + dealer.getDealerName());
        System.out.println("Dealer's house number: " + dealer.getDealerHouseNumber());
        System.out.println("Dealer's street name: " + dealer.getDealerStreetName());
        System.out.println("Dealer's number: " + dealer.getDealerNumber());
        System.out.println("Dealer's status: " + (dealer.getIsContinuing() == true ? "Cotinuing" : "Uncontinuing"));
    }
}
