package com.myepark.leetcode.from1to50;

public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        // exception case
        if(x < 0) return false;

        // initialize
        String numStr = String.valueOf(x);
        int start = 0, end = numStr.length() - 1;

        // check with two pointer
        while(start < end) {
            if(numStr.charAt(start) != numStr.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
