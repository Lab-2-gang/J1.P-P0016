package Tool;

import java.util.Scanner;

import Presentation.Tools.Color;
import Presentation.Tools.Message;

public class GetTwoChoice
{
    public static boolean getTwoChoice(String message, String option1, String option2)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("-----------------");

        int choice;

        while (true)
        {
            try
            {
                System.out.println(message);
                System.out.println("    1. " + option1);
                System.out.println("    2. " + option2);
                System.out.print("Etner your choice: ");

                choice = Integer.parseInt(scanner.nextLine().trim());

                if (choice != 1 && choice != 2)
                {
                    System.out.println("Invalid option");
                    continue;
                }
                    
                System.out.println("-----------------");

                if (choice == 1)
                {
                    return true;
                }
                else if (choice == 2)
                {
                    return false;
                }
            }
            catch (Exception e)
            {
                Message.showMessage("Please enter between 1 or 2. Please enter again.", Color.RED);
            }
        }
    }
}
