package Business.DealerManagerPkg;

import Business.DealerManagerPkg.DealerOperation.*;
import Persistance.Database;


public class DealerManagerDelegate
{
    public void Delegate(DealerFunctionType type)
    {
        switch (type)
        {
            case Add ->
            {
                IOperation addDealer = OperationFactory(DealerFunctionType.Add);
                addDealer.Initiate();
            }

            case Search ->
            {
                IOperation searchDealer = OperationFactory(DealerFunctionType.Search);
                searchDealer.Initiate();
            }

            case Remove ->
            {
                IOperation removeDealer = OperationFactory(DealerFunctionType.Remove);
                removeDealer.Initiate();
            }

            case Update ->
            {
                IOperation updateDealer = OperationFactory(DealerFunctionType.Update);
                updateDealer.Initiate();
            }

            case PrintAll ->
            {
                IOperation printAll = OperationFactory(DealerFunctionType.PrintAll);
                printAll.Initiate();
            }

            case PrintContinuing ->
            {
                IOperation printContinuing = OperationFactory(DealerFunctionType.PrintContinuing);
                printContinuing.Initiate();
            }

            case PrintUncontinuing ->
            {
                IOperation printUncontinuing = OperationFactory(DealerFunctionType.PrintUncontinuing);
                printUncontinuing.Initiate();
            }

            case WriteToFile ->
            {
                Database.GetDatabase().SaveAccountFile();
            }
        }
    }
    
    
    // factory for dealer operation
    private IOperation OperationFactory(DealerFunctionType type)
    {
        switch (type)
        {
            case Add ->
            {
                return new AddDealer();
            }
            
            case Search ->
            {
                return new SearchDealer();
            }
            
            case Remove ->
            {
                return new RemoveDealer();
            }
            
            case Update ->
            {
                return new UpdateDealer();
            }
            
            case PrintAll ->
            {
                return new PrintAllDealers();
            }
            
            case PrintContinuing ->
            {
                return new PrintAllContinuingDealers();
            }
            
            case PrintUncontinuing ->
            {
                return new PrintAllUncontinuingDealers();
            }
        }
        
        // unknown type
        return null;
    }
}