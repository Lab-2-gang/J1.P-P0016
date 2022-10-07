package Business.DealerManagerPkg.Print;

import java.util.LinkedList;
import Database.Dealer.Dealer;

public interface IPrint
{
    public void Print(LinkedList<Dealer> dealers);
}