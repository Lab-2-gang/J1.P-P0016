package Business;

public class BusinessDelegate {
    // implement operations from enum class DealerOperationsType
    // in a switch statement
    public void Delegate(DealerOperationsType task) {
        switch (task) {
            
            case Add:
                // add a new dealer
                break;

            case Search:
                // search for a dealer
                break;

            case Delete:
                // delete a dealer
                break;

            case Update:
                // update a dealer
                break;

            case PrintAll:
                // print all dealers
                break;

            case PrintContinuing:
                // print continuing dealers
                break;

            case PrintUncontinuing:
                // print uncontinuing dealers
                break;

            case WriteToFile:
                // write dealers to file
                break;

        }
    }

}
