package pl.kacperk.xmlunmarshallerexample.data;

import pl.kacperk.xmlunmarshallerexample.entity.Child;

import java.util.List;

//Corrects the data that has been saved from xml file (if it has been incorrectly written, like in this example)
public class Corrector {

    public List<Child> correct(List<Child> children) {
        for (Child c : children) {
            c.setName(c.getName().toUpperCase());
            switch (c.getEthnicity()) {
                case "BLACK NON HISP" -> c.setEthnicity("BLACK NON HISPANIC");
                case "ASIAN AND PACI" -> c.setEthnicity("ASIAN AND PACIFIC ISLANDER");
                case "WHITE NON HISP" -> c.setEthnicity("WHITE NON HISPANIC");
            }
        }
        return children;
    }
}
