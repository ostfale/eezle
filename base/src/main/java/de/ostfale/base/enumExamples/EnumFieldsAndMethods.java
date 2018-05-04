package de.ostfale.base.enumExamples;

import java.util.ArrayList;

/**
 * Created by Uwe Sauerbrei on 03.05.2018
 */
public class EnumFieldsAndMethods {
    public ArrayList<String> enumFields() {
        AbbreviationOfDays[] abbreviationOfDays = AbbreviationOfDays.values();
        ArrayList<String> daysList = new ArrayList<>();
        for (AbbreviationOfDays day : abbreviationOfDays) {
            daysList.add(day.getAbbreviation());
        }
        return daysList;
    }
}

enum AbbreviationOfDays {

    SUNDAY("SUN"), MONDAY("MON"), TUESDAY("TUES"), WEDNESDAY("WED"), THURSDAY("THURS"), FRIDAY("FRI"), SATURDAY("SAT");

    private String abbreviation;

    public String getAbbreviation() {
        return this.abbreviation;
    }

    AbbreviationOfDays(String abbreviation) {
        this.abbreviation = abbreviation;
    }
}
