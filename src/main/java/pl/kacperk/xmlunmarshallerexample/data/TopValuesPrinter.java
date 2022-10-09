package pl.kacperk.xmlunmarshallerexample.data;

import java.util.List;
import java.util.Map;

//Prints the most common values with their number of occurrences with declared limit
public class TopValuesPrinter {

    public void printTopValues(List<Map.Entry<String, Long>> topObjects, int limit, String name) {
        setup(limit, name);

        StringBuilder sb = new StringBuilder("Top ");
        sb.append(limit);
        sb.append(" ").append(name);
        sb.append(": ");
        for (int i = 0; i < limit; i++) {
            sb.append(topObjects.get(i).getKey());
            sb.append("=");
            sb.append(topObjects.get(i).getValue());
            sb.append(", ");
        }
        System.out.println(sb.substring(0, sb.length() - 2));
    }

    private void setup(int limit, String name){
        if (limit <= 0) {
            throw new IllegalArgumentException("Limit must be greater or equal 1");
        }
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
    }
}
