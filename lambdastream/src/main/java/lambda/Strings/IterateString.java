package lambda.Strings;

/**
 * Created by Uwe Sauerbrei on 13.02.2018
 */
public class IterateString {
    private final String str = "w00t";

    public static void main(String[] args) {
        new IterateString().doIt();
    }

    private void doIt() {
        filterOptimized();
        filterOutDigitsAndPrint();
        printAsCharWithMap();
        printAsChar();
        firstAttemptWithMethodReference();
        firstAttempt();
    }

    private void filterOptimized() {
        str.chars()
                .filter(Character::isDigit)
                .forEach(IterateString::printChar);
    }

    private void filterOutDigitsAndPrint() {
        str.chars()
                .filter(ch -> Character.isDigit(ch))
                .forEach(ch -> printChar(ch));
    }

    private void printAsCharWithMap() {
        str.chars()
                .mapToObj(ch -> ((char) ch))
                .forEach(System.out::println);
    }

    private void printAsChar() {
        str.chars().forEach(IterateString::printChar);
    }

    private void firstAttemptWithMethodReference() {
        str.chars().forEach(System.out::println);
    }

    private void firstAttempt() {
        str.chars().forEach(ch -> System.out.println(ch));
    }

    private static void printChar(int aChar) {
        System.out.println((char) aChar);
    }
}
