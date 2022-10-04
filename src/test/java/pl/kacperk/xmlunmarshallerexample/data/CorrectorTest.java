package pl.kacperk.xmlunmarshallerexample.data;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.kacperk.xmlunmarshallerexample.entity.Child;
import pl.kacperk.xmlunmarshallerexample.helpers.ChildrenType;
import pl.kacperk.xmlunmarshallerexample.helpers.DataMock;

import java.util.List;

public class CorrectorTest {
    private Corrector corrector;
    private DataMock dataMock;
    private List<Child> children;
    private List<Child> normalChildren;

    @BeforeEach
    public void beforeEach() {
        corrector = new Corrector();
        dataMock = new DataMock();
        normalChildren = dataMock.mockChildren(ChildrenType.NORMAL);
    }

    @Test
    public void correct_normalChildren_success() {
        //given
        children = dataMock.mockChildren(ChildrenType.NORMAL);

        //when
        List<Child> correctedChildren = corrector.correct(children);

        //then
        for (int i = 0; i < correctedChildren.size(); i++) {
            Assertions.assertEquals(correctedChildren.get(i), normalChildren.get(i));
        }
    }

    @Test
    public void correct_invalidNamesChildren_success() {
        //given
        children = dataMock.mockChildren(ChildrenType.INVALID_NAMES);

        //when
        List<Child> correctedChildren = corrector.correct(children);

        //then
        for (int i = 0; i < correctedChildren.size(); i++) {
            Assertions.assertEquals(correctedChildren.get(i), normalChildren.get(i));
        }
    }

    @Test
    public void correct_invalidEthnicitiesChildren_success() {
        //given
        children = dataMock.mockChildren(ChildrenType.INVALID_ETHNICITIES);

        //when
        List<Child> correctedChildren = corrector.correct(children);

        //then
        for (int i = 0; i < correctedChildren.size(); i++) {
            Assertions.assertEquals(correctedChildren.get(i), normalChildren.get(i));
        }
    }
}
