package Presentation.Menu;

import java.util.ArrayList;


public class PrintMenu
{
    public static void Print (ArrayList<String> menuList)
    {
        // Print all String in menuList
        for (String string : menuList)
        {
            System.out.println(string);
        }
    }
}
