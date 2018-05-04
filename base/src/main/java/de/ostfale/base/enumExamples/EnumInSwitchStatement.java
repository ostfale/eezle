package de.ostfale.base.enumExamples;

import static de.ostfale.base.enumExamples.SimpleEnumExample.*;

/**
 * Created by Uwe Sauerbrei on 03.05.2018
 */
public class EnumInSwitchStatement {

    public String enumInSwitch(Days day) {
        switch(day) {
            case SUNDAY:
                return "Its Sunday!!";
            case MONDAY:
                return "Its Monday";
            case TUESDAY:
                return "Its Tuesday";
            case WEDNESDAY:
                return "Its Wednesday";
            default:
                return "Rest of the week....";
        }
    }
}
