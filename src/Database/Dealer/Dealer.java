package Database.Dealer;


public class Dealer
{
    private String dealerID;
    private String dealerName;
    private String dealerHouseNumber;
    private String dealerStreetName;
    private String dealerNumber;
    private Boolean isContinuing;


    public Dealer(String dealerID2, String dealerName2, String dealerHouseNumber2, String dealerStreetName2,
            String dealerNumber2, Boolean isContinuing2) {
    }

    public String getDealerID() {
        return dealerID;
    }

    public String getDealerName() {
        return dealerName;
    }

    public String getDealerHouseNumber() {
        return dealerHouseNumber;
    }

    public String getDealerStreetName() {
        return dealerStreetName;
    }

    public String getDealerNumber() {
        return dealerNumber;
    }

    public Boolean getIsContinuing() {
        return isContinuing;
    }
}
