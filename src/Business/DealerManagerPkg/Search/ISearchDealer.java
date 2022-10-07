package Business.DealerManagerPkg.Search;

import java.util.LinkedList;
import Database.Dealer.Dealer;

public interface ISearchDealer
{
    public Dealer Search(LinkedList<Dealer> dealers);
}
