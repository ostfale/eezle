package lambda.designWithLambda;

/**
 * Created by Uwe Sauerbrei on 26.02.2018
 */
public class IntegratingWebService {

    final static CalculateNav calculateNav = new CalculateNav(YahooFinance::getPrice);

    public static void main(String[] args) {
        System.out.println(String.format("100 shares of Google worth: $%.2f", calculateNav.computeStockWorth("GOOG", 100)));
    }
}
