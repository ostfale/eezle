package lambda.basic;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

/**
 * Collection of prices and try to get discounted prices
 * Created by Uwe Sauerbrei on 05.01.2018
 */
public class DiscountPrices {

    private BigDecimal totalDiscountedPrices = BigDecimal.ZERO;

    final List<BigDecimal> prices = Arrays.asList(new BigDecimal("10"), new BigDecimal("30"), new BigDecimal("17"),
            new BigDecimal("20"), new BigDecimal("15"), new BigDecimal("18"), new BigDecimal("45"), new BigDecimal("12"));

    public static void main(String[] args) {
        new DiscountPrices().doIt();
    }

    private void doIt() {
        imperativeSolution();
        functionalSolution();
    }

    private void imperativeSolution() {
        for (BigDecimal price : prices) {
            if (price.compareTo(BigDecimal.valueOf(20)) > 0) {
                totalDiscountedPrices = totalDiscountedPrices.add(price.multiply(BigDecimal.valueOf(0.9)));
            }
        }
        System.out.println("Total of discounted prices using imperative programming:  " + totalDiscountedPrices);
    }

    private void functionalSolution() {
        final BigDecimal totalDiscountedPrices = prices.stream()
                .filter(price -> price.compareTo(BigDecimal.valueOf(20)) > 0)
                .map(price -> price.multiply(BigDecimal.valueOf(0.9)))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println("Total of discounted prices using functional programming:  " + totalDiscountedPrices);
    }

}
