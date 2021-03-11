package com.myepark;

public class Solution {

    public static void main(String[] args) {
        System.out.println(reverse(123));
        System.out.println(reverse(-123));
        System.out.println(reverse(120));
        System.out.println(reverse(0));
        System.out.println(reverse(1534236469));
    }

    public static int reverse(int x) {
        int res = 0;
        boolean isNegative = x < 0;

        try {
            if(isNegative){
                res = Integer.valueOf(new StringBuffer(String.valueOf(x * -1)).reverse().toString()) * -1;
            } else {
                res = Integer.valueOf(new StringBuffer(String.valueOf(x)).reverse().toString());
            }
        } catch (NumberFormatException e) {
            res = 0;
        }
        return res;
    }
}
