package designWithLambda;

import java.math.BigDecimal;
import java.util.function.Function;

/**
 * Created by Uwe Sauerbrei on 25.02.2018
 */
public class CalculateNav {

    private final Function<String, BigDecimal> priceFinder;

    public CalculateNav(final Function<String, BigDecimal> priceFinder) {
        this.priceFinder = priceFinder;
    }

    public BigDecimal computeStockWorth(final String ticker, final int shares) {
        return priceFinder.apply(ticker).multiply(BigDecimal.valueOf(shares));
    }
}
