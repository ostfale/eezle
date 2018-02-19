package de.ostfale.fp.lambda.collector;

import de.ostfale.fp.lambda.Strings.Person;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

/**
 * Collect method is a reduce method useful for transforming collection  into another form.
 * Created by Uwe Sauerbrei on 18.02.2018
 */
public class CollectReduceMethod {

    private final List<Person> people = Arrays.asList(
            new Person("John", 20),
            new Person("Sara", 21),
            new Person("Jane", 21),
            new Person("Greg", 35)
    );

    public static void main(String[] args) {
        new CollectReduceMethod().doIt();
    }

    private void doIt() {
        groupedByNameWithFirstCharacterAndOldestPerson();
        groupedByNameOrderedByAge();
        groupedByAge();
        olderThan20WithMethodRefsAndToList();
        olderThan20WithMethodRefs();
        olderThan20();
    }

    private void groupedByNameWithFirstCharacterAndOldestPerson() {
        Comparator<Person> byAge = Comparator.comparing(Person::getAge);
        Map<Character, Optional<Person>> oldestPersonOfEachLetter =
                people.stream()
                        .collect(Collectors.groupingBy(person -> person.getName().charAt(0), reducing(BinaryOperator.maxBy(byAge))));
        System.out.println("Oldest person of each letter: " + oldestPersonOfEachLetter);
    }

    private void groupedByNameOrderedByAge() {
        Map<Integer, List<String>> nameOfPeopleByAge =
                people.stream()
                        .collect(Collectors.groupingBy(Person::getAge, mapping(Person::getName, toList())));
        System.out.println("People grouped by age: " + nameOfPeopleByAge);
    }

    private void groupedByAge() {
        Map<Integer, List<Person>> peopleByAge =
                people.stream()
                        .collect(Collectors.groupingBy((Person::getAge)));
        System.out.println("Grouped by age:" + peopleByAge);
    }

    private void olderThan20WithMethodRefsAndToList() {
        List<Person> olderThan20 =
                people.stream()
                        .filter(person -> person.getAge() > 20)
                        .collect(toList());
        System.out.println("People older than 20 : " + olderThan20);
    }

    /**
     * Clearly states we collect result into an ArrayList. Collect method takes a factory of supplier  as the first parameter.
     * Followed by operations that help accumulate elements into a collection
     */
    private void olderThan20WithMethodRefs() {
        List<Person> olderThan20 =
                people.stream()
                        .filter(person -> person.getAge() > 20)
                        .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);  // supplier | accumulator | combiner
        System.out.println("People older than 20 : " + olderThan20);
    }

    private void olderThan20() {
        List<Person> olderThan20 = new ArrayList<>();
        people.stream()
                .filter(person -> person.getAge() > 20)
                .forEach(person -> olderThan20.add(person));
        System.out.println("People older than 20 : " + olderThan20);
    }
}
