package com.myepark.leetcode.from51to100;

public class UniqueBinarySearchTrees {
    static int[] dp = new int[20];

    public int numTrees(int n) {
        // initialize
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;

        // main logic
        for(int i=3; i <= n; i++) {
            dp[i] = findBstCases(i);
        }

        // return answer;
        return dp[n];
    }

    private int findBstCases(int n) {
        int sum = 0;
        for(int i=0; i< n; i++) {
            sum += dp[i] * dp[n - 1 - i];
        }
        return sum;
    }


    // example
    // 1 -> 1
    // 2 -> 2
    // 3 -> 5
    // 4 -> 14
    // ...
    // n -> f(0) * f(n - 1) + f(1) * f(n - 2) + ... + f(n - 1) * f(0)
}
