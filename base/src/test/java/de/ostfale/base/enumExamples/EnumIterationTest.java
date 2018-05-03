package de.ostfale.base.enumExamples;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Created by Uwe Sauerbrei on 03.05.2018
 */
class EnumIterationTest {

    private EnumIteration enumIteration;

    @BeforeEach
    void setUp() {
        enumIteration = new EnumIteration();
    }

    @AfterEach
    void tearDown() {
        enumIteration = null;
    }

    @Test
    void enumIterationTest() {
        ArrayList<String> result = enumIteration.enumIteration();
        Iterator iterator = result.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        assertTrue(result.contains("SUNDAY"));
    }
}