package Business.DealerManagerPkg;

import Business.DealerManagerPkg.Add.*;
import Business.DealerManagerPkg.Print.*;
import Business.DealerManagerPkg.Remove.*;
import Business.DealerManagerPkg.Search.*;
import Business.DealerManagerPkg.Update.*;
import Persistance.Database;


public class DealerManagerDelegate
{
    public void Delegate(DealerFunctionType type)
    {
        switch (type)
        {
            case Add ->
            {
                IAddDealer addDealer = new AddDealer();
                addDealer.Add();
            }

            case Search ->
            {
                ISearchDealer searchDealer = new SearchDealer();
                searchDealer.Search();
            }

            case Remove ->
            {
                IRemoveDealer removeDealer = new RemoveDealer();
                removeDealer.Remove();
            }

            case Update ->
            {
                IUpdateDealer updateDealer = new UpdateDealer();
                updateDealer.Update();
            }

            case PrintAll ->
            {
                IPrint printAll = new PrintAllDealers();
                printAll.Print();
            }

            case PrintContinuing ->
            {
                IPrint printContinuing = new PrintAllContinuingDealers();
                printContinuing.Print();
            }

            case PrintUncontinuing ->
            {
                IPrint printUncontinuing = new PrintAllUncontinuingDealers();
                printUncontinuing.Print();
            }

            case WriteToFile ->
            {
                Database.GetDatabase().SaveAccountFile();
            }
        }
    }
}