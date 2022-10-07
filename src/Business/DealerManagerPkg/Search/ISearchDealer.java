package Business.DealerManagerPkg.Search;

import java.util.ArrayList;
import Database.Dealer.Dealer;


public interface ISearchDealer
{
    public Dealer Search(ArrayList<Dealer> dealers);
}
