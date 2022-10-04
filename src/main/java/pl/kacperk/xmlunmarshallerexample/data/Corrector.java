package pl.kacperk.xmlunmarshallerexample.data;

import pl.kacperk.xmlunmarshallerexample.entity.Child;

import java.util.List;

//Corrects the data that has been saved from xml file (if it has been incorrectly written, like in this example)
public class Corrector {

    public List<Child> correct(List<Child> children) {
        for (Child c : children) {
            c.setName(c.getName().toUpperCase());
            if (c.getEthnicity().equals("BLACK NON HISP")) {
                c.setEthnicity("BLACK NON HISPANIC");
            }
            if (c.getEthnicity().equals("ASIAN AND PACI")) {
                c.setEthnicity("ASIAN AND PACIFIC ISLANDER");
            }
            if (c.getEthnicity().equals("WHITE NON HISP")) {
                c.setEthnicity("WHITE NON HISPANIC");
            }
        }
        return children;
    }
}
