package de.ostfale.base.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Uwe Sauerbrei on 26.04.2018
 */
public class BaseSubstitution {

    public static void main(String[] args) {
        new BaseSubstitution().doIt();
    }

    private void doIt() {
        validSubtypes();
    }

    /**
     * According to substitution principle we have a collection of numbers and we may add integer or double to it,
     * because Integer and Double are subtypes of Number
     */
    private void validSubtypes() {
        List<Number> nums = new ArrayList<>();
        nums.add(2);
        nums.add(3.14);
        assert nums.toString().equals(("[2,3.14]"));
    }
}
