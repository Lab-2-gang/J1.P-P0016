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
                addDealer.Operate();
            }

            case Search ->
            {
                IOperation searchDealer = OperationFactory(DealerFunctionType.Search);
                searchDealer.Operate();
            }

            case Remove ->
            {
                IOperation removeDealer = OperationFactory(DealerFunctionType.Remove);
                removeDealer.Operate();
            }

            case Update ->
            {
                IOperation updateDealer = OperationFactory(DealerFunctionType.Update);
                updateDealer.Operate();
            }

            case PrintAll ->
            {
                IOperation printAll = OperationFactory(DealerFunctionType.PrintAll);
                printAll.Operate();
            }

            case PrintContinuing ->
            {
                IOperation printContinuing = OperationFactory(DealerFunctionType.PrintContinuing);
                printContinuing.Operate();
            }

            case PrintUncontinuing ->
            {
                IOperation printUncontinuing = OperationFactory(DealerFunctionType.PrintUncontinuing);
                printUncontinuing.Operate();
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