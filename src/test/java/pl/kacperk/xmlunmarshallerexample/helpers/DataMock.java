package pl.kacperk.xmlunmarshallerexample.helpers;

import pl.kacperk.xmlunmarshallerexample.entity.Child;
import pl.kacperk.xmlunmarshallerexample.entity.Gender;

import java.util.ArrayList;
import java.util.List;

public class DataMock {

    public List<Child> mockChildren(ChildrenType childrenType) {
        List<Child> children = new ArrayList<>();
        children.add(Child.builder()
                .name("MAX")
                .gender(Gender.MALE)
                .birthYear(2000)
                .ethnicity("BLACK NON HISPANIC")
                .build());
        children.add(Child.builder()
                .name("ANNA")
                .gender(Gender.FEMALE)
                .birthYear(2001)
                .ethnicity("ASIAN AND PACIFIC ISLANDER")
                .build());
        children.add(Child.builder()
                .name("JOHN")
                .gender(Gender.MALE)
                .birthYear(1999)
                .ethnicity("WHITE NON HISPANIC")
                .build());
        switch (childrenType) {
            case INVALID_NAMES -> {
                children.get(0).setName("Max");
                children.get(1).setName("Anna");
                children.get(2).setName("John");
            }
            case INVALID_ETHNICITIES -> {
                children.get(0).setEthnicity("BLACK NON HISP");
                children.get(1).setEthnicity("ASIAN AND PACI");
                children.get(2).setEthnicity("WHITE NON HISP");
            }
        }
        return children;
    }
}
