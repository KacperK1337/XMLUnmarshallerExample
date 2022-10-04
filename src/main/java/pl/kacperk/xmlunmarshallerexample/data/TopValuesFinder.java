package pl.kacperk.xmlunmarshallerexample.data;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//Finds the most common values from a list of strings (sorts the list from the most common to the least frequent)
public class TopValuesFinder {

    public List<Map.Entry<String, Long>> getTopValues(List<String> stringList) {
        Map<String, Long> stringOccurrences = stringList.stream()
                .collect(Collectors.groupingBy(Object::toString, Collectors.counting()));
        return stringOccurrences.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).toList();
    }
}
