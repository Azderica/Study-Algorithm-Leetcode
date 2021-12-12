package com.myepark.leetcode.from351to350;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithAtMostKDistinctCharacters {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int answer = 0, index = 0;
        Map<Character, Integer> charMap = new HashMap<Character, Integer>();

        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(charMap.containsKey(ch)) {
                charMap.put(ch, charMap.get(ch) + 1);
            } else {
                charMap.put(ch, 1);
            }

            if(charMap.size() <= k) {
                answer = Math.max(answer, i - index + 1);
            } else {
                while(charMap.size() > k)    {
                    char l = s.charAt(index);
                    int count = charMap.get(l);
                    if(count == 1) charMap.remove(l);
                    else charMap.put(l, charMap.get(l) - 1);
                    index++;
                }
            }
        }

        return answer;
    }
}
