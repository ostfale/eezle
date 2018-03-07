package lambda.defaultMethods;

/**
 * Created by Uwe Sauerbrei on 07.03.2018
 */
public interface FastFly extends Fly {

    default void takeOff() {
        System.out.println("FastFly::takeOff");
    }
}
