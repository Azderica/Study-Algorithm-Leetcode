package com.myepark.hackerrank;

public class TimeConversion {
    public static String timeConversion(String s) {
        StringBuilder sb = new StringBuilder("");
        int hh = Integer.valueOf(s.substring(0, 2));
        if(s.contains("PM")) {
            if(hh < 12) hh += 12;
        } else {
            if(hh >= 12) hh -= 12;
        }
        if(hh >= 10)
            sb.append(hh);
        else
            sb.append("0").append(hh);
        sb.append(s.substring(2, s.length() - 2));
        return sb.toString();
    }
}
