package Business.DealerManagerPkg.Print;

import java.util.ArrayList;

import Persistance.Entity.Dealer.Dealer;


public interface IPrint
{
    public void Print(ArrayList<Dealer> dealers);
}