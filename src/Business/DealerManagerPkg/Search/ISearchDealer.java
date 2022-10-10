package Business.DealerManagerPkg.Search;

import java.util.ArrayList;

import Persistance.Dealer.Dealer;


public interface ISearchDealer
{
    public Dealer Search(ArrayList<Dealer> dealers);
}
