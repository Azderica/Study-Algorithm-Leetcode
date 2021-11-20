package com.myepark.programmers.basics;

import java.util.Arrays;
import java.util.Comparator;

public class 섬연결하기 {
    public int solution(int n, int[][] costs) {
        int answer = 0;
        int[] parents = new int[n];

        Arrays.sort(costs, Comparator.comparingInt((int[] o) -> o[2]));
        for (int i = 0; i < n; i++)
            parents[i] = i;
        for (int i = 0; i < costs.length; i++) {
            int firstIsland = findParent(costs[i][0], parents);
            int secondIsland = findParent(costs[i][1], parents);
            if (firstIsland != secondIsland) {
                parents[secondIsland] = firstIsland;
                answer += costs[i][2];
            }
        }

        return answer;
    }

    private int findParent(int child, int[] parents) {
        if (parents[child] == child) {
            return child;
        } else {
            return parents[child] = findParent(parents[child], parents);
        }
    }
}
