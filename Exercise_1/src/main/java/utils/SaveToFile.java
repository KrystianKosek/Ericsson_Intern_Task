package utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class SaveToFile {
    public void saveStringToFile(List<String> listOfStrings, String fileLocation) throws IOException {
        if (Objects.isNull(listOfStrings) || fileLocation.isEmpty()) {
            return;
        }
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fileLocation));
        for (String string : listOfStrings) {
            fileWriter.write(string);
            fileWriter.newLine();
        }
        fileWriter.close();
    }
}
