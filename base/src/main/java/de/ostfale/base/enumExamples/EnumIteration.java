package de.ostfale.base.enumExamples;

import java.util.ArrayList;

/**
 * Created by Uwe Sauerbrei on 03.05.2018
 */
public class EnumIteration {

    enum Days{
        SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY;
    }
    public ArrayList<String> enumIteration() {
        Days[] days = Days.values();
        ArrayList<String> stringDay = new ArrayList<String>();
        for (Days day : days) {
            stringDay.add(day.toString());
        }
        return stringDay;
    }
}
