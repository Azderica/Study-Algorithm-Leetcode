package com.myepark.programmers.basics;

public class 정수삼각형 {
    public int solution(int[][] triangle) {
        int size = triangle.length, answer = 0;
        int dp[][] = new int[size][size];

        dp[0][0] = triangle[0][0];
        for (int i = 1; i < size; i++) {
            dp[i][0] = triangle[i][0] + dp[i - 1][0];
            for (int j = 1; j < i + 1; j++) {
                dp[i][j] = triangle[i][j] + Math.max(dp[i - 1][j - 1], dp[i - 1][j]);
            }
        }

        for (int i = 0; i < size; i++) {
            answer = Math.max(answer, dp[size - 1][i]);
        }
        return answer;
    }
}
