package Database.Dealer;


public class Dealer
{
    // dealer info
    private String dealerID;
    private String dealerName;
    private String dealerHouseNumber;
    private String dealerStreetName;
    private String dealerNumber;
    private Boolean isContinuing;

public Dealer(String dealerID, String dealerName, String dealerHouseNumber, String dealerStreetName, String dealerNumber, Boolean isContinuing) {
    this.dealerID = dealerID;
    this.dealerName = dealerName;
    this.dealerHouseNumber = dealerHouseNumber;
    this.dealerStreetName = dealerStreetName;
    this.dealerNumber = dealerNumber;
    this.isContinuing = isContinuing;
    }

    // constructor
    public Dealer(String dealerID, String dealerName, String dealerHouseNumber, String dealerStreetName, String dealerNumber, Boolean isCotinuing)
    {
        this.dealerID = dealerID;
        this.dealerName = dealerName;
        this.dealerHouseNumber = dealerHouseNumber;
        this.dealerStreetName = dealerStreetName;
        this.dealerNumber = dealerNumber;
        this.isContinuing = isCotinuing;
    }


    // get, set
    public String getDealerID()
    {
        return dealerID;
    }

    public String getDealerName()
    {
        return dealerName;
    }

    public String getDealerHouseNumber()
    {
        return dealerHouseNumber;
    }

    public String getDealerStreetName()
    {
        return dealerStreetName;
    }

    public String getDealerNumber()
    {
        return dealerNumber;
    }

    public Boolean getIsContinuing()
    {
        return isContinuing;
    }
}
