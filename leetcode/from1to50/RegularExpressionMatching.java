package com.myepark.leetcode.from1to50;

public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        // exception case
        if (s.length() == 0 && p.length() == 0) return true;
        if (p.length() == 0) return false;

        // initiailize
        int rows = s.length(), columns = p.length();
        boolean[][] dp = new boolean[rows + 1][columns + 1];
        dp[0][0] = true;

        // solution
        for (int i = 1; i < columns; i++) {
            // ** is imposible, so check after 2
            if (p.charAt(i) == '*') {
                dp[0][i + 1] = dp[0][i - 1];
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
                    dp[i + 1][j + 1] = dp[i][j];
                } else if (j > 0 && p.charAt(j) == '*') {
                    dp[i + 1][j + 1] = dp[i + 1][j - 1];
                    if (p.charAt(j - 1) == '.' || p.charAt(j - 1) == s.charAt(i)) {
                        dp[i + 1][j + 1] = dp[i + 1][j + 1] | dp[i][j + 1];
                    }
                }
            }
        }

        // make answer;
        return dp[rows][columns];
    }
}
