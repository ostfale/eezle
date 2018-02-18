package de.ostfale.fp.lambda.Strings;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

/**
 * Created by Uwe Sauerbrei on 18.02.2018
 */
public class FluentComparisons {

    private final List<Person> people = Arrays.asList(
            new Person("John", 20),
            new Person("Sara", 21),
            new Person("Jane", 21),
            new Person("Greg", 35)
    );

    private final Function<Person, String> byName = person -> person.getName();
    private final Function<Person, Integer> byAge = person -> person.getAge();

    public static void main(String[] args) {
        new FluentComparisons().doIt();
    }

    private void doIt() {
        sortByAgeAndName();
        sortPeopleComparingNames();
    }

    private void sortByAgeAndName() {
        printPeople("Sorted in ascending order by age and name",
                people.stream()
                        .sorted(comparing(byAge).thenComparing(byName))
                        .collect(toList()));
    }

    private void sortPeopleComparingNames() {
        printPeople("Fluent sort by name: ", people.stream()
                .sorted(comparing(byName))
                .collect(toList()));
    }

    private void printPeople(final String message, final List<Person> people) {
        System.out.println(message);
        people.forEach(System.out::println);
    }
}
