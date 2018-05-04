package de.ostfale.base.enumExamples;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by Uwe Sauerbrei on 03.05.2018
 */
class EnumInIfStatementTest {

    private EnumInIfStatement enumInIfStatement;

    @BeforeEach
    void setUp() {
        enumInIfStatement = new EnumInIfStatement();
    }

    @AfterEach
    void tearDown() {
        enumInIfStatement = null;
    }

    @Test
    void enumInIfTest() {
        String result = enumInIfStatement.enumInIf(SimpleEnumExample.Days.SUNDAY);
        System.out.println(result);
        assertEquals("Its Sunday :-)", result);
    }
}