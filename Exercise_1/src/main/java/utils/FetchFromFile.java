package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FetchFromFile {
    public String getStringFromFile(String fileLocation) throws IOException {
        if (fileLocation.isEmpty()) {
            return "";
        }
        String inputString = "";
        BufferedReader fileReader = new BufferedReader(new FileReader(fileLocation));
        inputString = fileReader.readLine();

        return inputString;
    }
}
