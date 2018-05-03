package de.ostfale.base.enumExamples;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by Uwe Sauerbrei on 03.05.2018
 */
@DisplayName("Test for external enum class")
class MonthTest {

    @Test
    @DisplayName("Test separate enum class")
    void simpleEnumExampleSeparateClass() {
        Month month = Month.APRIL;

        System.out.println("Month enum is set a value: " + month);
        assertEquals(Month.valueOf("APRIL"), month);
    }
}