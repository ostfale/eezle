package de.ostfale.base.enumExamples;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Created by Uwe Sauerbrei on 03.05.2018
 */
class EnumFieldsAndMethodsTest {

    private EnumFieldsAndMethods enumFields;

    @BeforeEach
    void setUp() {
        enumFields = new EnumFieldsAndMethods();
    }

    @AfterEach
    void tearDown() {
        enumFields = null;
    }

    @Test
    void enumFieldsTest() {
        ArrayList<String> result = enumFields.enumFields();
        for (Object aResult : result) {
            System.out.println(aResult);
        }
        assertTrue(result.contains("SUN"));
    }
}