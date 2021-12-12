package com.myepark.leetcode.from1to50;

public class CountAndSay {

    public static void main(String[] args) {
        System.out.println(countAndSay(1));
        System.out.println(countAndSay(4));
        System.out.println(countAndSay(6));
        System.out.println(countAndSay(7));
    }

    public static String countAndSay(int n) {
        String res = "1";

        for(int i=1; i<n; i++) {
            String tmp = "";
            int count = 1;
            for(int j=1; j<res.length(); j++) {
                if(res.charAt(j-1) == res.charAt(j)) {
                    count++;
                } else {
                    tmp += String.valueOf(count);
                    tmp += res.charAt(j-1);
                    count = 1;
                }
            }
            if(count > 0) {
                tmp += String.valueOf(count);
                tmp += res.charAt(res.length() - 1);
            }
            res = tmp;
        }

        return res;
    }
}
