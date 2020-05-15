package utils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Calculations {
    public String calculateDecimalToBinary(String input) {
        String output = "";
        try {
            output = Integer.toBinaryString(Integer.parseInt(input));
        } catch (NumberFormatException e) {
            log.error(String.format("Input: \"%s\" is not a number!", input));
        }
        return output;
    }

    public String calculateBinaryToDecimal(String input) {
        String output = "";
        try {
            output = String.valueOf(Integer.parseInt(input, 2));
        } catch (NumberFormatException e) {
            log.error(String.format("Input: \"%s\" is not a number in radix 2!", input));
        }
        return output;
    }
}