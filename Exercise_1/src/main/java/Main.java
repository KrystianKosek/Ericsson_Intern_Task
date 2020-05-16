import lombok.extern.slf4j.Slf4j;
import utils.FetchFromFile;
import utils.GenerateOutput;
import utils.SaveToFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@Slf4j
public class Main {
    private static final String inputFileLocation = "input.txt";
    private static final String outputFileLocation = "output.txt";

    public static void main(String[] args) {
        FetchFromFile fetchFromFile = new FetchFromFile();
        SaveToFile saveToFile = new SaveToFile();
        GenerateOutput generateOutput = new GenerateOutput();
        try {
            String inputString = fetchFromFile.getStringFromFile(inputFileLocation);
            if (!inputString.isEmpty()) {
                List<String> result = generateOutput.createOutput(inputString);
                saveToFile.saveListOfStringsToFile(result, outputFileLocation);
            }
        } catch (FileNotFoundException e) {
            log.error("File not found");
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }

}
