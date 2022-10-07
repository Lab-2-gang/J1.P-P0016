package Business.DealerManagerPkg;

import Business.DealerManagerPkg.Add.*;
import Business.DealerManagerPkg.Print.*;
import Business.DealerManagerPkg.Remove.*;
import Business.DealerManagerPkg.Search.*;
import Business.DealerManagerPkg.Update.*;
import Database.Dealer.Dealer;
import java.util.ArrayList;
import Tool.ReadInput;


public class DealerManager implements IDealerManager
{
    // dealers database
    private ArrayList<Dealer> dealers;


    // constructor to add database from Business
    public DealerManager(ArrayList<Dealer> dealers)
    {
        if (dealers == null)
        {
            // empty database
            this.dealers = null;
        }

        this.dealers = dealers;
    }


    // menu + get user input
    public void DealerManagerMenu()
    {
        boolean isBeingUsed = true;

        while (isBeingUsed == true)
        {
            System.out.print("Enter option: ");
            String userInput = ReadInput.ReadUserInput();

            if (userInput == null || userInput.isBlank() == true)
            {
                // invalid input
                continue;
            }

            switch (userInput)
            {
                case "1" ->
                {
                    DealerManagerDelegate(DealerOperation.Add);
                }

                case "2" ->
                {
                    DealerManagerDelegate(DealerOperation.Search);
                }

                case "3" ->
                {
                    DealerManagerDelegate(DealerOperation.Remove);
                }

                case "4" ->
                {
                    DealerManagerDelegate(DealerOperation.Update);
                }

                case "5" ->
                {
                    DealerManagerDelegate(DealerOperation.PrintAll);
                }

                case "6" ->
                {
                    DealerManagerDelegate(DealerOperation.PrintContinuing);
                }

                case "7" ->
                {
                    DealerManagerDelegate(DealerOperation.PrintUncontinuing);
                }

                case "8" ->
                {
                    DealerManagerDelegate(DealerOperation.WriteToFile);
                }

                default ->
                {
                    isBeingUsed = false;
                }
            }
        }
    }


    // delegate user choice
    private void DealerManagerDelegate(DealerOperation task)
    {
        switch (task)
        {
            case Add ->
            {
                IAddDealer addDealer = new AddDealer();
                addDealer.Add(dealers);
            }

            case Search ->
            {
                ISearchDealer searchDealer = new SearchDealer();
                searchDealer.Search(dealers);
            }

            case Remove ->
            {
                IRemoveDealer removeDealer = new RemoveDealer();
                removeDealer.Remove(dealers);
            }

            case Update ->
            {
                IUpdateDealer updateDealer = new UpdateDealer();
                updateDealer.Update(dealers);
            }

            case PrintAll ->
            {
                IPrint printAll = new PrintAllDealers();
                printAll.Print(dealers);
            }

            case PrintContinuing ->
            {
                IPrint printContinuing = new PrintAllContinuingDealers();
                printContinuing.Print(dealers);
            }

            case PrintUncontinuing ->
            {
                IPrint printUncontinuing = new PrintAllUncontinuingDealers();
                printUncontinuing.Print(dealers);
            }

            case WriteToFile ->
            {
                // TO-DO to be implemented
            }
        }
    }
}
