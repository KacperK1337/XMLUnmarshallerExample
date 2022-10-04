package pl.kacperk.xmlunmarshallerexample.data;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.kacperk.xmlunmarshallerexample.entity.Gender;
import pl.kacperk.xmlunmarshallerexample.helpers.ChildrenType;
import pl.kacperk.xmlunmarshallerexample.helpers.DataMock;

import java.util.ArrayList;
import java.util.List;

public class CollectorTest {
    private Collector collector;

    @BeforeEach
    public void beforeEach() {
        DataMock dataMock = new DataMock();
        collector = new Collector(dataMock.mockChildren(ChildrenType.NORMAL));
    }

    @Test
    public void getAllNames_normalChildren_success(){
        //given
        List<String> expectedNames = new ArrayList<>();
        expectedNames.add("MAX");
        expectedNames.add("ANNA");
        expectedNames.add("JOHN");

        //when
        List<String> names = collector.getAllNames();

        //then
        Assertions.assertEquals(names, expectedNames);
    }

    @Test
    public void getMaleNames_normalChildren_success(){
        //given
        List<String> expectedMaleNames = new ArrayList<>();
        expectedMaleNames.add("MAX");
        expectedMaleNames.add("JOHN");

        //when
        List<String> maleNames = collector.getGenderNames(Gender.MALE);

        //then
        Assertions.assertEquals(maleNames, expectedMaleNames);
    }

    @Test
    public void getFemaleNames_normalChildren_success(){
        //given
        List<String> expectedFemaleNames = new ArrayList<>();
        expectedFemaleNames.add("ANNA");

        //when
        List<String> femaleNames = collector.getGenderNames(Gender.FEMALE);

        //then
        Assertions.assertEquals(femaleNames, expectedFemaleNames);
    }

    @Test
    public void getAllBirthYears_normalChildren_success(){
        //given
        List<String> expectedBirthYears = new ArrayList<>();
        expectedBirthYears.add("2000");
        expectedBirthYears.add("2001");
        expectedBirthYears.add("1999");

        //when
        List<String> birthYears = collector.getAllBirthYears();

        //then
        Assertions.assertEquals(birthYears, expectedBirthYears);
    }

    @Test
    public void getMaleBirthYears_normalChildren_success(){
        //given
        List<String> expectedMaleBirthYears = new ArrayList<>();
        expectedMaleBirthYears.add("2000");
        expectedMaleBirthYears.add("1999");

        //when
        List<String> maleBirthYears = collector.getGenderBirthYears(Gender.MALE);

        //then
        Assertions.assertEquals(maleBirthYears, expectedMaleBirthYears);
    }

    @Test
    public void getFemaleBirthYears_normalChildren_success(){
        //given
        List<String> expectedFemaleBirthYears = new ArrayList<>();
        expectedFemaleBirthYears.add("2001");

        //when
        List<String> femaleBirthYears = collector.getGenderBirthYears(Gender.FEMALE);

        //then
        Assertions.assertEquals(femaleBirthYears, expectedFemaleBirthYears);
    }

    @Test
    public void getAllEthnicities_normalChildren_success(){
        //given
        List<String> expectedEthnicities = new ArrayList<>();
        expectedEthnicities.add("BLACK NON HISPANIC");
        expectedEthnicities.add("ASIAN AND PACIFIC ISLANDER");
        expectedEthnicities.add("WHITE NON HISPANIC");

        //when
        List<String> ethnicities = collector.getAllEthnicities();

        //then
        Assertions.assertEquals(ethnicities, expectedEthnicities);
    }

    @Test
    public void getMaleEthnicities_normalChildren_success(){
        //given
        List<String> expectedMaleEthnicities = new ArrayList<>();
        expectedMaleEthnicities.add("BLACK NON HISPANIC");
        expectedMaleEthnicities.add("WHITE NON HISPANIC");

        //when
        List<String> maleEthnicities = collector.getGenderEthnicities(Gender.MALE);

        //then
        Assertions.assertEquals(maleEthnicities, expectedMaleEthnicities);
    }

    @Test
    public void getFemaleEthnicities_normalChildren_success(){
        //given
        List<String> expectedFemaleEthnicities = new ArrayList<>();
        expectedFemaleEthnicities.add("ASIAN AND PACIFIC ISLANDER");

        //when
        List<String> femaleEthnicities = collector.getGenderEthnicities(Gender.FEMALE);

        //then
        Assertions.assertEquals(femaleEthnicities, expectedFemaleEthnicities);
    }

    @Test
    public void getAllNamesFirstLetters_normalChildren_success(){
        //given
        List<String> expectedNamesFirstLetters = new ArrayList<>();
        expectedNamesFirstLetters.add("M");
        expectedNamesFirstLetters.add("A");
        expectedNamesFirstLetters.add("J");

        //when
        List<String> namesFirstLetters = collector.getAllNamesFirstLetters();

        //then
        Assertions.assertEquals(namesFirstLetters, expectedNamesFirstLetters);
    }

    @Test
    public void getMaleNamesFirstLetters_normalChildren_success(){
        //given
        List<String> expectedMaleNamesFirstLetters = new ArrayList<>();
        expectedMaleNamesFirstLetters.add("M");
        expectedMaleNamesFirstLetters.add("J");

        //when
        List<String> maleNamesFirstLetters = collector.getGenderNamesFirstLetters(Gender.MALE);

        //then
        Assertions.assertEquals(maleNamesFirstLetters, expectedMaleNamesFirstLetters);
    }

    @Test
    public void getFemaleNamesFirstLetters_normalChildren_success(){
        //given
        List<String> expectedFemaleNamesFirstLetters = new ArrayList<>();
        expectedFemaleNamesFirstLetters.add("A");

        //when
        List<String> femaleNamesFirstLetters = collector.getGenderNamesFirstLetters(Gender.FEMALE);

        //then
        Assertions.assertEquals(femaleNamesFirstLetters, expectedFemaleNamesFirstLetters);
    }
}
