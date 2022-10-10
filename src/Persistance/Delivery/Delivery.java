package Persistance.Delivery;


public class Delivery
{
    // delivery info
    private String deliveryID;
    private String deliveryName;
    private String deliveryHouseNumber;
    private String deliveryStreetName;
    private String deliveryNumber;

public Delivery(String deliveryID, String deliveryName, String deliveryHouseNumber, String deliveryStreetName, String deliveryNumber)
{
    this.deliveryID = deliveryID;
    this.deliveryName = deliveryName;
    this.deliveryHouseNumber = deliveryHouseNumber;
    this.deliveryStreetName = deliveryStreetName;
    this.deliveryNumber = deliveryNumber;
}
    

    // get, set
    public String getDeliveryID()
    {
        return deliveryID;
    }

    public String getDeliveryName()
    {
        return deliveryName;
    }

    public String getDeliveryHouseNumber()
    {
        return deliveryHouseNumber;
    }

    public String getDeliveryStreetName()
    {
        return deliveryStreetName;
    }

    public String getDeliveryNumber()
    {
        return deliveryNumber;
    }
}
