package Tool;

import java.util.Scanner;


public class ReadInput
{
    // read input as string
    public static String Read()
    {
        @SuppressWarnings("resource")
        Scanner readInput = new Scanner(System.in);

        try
        {
            if (readInput.hasNext() == true)
            {
                return readInput.nextLine().trim();
            }

            return null;
        }
        catch (Exception e)
        {
            // cannot read
            return null;
        }
    }


    // convert input to int
    public static Integer ConvertToInteger(String input)
    {
        try
        {
            return Integer.parseInt(input);
        }
        catch (Exception e)
        {
            // cannot convert
            return null;
        }
    }


    // convert input
    public static Float ConvertToFloat(String input)
    {
        try
        {
            return Float.parseFloat(input);
        }
        catch (Exception e)
        {
            // cannot convert
            return null;
        }
    }
}
