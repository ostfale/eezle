package de.ostfale.fp.lambda.filter;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Pick a single element from a collection
 * Created by Uwe Sauerbrei on 06.02.2018
 */
public class CPickAnElement {

    private final List<String> friends = Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");

    public static void main(String[] args) {
        new CPickAnElement().doIt();
    }

    private void doIt() {
        pickNameWithLambda(friends, "N");
        pickNameWithLambda(friends, "X");
        oldFashionedWay(friends, "N");
        oldFashionedWay(friends, "X");
    }

    private void pickNameWithLambda(final List<String> names, final String startingLetter)
    {
        final Optional<String> foundName = names.stream()
                .filter(name -> name.startsWith(startingLetter))
                .findFirst();

        System.out.println(String.format("A name starting with %s: %s", startingLetter, foundName.orElse("Name not found")));
    }

    private void oldFashionedWay(final List<String> names, final String startingLetter) {
        String found = null;
        for (String name : names) {
            if (name.startsWith(startingLetter)) {
                found = name;
                break;
            }
        }
        System.out.println(String.format("A name string starting with %s: ", startingLetter));
        if (found != null) {
            System.out.println(found);
        } else {
            System.out.println("No name found!");
        }
    }
}
