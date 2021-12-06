package com.myepark.hackerrank;

import java.util.List;

public class PlusMinus {
    public static void plusMinus(List<Integer> arr) {
        int plus = 0, minus = 0, zero = 0, len = arr.size();

        for(int val : arr) {
            if(val > 0) plus++;
            else if(val < 0) minus++;
            else zero++;
        }

        System.out.format("%.6f\n", (float) plus / len);
        System.out.format("%.6f\n", (float) minus / len);
        System.out.format("%.6f\n", (float) zero / len);
    }
}
