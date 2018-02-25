package lambda.Strings;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Created by Uwe Sauerbrei on 17.02.2018
 */
public class ComparatorInterface {

    final List<Person> people = Arrays.asList(
            new Person("John", 20),
            new Person("Sara", 21),
            new Person("Jane", 21),
            new Person("Greg", 35)
    );

    private Comparator<Person> compareAscending = Person::ageDifference;
    private Comparator<Person> compareDescending = compareAscending.reversed();

    public static void main(String[] args) {
        new ComparatorInterface().doIt();
    }

    private void doIt() {
        findYoungestPersonWithComparator();
        sortingNameWithComparator();
        sortingAgeWithComparator();
        sortingAgeReverseWithStreamMethodReference();
        sortingAgeWithStreamMethodReference();
        sortingAgeWithStreamLambda();
    }

    private void findYoungestPersonWithComparator() {
        people.stream()
                .min(Person::ageDifference)
                .ifPresent(youngest -> System.out.println("Youngest person: " + youngest));
    }

    private void sortingNameWithComparator() {
        printPeople("Sorted in ascending order by name: ",
                people.stream()
                        .sorted(Comparator.comparing(Person::getName))
                        .collect(toList()));
    }

    private void sortingAgeWithComparator() {
        printPeople("Sorted in ascending order by age: ",
                people.stream()
                        .sorted(compareAscending)
                        .collect(toList()));

        printPeople("Sorted in descending order by age: ",
                people.stream()
                        .sorted(compareDescending)
                        .collect(toList()));
    }

    private void sortingAgeReverseWithStreamMethodReference() {
        List<Person> ascendingAge = people.stream()
                .sorted((person1, person2) -> person2.ageDifference(person1))
                .collect(toList());

        printPeople("Sorted in descending order by age with lambda: ", ascendingAge);
    }

    private void sortingAgeWithStreamMethodReference() {
        List<Person> ascendingAge = people.stream()
                .sorted(Person::ageDifference)
                .collect(toList());

        printPeople("Sorted in ascending order by age method reference: ", ascendingAge);
    }

    private void sortingAgeWithStreamLambda() {
        List<Person> ascendingAge = people.stream()
                .sorted((person1, person2) -> person1.ageDifference(person2))
                .collect(toList());

        printPeople("Sorted in ascending order by age with lambda: ", ascendingAge);
    }

    private void printPeople(final String message, final List<Person> people) {
        System.out.println(message);
        people.forEach(System.out::println);
    }
}
