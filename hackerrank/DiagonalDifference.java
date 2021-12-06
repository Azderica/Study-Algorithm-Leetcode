package com.myepark.hackerrank;

import java.util.List;

public class DiagonalDifference {
    public static int diagonalDifference(List<List<Integer>> arr) {
        int len = arr.size(), sum = 0;
        for(int i=0; i<len; i++) {
            sum += arr.get(i).get(len - i - 1);
            sum -= arr.get(i).get(i);
        }
        return Math.abs(sum);
    }
}
