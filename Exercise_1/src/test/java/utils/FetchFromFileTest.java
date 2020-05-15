package utils;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

public class FetchFromFileTest {

    private static FetchFromFile fetchFromFile;

    @BeforeAll
    public static void setUp() {
        fetchFromFile = new FetchFromFile();
    }

    @Test
    public void shouldThrowExceptionWhenGivenIncorrectFileLocation() {
        // given
        String fileLocation = "thereIsNoFileLikeThat.txt";

        // when
        Throwable thrown = catchThrowable(() -> {
            fetchFromFile.getStringFromFile(fileLocation);
        });

        // then
        assertThat(thrown).isInstanceOf(FileNotFoundException.class);
    }

    @Test
    public void shouldReturnEmptyStringWhenGivenEmptyFileLocation() throws IOException {
        // given
        String fileLocation = "";

        // when
        final String result = fetchFromFile.getStringFromFile(fileLocation);

        // then
        assertThat(result).isEmpty();
        assertThat(result).hasSize(0);
    }
}
