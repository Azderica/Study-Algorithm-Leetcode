package com.myepark.leetcode.from1to50;

public class IntegerToRoman {

    public static void main(String[] args) {
        System.out.println(intToRoman(3));
        System.out.println(intToRoman(4));
        System.out.println(intToRoman(9));
        System.out.println(intToRoman(58));
        System.out.println(intToRoman(1994));
        System.out.println(intToRoman(100));
    }

    public static String intToRoman(int num) {
        String res = "";
        String s_num = String.valueOf(num);
        int len = s_num.length();

        for(int i=0; i<len; i++){
            res = res.concat(getRomanNumToString(s_num.charAt(i) - '0', len - i - 1));
        }

        return res;
    }

    public static String getRomanNumToString(int num, int pos) {
        String res = "";
        String[] roman_key_1 = {"I", "X", "C", "M"};
        String[] roman_key_2 = {"V", "L", "D"};

        switch (num){
            case 0:
                break;
            case 1:
            case 2:
            case 3:
                for(int i=0; i<num; i++)
                    res = res.concat(roman_key_1[pos]);
                break;
            case 4:
                res = res.concat(roman_key_1[pos]).concat(roman_key_2[pos]);
                break;
            case 5:
                res = res.concat(roman_key_2[pos]);
                break;
            case 6:
            case 7:
            case 8:
                res = res.concat(roman_key_2[pos]);
                for(int i=0; i<num - 5; i++)
                    res = res.concat(roman_key_1[pos]);
                break;
            case 9:
                res = res.concat(roman_key_1[pos]).concat(roman_key_1[pos + 1]);
                break;
        }

        return res;
    }

}
