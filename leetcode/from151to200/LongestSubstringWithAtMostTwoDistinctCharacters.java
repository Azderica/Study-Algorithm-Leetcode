package com.myepark.leetcode.from151to200;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LongestSubstringWithAtMostTwoDistinctCharacters {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        // 'chain' is count that the purpose of storing the previous same value;
        // 'len' is new substing length;
        // 'max' is answer;
        int max = 0, len = 0, i = 0, chain = 1;
        char[] c = s.toCharArray();
        char first, second;

        first = c[0];

        // find first index with distinct characters
        for(; i < c.length && c[i] == first; i++, len++);
        if(i == c.length) return i;

        second = c[i];

        for(; i<c.length; i++) {
            if(c[i] == first || c[i] == second) len++;
            else {
                first = c[i-1];
                second = c[i];
                max = Math.max(max, len);
                len = chain + 1;
            }
            if(c[i] == c[i-1]) chain++;
            else chain = 1;
        }

        max = Math.max(max, len);
        return max;
    }


    @Test
    public void test() {
        Assertions.assertEquals(lengthOfLongestSubstringTwoDistinct("eceba"), 3);
        Assertions.assertEquals(lengthOfLongestSubstringTwoDistinct("ccaabbb"), 5);
        Assertions.assertEquals(lengthOfLongestSubstringTwoDistinct("a"), 1);
    }
}
