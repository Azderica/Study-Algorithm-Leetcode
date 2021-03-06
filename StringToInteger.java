package com.myepark;

public class Solution {

    public static void main(String[] args) {
        System.out.println(myAtoi("42"));
        System.out.println(myAtoi("   -42"));
        System.out.println(myAtoi("4193 with words"));
        System.out.println(myAtoi("words and 987"));
        System.out.println(myAtoi("-91283472332"));
        System.out.println(myAtoi("-+12"));
        System.out.println(myAtoi(""));
        System.out.println(myAtoi(" "));
        System.out.println(myAtoi("-"));
        System.out.println(myAtoi("+1"));
        System.out.println(myAtoi("   -5  47"));
    }

    public static int myAtoi(String s) {
        int res = 0;
        String str_num = s;

        for(int start_index = 0; start_index < s.length(); start_index++) {
            if(s.charAt(start_index) != ' ') {
                str_num = s.substring(start_index);
                break;
            }
        }

        // end state : length is 0
        if(str_num.contains(" ")){
            str_num = str_num.substring(0, str_num.indexOf(' '));
        }
        if(str_num.length() == 0)
            return 0;

        // get Number
        if (str_num.charAt(0) == '-') {
            res = getNumberInString(1, str_num, true);
        } else if (str_num.charAt(0) == '+') {
            res = getNumberInString(1, str_num, false);
        } else if (isDigit(str_num.charAt(0))) {
            res = getNumberInString(0, str_num, false);
        }
        return res;
    }

    public static int getNumberInString(int start_index, String req, boolean isNegative) {
        int end_index = start_index;
        int res = 0;
        String num;

        if(req.length() - start_index == 0 || !isDigit(req.charAt(start_index))) {
            return 0;
        }

        while (end_index < req.length() && isDigit(req.charAt(end_index))) {
            end_index++;
        }

        num = req.substring(start_index, end_index);
        try {
            res = Integer.valueOf(num);
            if (isNegative)
                res *= -1;
        } catch (NumberFormatException e) {
            if (isNegative) {
                res = Integer.MIN_VALUE;
            } else {
                res = Integer.MAX_VALUE;
            }
        }
        return res;
    }

    public static boolean isDigit(char key) {
        return key >= '0' && key <= '9';
    }
}
