import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CreateOutputTest {

    private static final String correctInput = "10011011";
    private static final String correctInput2 = "11101000";
    private static final String incorrectInput = "10011010";
    private static final String incorrectInput2 = "10010001";


    @Test
    public void shouldPassWhenGivenCorrectInput() {
        // given
        String input = new StringBuilder(correctInput).toString();

        // when
        final List<String> result = Main.createOutput(input);

        // then
        assertThat(result).isNotEmpty();
        assertThat(result).hasSize(3);
        assertThat(result.get(0)).isEqualTo("1");
        assertThat(result.get(1)).isEqualTo("0");
        assertThat(result.get(2)).isEqualTo(input);
    }

    @Test
    public void shouldPassWhenGivenDuplicates() {
        // given
        StringBuilder builder = new StringBuilder();
        builder.append(correctInput);
        builder.append(correctInput2);
        builder.append(correctInput2);
        String input = builder.toString();

        // when
        final List<String> result = Main.createOutput(input);

        // then
        assertThat(result).isNotEmpty();
        assertThat(result).hasSize(3);
        assertThat(result.get(0)).isEqualTo("3");
        assertThat(result.get(1)).isEqualTo("0");
        assertThat(result.get(2)).isEqualTo(input);
    }

    @Test
    public void shouldPassWhenGivenIncorrectInput() {
        // given
        StringBuilder builder = new StringBuilder();
        builder.append(correctInput);
        builder.append(incorrectInput);
        builder.append(incorrectInput2);
        String input = builder.toString();

        // when
        final List<String> result = Main.createOutput(input);

        // then
        assertThat(result).isNotEmpty();
        assertThat(result).hasSize(3);
        assertThat(result.get(0)).isEqualTo("3");
        assertThat(result.get(1)).isEqualTo("2");
        assertThat(result.get(2)).isEqualTo(correctInput);
    }

    @Test
    public void shouldPassWhenGivenDuplicatesIncorrectInput() {
        // given
        StringBuilder builder = new StringBuilder();
        builder.append(correctInput);
        builder.append(incorrectInput);
        builder.append(incorrectInput);
        String input = builder.toString();

        // when
        final List<String> result = Main.createOutput(input);

        // then
        assertThat(result).isNotEmpty();
        assertThat(result).hasSize(3);
        assertThat(result.get(0)).isEqualTo("3");
        assertThat(result.get(1)).isEqualTo("2");
        assertThat(result.get(2)).isEqualTo(correctInput);
    }

    @Test
    public void shouldPassWhenGivenEmptyString() {
        // when
        final List<String> result = Main.createOutput("");

        // then
        assertThat(result).isEmpty();
        assertThat(result).hasSize(0);
    }

    @Test
    public void shouldPassWhenIncorectTypeOfInputGiven() {
        // given
        String input = "abcdefgh12345";

        // when
        final List<String> result = Main.createOutput(input);

        // then
        assertThat(result).isNotEmpty();
        assertThat(result).hasSize(3);
        assertThat(result.get(0)).isEqualTo("0");
        assertThat(result.get(1)).isEqualTo("0");
        assertThat(result.get(2)).isEqualTo("");
    }
}
