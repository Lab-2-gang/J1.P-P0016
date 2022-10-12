package Tool;


public class CheckNullOrBlank
{
    public static Boolean Check(String inputToCheck)
    {
        return inputToCheck == null || inputToCheck.isBlank() == true;
    }
}
