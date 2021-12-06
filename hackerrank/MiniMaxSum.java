package com.myepark.hackerrank;

import java.util.List;

public class MiniMaxSum {
    public static void miniMaxSum(List<Integer> arr) {
        // Write your code here
        long min = arr.get(0), max = arr.get(0), sum = 0;

        for(int val : arr) {
            sum += val;
            if(val < min) min = val;
            if(val > max) max = val;
        }

        System.out.format("%d %d\n", sum - max, sum - min);
    }
}
