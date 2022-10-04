package pl.kacperk.xmlunmarshallerexample.data;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TopValuesPrinterTest {
    private TopValuesPrinter topValuesPrinter;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private List<Map.Entry<String, Long>> topList;
    private int limit;
    private String name;

    @BeforeEach
    public void beforeEach() {
        topValuesPrinter = new TopValuesPrinter();
        System.setOut(new PrintStream(outContent));
        topList = new ArrayList<>();
    }

    @Test
    public void printTopValues_normalArguments_success() {
        //given
        topList.add(Map.entry("Cat", 3L));
        topList.add(Map.entry("Dog", 2L));
        topList.add(Map.entry("Bee", 1L));
        limit = 2;
        name = "Animals";

        String expectedOut = "Top 2 Animals: Cat=3, Dog=2";

        //when
        topValuesPrinter.printTopValues(topList, limit, name);

        //then
        Assertions.assertEquals(expectedOut, outContent.toString().trim());
    }

    @ParameterizedTest
    @CsvSource({"-1", "0"})
    public void printTopValues_limitBelowOne_throwsIllegalArgumentException(int illegalLimit) {
        //given
        topList.add(Map.entry("Cat", 3L));
        topList.add(Map.entry("Dog", 2L));
        topList.add(Map.entry("Bee", 1L));
        name = "Animals";

        //when
        Throwable throwable = org.assertj.core.api.Assertions.catchThrowable(() ->
                topValuesPrinter.printTopValues(topList, illegalLimit, name));

        //then
        org.assertj.core.api.Assertions.assertThat(throwable)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Limit must be greater or equal 1");
    }

    @Test
    public void printTopValues_emptyName_throwsIllegalArgumentException() {
        //given
        topList.add(Map.entry("Cat", 3L));
        topList.add(Map.entry("Dog", 2L));
        topList.add(Map.entry("Bee", 1L));
        limit = 2;
        name = "";

        //when
        Throwable throwable = org.assertj.core.api.Assertions.catchThrowable(() ->
                topValuesPrinter.printTopValues(topList, limit, name));

        //then
        org.assertj.core.api.Assertions.assertThat(throwable)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Name cannot be empty");
    }

    @AfterEach
    public void afterEach() {
        System.setOut(originalOut);
    }
}
