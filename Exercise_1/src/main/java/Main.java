import com.google.common.base.Splitter;
import models.MyModel;
import utils.FetchFromFile;
import utils.SaveToFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


public class Main {
    private static final String inputFileLocation = "input.txt";
    private static final String outputFileLocation = "output.txt";

    public static void main(String[] args) {
        FetchFromFile fetchFromFile = new FetchFromFile();
        SaveToFile saveToFile = new SaveToFile();
        try {
            String inputString = fetchFromFile.getStringFromFile(inputFileLocation);
            if (!inputString.isEmpty()) {
                List<String> result = createOutput(inputString);
                saveToFile.saveStringToFile(result, outputFileLocation);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    /*
        Funkcja createOutput, na podstawie Stringa przekazanego jako parametr tworzy liste 3 stringów:
        - liczba wszystkich wczytanych obiektów
        - liczba obiektów zawierających błędy
        - wszystkie obiekty, które nie zawierały błędów
        Algorytm wygląda następująco:
        - Za pomocą Splittera z biblioteki "google guava" parametr dzielony jest na liste stringów o długości 8 znaków
        - W pętli dla każdego obiektu z pomocą wyrażenia regularnego szukam: id, wiadomości oraz bitu kontrolnego,
            jeśli obiekt nie zawiera błędów, zostaje dodany do listy nowy obiekt 'MyModel' o powyższych parametrach
        - Za pomocą stream'a tworzony jest string "output" zawierający połączone obiekty niezawierające błędów
     */
    public static List<String> createOutput(String input) {
        if (input.isEmpty()) {
            return Collections.emptyList();
        }
        Iterable<String> subStrings = Splitter.fixedLength(8).split(input);
        Iterator<String> iter = subStrings.iterator();
        Pattern pattern = Pattern.compile("(\\d{4})(\\d{3})(\\d)");
        Matcher matcher;
        int objects = 0;
        int invalidObjects = 0;
        List<MyModel> listOfCorrectModels = new LinkedList<>();
        while (iter.hasNext()) {
            String subString = iter.next().toString();
            matcher = pattern.matcher(subString);
            if (matcher.find()) {
                String id = matcher.group(1);
                String message = matcher.group(2);
                String controlBit = matcher.group(3);
                if (id.charAt(3) == controlBit.charAt(0) && !message.equals("000")) {
                    listOfCorrectModels.add(new MyModel(id, message, controlBit));
                } else {
                    invalidObjects++;
                }
                objects++;
            }
        }
        String output = listOfCorrectModels.stream()
                .map(Objects::toString)
                .collect(Collectors.joining());

        List<String> outputList = Arrays.asList(String.valueOf(objects), String.valueOf(invalidObjects), output);
        return outputList;
    }

}
