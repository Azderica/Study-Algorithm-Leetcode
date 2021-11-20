package com.myepark.programmers.basics;

import java.util.Arrays;
import java.util.Comparator;

public class 단속카메라 {
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
