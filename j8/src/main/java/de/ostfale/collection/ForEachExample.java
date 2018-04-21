package de.ostfale.collection;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Signature of 'forEach' => default void forEach(Consumer<? super T> action)
 * Uses a functional interface (Consumer) with it's accept method
 * Created by Uwe Sauerbrei on 21.04.2018
 */
public class ForEachExample {

    private static final List<String> cityList = Arrays.asList("New York City", "Chicago", "Washington DC", "San Francisco", "Boston");

    private static final Map<String, String> countryCapitalMap = new HashMap<>();


    public static void main(String[] args) {
        init();
        iterateThroughList();
        iterateThroughMap();
        iterateThroughListStream();
        iterateThroughParalleStream();
    }

    private static void init() {
        countryCapitalMap.put("US", "Wshington DC");
        countryCapitalMap.put("England", "London");
        countryCapitalMap.put("France", "Paris");
        countryCapitalMap.put("Germany", "Berlin");
    }

    private static void iterateThroughList() {
        cityList.forEach(System.out::println);
    }

    private static void iterateThroughMap() {
        countryCapitalMap.forEach((k, v) -> System.out.println("Key: " + k + " Value: " + v));
    }

    private static void iterateThroughListStream() {
        cityList.stream().forEach(System.out::println);
    }

    private static void iterateThroughParalleStream() {
        cityList.parallelStream().forEach(System.out::println);
    }
}
