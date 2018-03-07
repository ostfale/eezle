package lambda.defaultMethods;

/**
 * Created by Uwe Sauerbrei on 07.03.2018
 */
public class SeaPlane extends Vehicle implements FastFly, Sail {

    private int altitude;

    public static void main(String[] args) {
        new SeaPlane().doIt();
    }

    private void doIt() {
        showHierarchy();
     /*   doFly(100);
        doFly(0);*/
    }

    private void showHierarchy() {
        SeaPlane seaPlane = new SeaPlane();
        seaPlane.takeOff();
        seaPlane.turn();
        seaPlane.cruise();
        seaPlane.land();
    }

    private void doFly(int i) {
        altitude = i;
        cruise();
    }


    public void cruise() {
        System.out.println("SeaPlane::cruise currently cruise like...");
        if (altitude > 0) {
            FastFly.super.cruise();
        } else {
            Sail.super.cruise();
        }
    }

}
