package pl.kacperk.xmlunmarshallerexample.entity;

import lombok.*;

import javax.xml.bind.annotation.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@XmlRootElement(name = "row")
@XmlAccessorType(XmlAccessType.FIELD)
//Class representing a single child with name, gender, birth year and ethnicity
public class Child {

    @XmlElement(name = "nm")
    private String name;

    @XmlElement(name = "gndr")
    private Gender gender;

    @XmlElement(name = "brth_yr")
    private int birthYear;

    @XmlElement(name = "ethcty")
    private String ethnicity;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Child child)) return false;
        return getBirthYear() == child.getBirthYear() &&
                getName().equals(child.getName()) &&
                getGender() == child.getGender() &&
                getEthnicity().equals(child.getEthnicity());
    }
}
