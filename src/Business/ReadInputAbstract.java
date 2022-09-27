package Business;

import java.util.Scanner;


public abstract class ReadInputAbstract<T> implements IReadInput<T>
{
    protected Scanner scanner = new Scanner(System.in);
    
    protected String Read()
    {
        try
        {
            return scanner.nextLine();
        }
        catch (Exception e)
        {
            return null;
        }
    }
    
    public abstract T GetInput(String inputAsString);
}
