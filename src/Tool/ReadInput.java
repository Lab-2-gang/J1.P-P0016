package Tool;

import java.util.Scanner;

public class ReadInput {
    // scanner
    private static final Scanner readInput = new Scanner(System.in);

    // read input as string
    public static String ReadUserInput()
    {
        try
        {
            return readInput.nextLine().trim();
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
