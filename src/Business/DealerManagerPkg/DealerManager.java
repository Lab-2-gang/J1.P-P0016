package Business.DealerManagerPkg;

import Business.DealerManagerPkg.Add.*;
import Business.DealerManagerPkg.Print.*;
import Business.DealerManagerPkg.Remove.*;
import Business.DealerManagerPkg.Search.*;
import Business.DealerManagerPkg.Update.*;
import Presentation.Menu.DealerMenu;
import Presentation.Menu.PrintMenu;
import Tool.ReadInput;


public class DealerManager implements IDealerManager
{
    // menu + get user input
    public void DealerManagerMenu()
    {
        DealerMenu dealerMenu = new DealerMenu();

        boolean isBeingUsed = true;

        while (isBeingUsed == true)
        {
            PrintMenu.Print(dealerMenu.getMenuList());

            System.out.print("Enter option: ");
            String userInput = ReadInput.ReadUserInput();

            if (userInput == null || userInput.isBlank() == true)
            {
                // invalid input
                continue;
            }

            System.out.println();

            switch (userInput)  // delegate
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
                // TO-DO to be implemented
            }
        }
    }
}
