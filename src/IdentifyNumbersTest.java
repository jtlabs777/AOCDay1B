import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;


class  IdentifyNumbersTest {

  private static Stream<Arguments> provideNumbersForExtraction() {
    return Stream.of(
            Arguments.of("twonine", 29),
            Arguments.of("eighttwothree", 83),
            Arguments.of("xtwone3four", 24),
            Arguments.of("4nineeightseven2", 42),
            Arguments.of("zoneight234", 14),
            Arguments.of("7pqrstsixteen", 76),
            Arguments.of("abds7adb", 77)
            // Add more arguments as needed
    );
  }

@ParameterizedTest
@MethodSource("provideNumbersForExtraction")
  public void testExtractAll_ShouldReturnFirstandLastNumbers(String input, int expectedOutput) {
    IdentifyNumbers identifyNumbers = new IdentifyNumbers();
    String string = "";
    int results;

      string = identifyNumbers.extractAll(input);
      results = Integer.valueOf(string);

    Assertions.assertEquals(expectedOutput, results);


  }


}