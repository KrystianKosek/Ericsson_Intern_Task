package utils;

public class Calculations {
    public String calculateDecimalToBinary(String input) {
        String output = "";
        try {
            output = Integer.toBinaryString(Integer.parseInt(input));
        } catch (NumberFormatException e) {
            output = "Input: \"" + input + "\" is not a number!";
        }
        return output;
    }

    public String calculateBinaryToDecimal(String input) {
        String output = "";
        try {
            output = String.valueOf(Integer.parseInt(input, 2));
        } catch (NumberFormatException e) {
            output = "Input: \"" + input + "\" is not a number in radix 2!";
        }
        return output;
    }
}