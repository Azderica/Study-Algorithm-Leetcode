package com.myepark.leetcode.from1to50;

public class MultiplyStrings {

    public static void main(String[] args) {
        System.out.println(multiply("2", "3"));
        System.out.println(multiply("123", "456"));
    }

    public static String multiply(String num1, String num2) {
        StringBuilder res = new StringBuilder();
        String n1 = new StringBuilder(num1).reverse().toString();
        String n2 = new StringBuilder(num2).reverse().toString();

        int[] value = new int[(n1.length() + n2.length())];

        // multiply each number and sum in position
        for(int i=0; i<n1.length(); i++) {
            for(int j=0; j<n2.length(); j++) {
                value[i+j] += (n1.charAt(i) - '0') * (n2.charAt(j) - '0');
            }
        }

        // calculate and make to string
        for(int i=0; i<value.length; i++) {
            int mod = value[i] % 10;
            int carry = value[i] / 10;
            if(i + 1 < value.length) {
                value[i+1] += carry;
            }
            res.insert(0, mod);
        }

        // remove front '0'
        while(res.charAt(0) == '0' && res.length() > 1) {
            res.deleteCharAt(0);
        }

        return res.toString();
    }
}
