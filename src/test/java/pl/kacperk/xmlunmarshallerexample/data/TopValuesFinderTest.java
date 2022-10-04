package pl.kacperk.xmlunmarshallerexample.data;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TopValuesFinderTest {
    private TopValuesFinder topValuesFinder;
    private List<String> stringList;

    @BeforeEach
    public void beforeEach() {
        topValuesFinder = new TopValuesFinder();
        stringList = new ArrayList<>();
    }

    @Test
    public void getTopValues_normalList_success() {
        //given
        stringList.add("Cat");
        stringList.add("Cat");
        stringList.add("Cat");
        stringList.add("Dog");
        stringList.add("Dog");
        stringList.add("Bee");

        List<Map.Entry<String, Long>> actualTopList = new ArrayList<>();
        actualTopList.add(Map.entry("Cat", 3L));
        actualTopList.add(Map.entry("Dog", 2L));
        actualTopList.add(Map.entry("Bee", 1L));

        //when
        List<Map.Entry<String, Long>> calculatedTopList = topValuesFinder.getTopValues(stringList);

        //then
        Assertions.assertEquals(calculatedTopList, actualTopList);
    }
}
