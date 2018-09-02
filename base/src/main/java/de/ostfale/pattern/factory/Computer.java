package de.ostfale.pattern.factory;

/**
 * Super class in factory design pattern can be an interface, abstract class or a normal java class.
 * Created :  02.09.2018
 *
 * @author : Uwe Sauerbrei
 */
public abstract class Computer {

    public abstract String getRAM();

    public abstract String getHDD();

    public abstract String getCPU();

    @Override
    public String toString() {
        return "RAM= " + this.getRAM() + ", HDD=" + this.getHDD() + ", CPU=" + this.getCPU();
    }
}
