package com.myepark.hackerrank;

import java.util.*;
import java.util.stream.Collectors;

public class Test {
    public static List<Integer> countingSort(List<Integer> arr) {
        int[] count = new int[100];
        for(int val : arr) {
            count[val]++;
        }
        return Arrays.stream(count).boxed().collect(Collectors.toList());
    }
}
