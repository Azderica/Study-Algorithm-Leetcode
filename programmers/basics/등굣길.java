package com.myepark.programmers.basics;

public class 등굣길 {
    private static int MAX_VAL = 1000000007;

    public int solution(int m, int n, int[][] puddles) {
        int dp[][] = new int[n + 1][m + 1];

        for (int y = 1; y <= n; y++) {
            for (int x = 1; x <= m; x++) {
                if (y == 1 && x == 1) {
                    dp[y][x] = 1;
                } else if (isPuddle(x, y, puddles)) {
                    dp[y][x] = 0;
                } else {
                    dp[y][x] = dp[y - 1][x] % MAX_VAL + dp[y][x - 1] % MAX_VAL;
                }
            }
        }

        return dp[n][m] % MAX_VAL;
    }

    private boolean isPuddle(int m, int n, int[][] puddles) {
        for (int[] puddle : puddles) {
            if (puddle[0] == m && puddle[1] == n)
                return true;
        }
        return false;
    }
}
