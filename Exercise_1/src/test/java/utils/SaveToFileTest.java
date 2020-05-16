package utils;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

public class SaveToFileTest {

    private static SaveToFile saveToFile;

    @BeforeAll
    public static void setUp() {
        saveToFile = new SaveToFile();
    }

    @Test
    public void shouldPassWhenGivenEmptyListOfStrings() {
        // given
        String fileLocation = "test.txt";

        // when
        Throwable thrown = catchThrowable(() -> {
            saveToFile.saveStringToFile(Collections.EMPTY_LIST, fileLocation);
        });

        // then
        assertThat(thrown).doesNotThrowAnyException();
    }

    @Test
    public void shouldPassWhenGivenEmptyFileLocation() {
        // given
        List<String> inputStrings = Arrays.asList("Test");

        // when
        Throwable thrown = catchThrowable(() -> {
            saveToFile.saveStringToFile(inputStrings, "");
        });

        // then
        assertThat(thrown).doesNotThrowAnyException();
    }

    @Test
    public void shouldPassWhenNullGiven(){
        // given
        String fileLocation = "test2.txt";

        // when
        Throwable thrown = catchThrowable(() -> {
            saveToFile.saveStringToFile(null,  fileLocation);
        });

        // then
        assertThat(thrown).doesNotThrowAnyException();
    }
}
