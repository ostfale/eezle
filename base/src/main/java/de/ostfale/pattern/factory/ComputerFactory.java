package de.ostfale.pattern.factory;

/**
 * Basic implementation of factory class
 * Created :  02.09.2018
 *
 * @author : Uwe Sauerbrei
 */
public class ComputerFactory {

    public static Computer getComputer(String type, String ram, String hdd, String cpu) {
        if ("PC".equalsIgnoreCase(type)) return new PC(ram, hdd, cpu);
        else if ("Server".equalsIgnoreCase(type)) return new Server(ram, hdd, cpu);

        return null;
    }
}
