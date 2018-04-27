package de.ostfale.base.generic;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Use extend wildcard when you only get values and super if you put values
 * Created by Uwe Sauerbrei on 27.04.2018
 */
public class PutGetPrinciple {

    private final static List<Integer> ints = Arrays.asList(1, 2, 3);
    private final static List<Double> dbls = Arrays.asList(2.78, 3.14);
    private final static List<Number> nums = Arrays.asList(1, 2, 2.78, 3.14);

    public static void main(String[] args) {
        new PutGetPrinciple().doIt();
    }

    private void doIt() {
        validGetExample();
    }

    private void validGetExample() {
        assert sum(ints) == 6;          // not legal without extends
        assert sum(dbls) == 5.92;       // not legal without extends
        assert sum(nums) == 8.92;
    }

    /**
     * Extends allows to get data from collection
     *
     * @param nums parameter collection
     * @return sum of the values
     */
    private static double sum(Collection<? extends Number> nums) {
        double s = 0.0;
        for (Number num : nums) {
            s += num.doubleValue();
        }
        return s;
    }
}
