package utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FetchFromFile {
    public String getStringFromFile(String fileLocation) {
        String inputString = "";
        try (BufferedReader fileReader = new BufferedReader(new FileReader(fileLocation))) {
            inputString = fileReader.readLine();
        } catch (FileNotFoundException e) {
            System.out.println("File \"" + fileLocation + "\" not found");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return inputString;
    }
}
