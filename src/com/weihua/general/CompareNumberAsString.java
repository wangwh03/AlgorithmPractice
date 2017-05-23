package com.weihua.general;

import java.util.Arrays;
import java.util.Comparator;

/*
 * A google interview problem from mitbbs.  compare two doubles, compare integer first, and then decimal part
 */
public class CompareNumberAsString {

    public static void main(String[] args) {
        CompareNumberAsString test = new CompareNumberAsString();
        Double[] input = new Double[]{1.2, 2.2, 2.15};
        test.specialSort(input);
    }
    
    public void specialSort(Double[] input) {
        Arrays.sort(input, new NumberComparator());
        PrintUtils.print(input);
    }

    public static class NumberComparator implements Comparator<Double> {

        @Override
        public int compare(Double o1, Double o2) {
            if (o1 == null && o2 == null) {
                return 0;
            } else if (o1 == null) {
                return -1;
            } else if (o2 == null) {
                return 1;
            }

            Double firstDecimal = o1 % 1;
            Long firstInt = (long) (o1 - firstDecimal);
            Double secondDecimal = o2 % 1;
            Long secondInt = (long) (o2 - secondDecimal);

            if (!firstInt.equals(secondInt)) {
                return firstInt.compareTo(secondInt);
            } else {
                return -firstDecimal.toString().compareTo(secondDecimal.toString());
            }
        }
    } 
}


