package de.ostfale.base.enumExamples;

/**
 * Some key points on the enum type are:
 * <ul>
 * <li>Java enums extend the java.lang.Enum class implicitly. Therefore, you cannot extend any other class in enum.</li>
 * <li>Enums can implement interfaces. They implicitly implement the Serializable and Comparable interfaces. This means if you need some common
 * functionality along diverse enum types, you can define it with an interface to have the enums provide the method implementations.</li>
 * <li>In Java, enum is a keyword. Enum constructors are always private or default. Therefore, you cannot have public or protected constructors
 * in an enum type.</li>
 * <li>In an enum definition, comma separated constants must be terminated with a semicolon.</li>
 * <li>You cannot create an instance of enum using the new operator.</li>
 * <li>You can declare abstract methods within an enum. If you do so, all the enum fields must implement the abstract methods.</li>
 * <li>You can use the “==” operator to compare enum constants effectively, since enum constants are final.</li>
 * </ul>
 * Created by Uwe Sauerbrei on 03.05.2018
 */
public class SimpleEnumExample {

    enum Days {SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY}
}
