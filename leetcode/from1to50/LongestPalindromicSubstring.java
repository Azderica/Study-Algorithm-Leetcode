package com.myepark.leetcode.from1to50;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
        System.out.println(longestPalindrome("cbbd"));
        System.out.println(longestPalindrome("a"));
        System.out.println(longestPalindrome("ac"));
    }

    // use dp
    public static String longestPalindrome(String s) {
        String res = "";
        char[] chr = s.toCharArray();
        boolean[][] dp = new boolean[chr.length][chr.length];
        int max_len = 0;

        for (int i = chr.length - 1; i >= 0; i--) {
            for (int j = i; j < chr.length; j++) {
                dp[i][j] = (chr[i] == chr[j] && (j - i <= 2 || dp[i + 1][j - 1]));
                if (dp[i][j] && j - i >= max_len) {
                    max_len = j - i;
                    res = s.substring(i, j + 1);
                }
            }
        }

        return res;
    }
}
