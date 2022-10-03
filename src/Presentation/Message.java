package Presentation;

public class Message {
    public static void showMessage(String message, String color) {
        Color co = new Color();
        System.out.println(color + message + co.RESET);
    }
}
