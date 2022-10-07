package Presentation.Tools;

import Presentation.Color;

public class Message {
    public static void showMessage(String message, String color) {
        System.out.println(color + message + Color.RESET);
    }
}
