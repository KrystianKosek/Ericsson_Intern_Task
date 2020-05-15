package utils;

import lombok.extern.slf4j.Slf4j;

import java.util.InputMismatchException;
import java.util.Scanner;

@Slf4j
public class UserInterface {
    private final Scanner scanner;
    private final Calculations calculations;
    private final FetchFromFile fetchFromFile;

    public UserInterface() {
        scanner = new Scanner(System.in);
        calculations = new Calculations();
        fetchFromFile = new FetchFromFile();
    }

    private void printMainInterface() {
        System.out.println("------------------------------------------");
        System.out.println("1.Convert binary to decimal");
        System.out.println("2.Convert decimal to binary");
        System.out.println("0.Close");
        System.out.println("------------------------------------------");
    }

    private void printSecondInterface() {
        System.out.println("------------------------------------------");
        System.out.println("1.Read from console");
        System.out.println("2.Read from file");
        System.out.println("------------------------------------------");
    }

    private String getInputNumberFromConsole() {
        System.out.println("------------------------------------------");
        System.out.println("Input number: ");
        String input = scanner.nextLine();
        return input;
    }

    private String getFilePath() {
        System.out.println("------------------------------------------");
        System.out.println("Input file path: ");
        String input = scanner.nextLine();
        return input;
    }

    private void handleInput(int function){
        scanner.nextLine();
        printSecondInterface();
        int userInputChoice = scanner.nextInt();
        scanner.nextLine();
        String inputNumber = "";
        switch (userInputChoice) {
            case 1:
                inputNumber = getInputNumberFromConsole();
                break;
            case 2:
                String filePath = getFilePath();
                inputNumber = fetchFromFile.getStringFromFile(filePath);
                break;
            default:
                log.error("Wrong choice!");
                return;
        }
        if (inputNumber.isEmpty()) {
            return;
        }
        String output = "";
        switch (function) {
            case 1:
                output = calculations.calculateBinaryToDecimal(inputNumber);
                break;
            case 2:
                output = calculations.calculateDecimalToBinary(inputNumber);
                break;
        }
        System.out.println(output);
    }

    public void userService() {
        int userFunctionChoice = -1;
        do {
            printMainInterface();
            try {
                userFunctionChoice = scanner.nextInt();
                if (userFunctionChoice == 1 || userFunctionChoice == 2){
                    handleInput(userFunctionChoice);
                }
                else if(userFunctionChoice == 0){
                    System.out.println("Bye Bye! :)");
                }
                else {
                    log.error("Wrong Choice!");
                }
            } catch (InputMismatchException e) {
                log.error("Wrong input!");
                scanner.nextLine();
            }
        } while (userFunctionChoice != 0);
    }
}
