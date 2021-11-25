package com.myepark.programmers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CodeTest {
    public int[] solution(int n, int[][] record) {
        int[] answer = new int[n];
        int[][] bidders = new int[n + 1][2];

        for (int[] order : record) {
            bidders[order[0]][0] = order[0];
            bidders[order[0]][1] = Math.max(bidders[order[0]][1], order[1]);
        }


        return answer;
    }

    @Test
    public void test() {
        Assertions.assertArrayEquals(solution(3, new int[][]{{1, 100}, {2, 150}, {3, 300}, {1, 200}, {3, 350}, {2, -1}, {3, -1}, {3, 190}}), new int[]{1, 3, 2});

    }
}