package de.ostfale.base.enumExamples;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static de.ostfale.base.enumExamples.SimpleEnumExample.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by Uwe Sauerbrei on 03.05.2018
 */
class EnumInSwitchStatementTest {

    private EnumInSwitchStatement enumInSwitchStatement;

    @BeforeEach
    void setUp() {
        enumInSwitchStatement = new EnumInSwitchStatement();
    }

    @AfterEach
    void tearDown() {
        enumInSwitchStatement = null;
    }

    @Test
    void enumInSwitchTest() {
        String result = enumInSwitchStatement.enumInSwitch(Days.SUNDAY);
        System.out.println(result);
        assertEquals("Its Sunday!!", result);
    }
}