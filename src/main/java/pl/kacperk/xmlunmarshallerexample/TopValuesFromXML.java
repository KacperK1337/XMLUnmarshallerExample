package pl.kacperk.xmlunmarshallerexample;

import pl.kacperk.xmlunmarshallerexample.data.Collector;
import pl.kacperk.xmlunmarshallerexample.data.Corrector;
import pl.kacperk.xmlunmarshallerexample.data.TopValuesFinder;
import pl.kacperk.xmlunmarshallerexample.data.TopValuesPrinter;
import pl.kacperk.xmlunmarshallerexample.entity.Child;
import pl.kacperk.xmlunmarshallerexample.entity.Gender;
import pl.kacperk.xmlunmarshallerexample.xml.ChildrenUnmarshaller;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.List;

//Prints the most popular names, birth years, ethnicities and first letters of names
// with a division into men and women from xml file
public class TopValuesFromXML {

    public static void main(String[] args) throws JAXBException, IOException {
        ChildrenUnmarshaller childrenUnmarshaller = new ChildrenUnmarshaller();
        List<Child> allChildren = childrenUnmarshaller.unmarshall().getChildren();

        Corrector corrector = new Corrector();
        List<Child> correctedChildren = corrector.correct(allChildren);

        Collector collector = new Collector(correctedChildren);
        List<String> allNames = collector.getAllNames();
        List<String> maleNames = collector.getGenderNames(Gender.MALE);
        List<String> femaleNames = collector.getGenderNames(Gender.FEMALE);
        List<String> allBirthYears = collector.getAllBirthYears();
        List<String> maleBirthYears = collector.getGenderBirthYears(Gender.MALE);
        List<String> femaleBirthYears = collector.getGenderBirthYears(Gender.FEMALE);
        List<String> allEthnicities = collector.getAllEthnicities();
        List<String> maleEthnicities = collector.getGenderEthnicities(Gender.MALE);
        List<String> femaleEthnicities = collector.getGenderEthnicities(Gender.FEMALE);
        List<String> allNamesFirstLetters = collector.getAllNamesFirstLetters();
        List<String> maleNamesFirstLetters = collector.getGenderNamesFirstLetters(Gender.MALE);
        List<String> femaleNamesFirstLetters = collector.getGenderNamesFirstLetters(Gender.FEMALE);

        TopValuesFinder topValuesFinder = new TopValuesFinder();
        TopValuesPrinter topValuesPrinter = new TopValuesPrinter();

        topValuesPrinter.printTopValues(
                topValuesFinder.getTopValues(allNames), 10, "names");
        topValuesPrinter.printTopValues(
                topValuesFinder.getTopValues(maleNames), 5, "male names");
        topValuesPrinter.printTopValues(
                topValuesFinder.getTopValues(femaleNames), 5, "female names");

        topValuesPrinter.printTopValues(
                topValuesFinder.getTopValues(allBirthYears), 5, "birth years");
        topValuesPrinter.printTopValues(
                topValuesFinder.getTopValues(maleBirthYears), 3, "male birth years");
        topValuesPrinter.printTopValues(
                topValuesFinder.getTopValues(femaleBirthYears), 3, "female birth years");

        topValuesPrinter.printTopValues(
                topValuesFinder.getTopValues(allEthnicities), 3, "ethnicities");
        topValuesPrinter.printTopValues(
                topValuesFinder.getTopValues(maleEthnicities), 3, "male ethnicities");
        topValuesPrinter.printTopValues(
                topValuesFinder.getTopValues(femaleEthnicities), 3, "female ethnicities");

        topValuesPrinter.printTopValues(
                topValuesFinder.getTopValues(allNamesFirstLetters), 3, "first letters of names");
        topValuesPrinter.printTopValues(
                topValuesFinder.getTopValues(maleNamesFirstLetters), 3, "first letters of male names");
        topValuesPrinter.printTopValues(
                topValuesFinder.getTopValues(femaleNamesFirstLetters), 3, "first letters of female names");
    }
}
