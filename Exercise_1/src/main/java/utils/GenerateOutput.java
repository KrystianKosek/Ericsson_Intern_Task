package utils;

import com.google.common.base.Splitter;
import models.MyModel;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class GenerateOutput {

    /*
    Main algorithm from String create list of 3 strings,
    - number of all objects contained in input
    - number of wrong objects
    - all correct objects from the input
    Used Splitter from google guava library to split String to list of 8 characters Strings
    then iterate through list and validates all the objects using pattern, matcher.
     */
    public List<String> createOutput(String input) {
        if (input.isEmpty()) {
            return Collections.emptyList();
        }
        Iterable<String> subStrings = Splitter.fixedLength(8).split(input);
        Iterator<String> iter = subStrings.iterator();
        Pattern pattern = Pattern.compile("([0-1]{4})([0-1]{3})([0-1])");
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
            }
            objects++;
        }
        String output = listOfCorrectModels.stream()
                .map(Objects::toString)
                .collect(Collectors.joining());

        List<String> outputList = Arrays.asList(String.valueOf(objects), String.valueOf(invalidObjects), output);
        return outputList;
    }
}
