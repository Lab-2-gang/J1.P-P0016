package Presentation;

import Presentation.Menu.IPrint;
import Presentation.Menu.MainMenu;
import Presentation.Menu.WelcomeText;


public class Program
{
    public static void main(String[] args)
    {
        IPrint mainMenu = new MainMenu();
        IPrint welcomeText = new WelcomeText();
        
        welcomeText.Print();
        mainMenu.Print();
    }
}
