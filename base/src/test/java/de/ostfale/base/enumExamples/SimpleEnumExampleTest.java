package de.ostfale.base.enumExamples;

import org.junit.jupiter.api.Test;

import static de.ostfale.base.enumExamples.SimpleEnumExample.Days;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by Uwe Sauerbrei on 03.05.2018
 */
class SimpleEnumExampleTest {

    @Test
    void simpleEnumExampleOutsideClassTest() {
        Days day = Days.SATURDAY;

        System.out.println("Days enum is set a value: " + day);
        assertEquals(Days.valueOf("SATURDAY"), day);
    }
}