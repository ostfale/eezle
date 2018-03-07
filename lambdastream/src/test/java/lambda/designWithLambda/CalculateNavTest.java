package lambda.designWithLambda;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * Created by Uwe Sauerbrei on 25.02.2018
 */
public class CalculateNavTest {

    @Test
    public void computeStockWorth() {
        final CalculateNav calculateNav = new CalculateNav(ticker -> new BigDecimal("6.01"));
        BigDecimal expected = new BigDecimal("6010.00");
        assertEquals(0, calculateNav.computeStockWorth("GOOG", 1000).compareTo(expected), 0.001);
    }
}