package com.myepark;

public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
        System.out.println(lengthOfLongestSubstring(""));
    }

    public static int lengthOfLongestSubstring(String s) {
        String temp="", result="";
        int start = 0;

        if(s.length() == 0)
            return 0;
        for(int i=0; i<s.length(); i++){
            int index = temp.indexOf(s.charAt(i));
            if(index != -1)
                start = start + index + 1;
            temp = s.substring(start, i+1);
            if(temp.length() > result.length())
                result = temp;
        }
        return result.length();
    }
}
