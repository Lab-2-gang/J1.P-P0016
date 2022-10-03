package Business;

import java.util.Scanner;

public class ReadInput {
    // scanner
    private final Scanner readInput = new Scanner(System.in);

    // read input as string
    public String ReadInput() {
        try {
            return readInput.nextLine().trim();
        } catch (Exception e) {
            // cannot read
            return null;
        }
    }

    // convert input to int
    public Integer convertToInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (Exception e) {
            // cannot convert
            return null;
        }
    }

    // convert input
    public Float ConvertToFloat(String input) {
        try {
            return Float.parseFloat(input);
        } catch (Exception e) {
            // cannot convert
            return null;
        }
    }
}