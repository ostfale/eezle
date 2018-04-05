package lambda.designWithLambda;

import java.math.BigDecimal;
import java.util.function.Function;

/**
 * Delegate responsibility to lambda
 * Created by Uwe Sauerbrei on 25.02.2018
 */
class CalculateNav {

    private final Function<String, BigDecimal> priceFinder;

    CalculateNav(final Function<String, BigDecimal> priceFinder) {
        this.priceFinder = priceFinder;
    }

    BigDecimal computeStockWorth(final String ticker, final int shares) {
        return priceFinder.apply(ticker).multiply(BigDecimal.valueOf(shares));
    }
}
