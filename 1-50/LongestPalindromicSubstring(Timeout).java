package com.myepark;

public class Solution {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
        System.out.println(longestPalindrome("cbbd"));
        System.out.println(longestPalindrome("a"));
        System.out.println(longestPalindrome("ac"));
    }

    public static String longestPalindrome(String s) {
        String res = "", temp = "";
        int len = s.length();

        if(len == 0)
            return "";

        res = s.substring(0, 1);

        for(int i=0; i<len; i++){
            for(int j= i + 1; j<len; j++){
                if(s.charAt(i) == s.charAt(j)){
                    temp = s.substring(i, j + 1);
                    if(isPalindrome(temp) && res.length() < temp.length()) {
                       res = temp;
                    }
                }
            }
        }
        return res;
    }

    public static boolean isPalindrome(String s) {
        int len = s.length();
        int i = 0, j = len - 1;
        while(i < j){
            if(s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}
