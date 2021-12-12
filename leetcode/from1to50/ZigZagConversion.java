package com.myepark.leetcode.from1to50;

public class ZigZagConversion {

    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 3));
        System.out.println(convert("PAYPALISHIRING", 4));
        System.out.println(convert("A", 1));
        System.out.println(convert("AB", 1));
    }

    public static String convert(String s, int numRows) {
        int len = s.length();
        int cur_y = 0, cur_x = 0;
        boolean dir = true;    // true is down, false is left + up
        String res = "";
        char[][] arr = new char[numRows][len];

        if(len < numRows || numRows <= 1)
            return s;

        for(int i=0; i<len; i++) {
            // input value
            arr[cur_y][cur_x] = s.charAt(i);

            // move next position
            if(dir) {
                cur_y++;
                if(cur_y == numRows - 1) {
                    dir = false;
                }
            } else {
                cur_x++;
                cur_y--;
                if(cur_y == 0) {
                    dir = true;
                }
            }
        }

        // add value
        for(int i=0; i<numRows; i++)
            for(int j=0; j<=cur_x; j++)
                if(arr[i][j] != '\u0000')
                    res = res.concat(String.valueOf(arr[i][j]));

        return res;
    }
}
