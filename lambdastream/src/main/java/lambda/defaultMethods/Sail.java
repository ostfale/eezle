package lambda.defaultMethods;

/**
 * Created by Uwe Sauerbrei on 07.03.2018
 */
public interface Sail {

    default void cruise() {
        System.out.println("Sail::cruise");
    }

    default void turn() {
        System.out.println("Sail::turn");
    }
}
