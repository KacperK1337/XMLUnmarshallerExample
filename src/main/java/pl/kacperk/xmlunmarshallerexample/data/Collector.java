package pl.kacperk.xmlunmarshallerexample.data;

import pl.kacperk.xmlunmarshallerexample.entity.Child;
import pl.kacperk.xmlunmarshallerexample.entity.Gender;

import java.util.ArrayList;
import java.util.List;

//Collects specific data that has been saved from xml file as string lists
public class Collector {

    private final List<Child> children;

    public Collector(List<Child> children) {
        this.children = children;
    }

    public List<String> getAllNames() {
        List<String> allNames = new ArrayList<>();
        for (Child c : children) {
            allNames.add(c.getName());
        }
        return allNames;
    }

    public List<String> getGenderNames(Gender gender) {
        List<String> genderNames = new ArrayList<>();
        for (Child c : children) {
            if (c.getGender().equals(gender)) {
                genderNames.add(c.getName());
            }
        }
        return genderNames;
    }

    public List<String> getAllBirthYears() {
        List<String> allBirthYears = new ArrayList<>();
        for (Child c : children) {
            allBirthYears.add(String.valueOf(c.getBirthYear()));
        }
        return allBirthYears;
    }

    public List<String> getGenderBirthYears(Gender gender) {
        List<String> genderBirthYears = new ArrayList<>();
        for (Child c : children) {
            if (c.getGender().equals(gender)) {
                genderBirthYears.add(String.valueOf(c.getBirthYear()));
            }
        }
        return genderBirthYears;
    }

    public List<String> getAllEthnicities() {
        List<String> allEthnicities = new ArrayList<>();
        for (Child c : children) {
            allEthnicities.add(c.getEthnicity());
        }
        return allEthnicities;
    }

    public List<String> getGenderEthnicities(Gender gender) {
        List<String> genderEthnicities = new ArrayList<>();
        for (Child c : children) {
            if (c.getGender().equals(gender)) {
                genderEthnicities.add(c.getEthnicity());
            }
        }
        return genderEthnicities;
    }

    public List<String> getAllNamesFirstLetters() {
        List<String> allFirstLetters = new ArrayList<>();
        for (Child c : children) {
            allFirstLetters.add(String.valueOf(c.getName().charAt(0)));
        }
        return allFirstLetters;
    }

    public List<String> getGenderNamesFirstLetters(Gender gender) {
        List<String> genderFirstLetters = new ArrayList<>();
        for (Child c : children) {
            if (c.getGender().equals(gender)) {
                genderFirstLetters.add(String.valueOf(c.getName().charAt(0)));
            }
        }
        return genderFirstLetters;
    }
}
