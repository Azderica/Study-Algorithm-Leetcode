package com.myepark.programmers;

import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0, min = Integer.MIN_VALUE;

        // 종료 시점으로 정렬
        Arrays.sort(routes, Comparator.comparingInt(a -> a[1]));
        for (int[] route : routes) {
            if (min < route[0]) {
                min = route[1];
                answer++;
            }
        }

        return answer;
    }
}