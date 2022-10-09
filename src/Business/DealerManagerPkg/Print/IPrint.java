package Business.DealerManagerPkg.Print;

import java.util.ArrayList;
import Database.Dealer.Dealer;


public interface IPrint
{
    public void Print(ArrayList<Dealer> dealers);
}