package com.myepark.hackerrank;

public class RecursiveDigitSum {
    public static int superDigit(String n, int k) {
        String digit = n;
        // String digit = digitSum(n) * k + "";

        while(digit.length() > 1) {
            digit = digitSum(digit) + "";
        }

        digit = digitSum(digit) * k + "";
        while(digit.length() > 1) {
            digit = digitSum(digit) + "";
        }


        return Integer.valueOf(digit);
    }

    private static int digitSum(String n) {
        int val = 0;
        for(int i = 0; i < n.length(); i++) {
            val += Character.getNumericValue(n.charAt(i));
        }

        return val;
    }
}
