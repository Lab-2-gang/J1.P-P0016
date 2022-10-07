package Presentation;

import java.util.ArrayList;

public class PrintMenu {
    public void Print (ArrayList<String> menuList) {
        // Print all String in menuList
        for (String string : menuList) {
            System.out.println(string);
        }
    }
}
