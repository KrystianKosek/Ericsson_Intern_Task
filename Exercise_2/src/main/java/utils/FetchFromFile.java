package utils;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

@Slf4j
public class FetchFromFile {
    public String getStringFromFile(String fileLocation) {
        String inputString = "";
        try (BufferedReader fileReader = new BufferedReader(new FileReader(fileLocation))) {
            inputString = fileReader.readLine();
        } catch (FileNotFoundException e) {
            log.error(String.format("File \"%s\" not found", fileLocation));
        } catch (IOException e) {
            log.error(e.getMessage());
        }

        return inputString;
    }
}
