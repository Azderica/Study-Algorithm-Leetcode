package com.myepark.programmers.basics;

public class 큰수만들기 {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        int index = 0, max = 0, len = number.length();

        for (int i = 0; i < len - k; i++) {
            max = 0;
            for (int j = index; j <= k + i; j++) {
                if (max < number.charAt(j) - '0') {
                    max = number.charAt(j) - '0';
                    index = j + 1;
                }
            }
            sb.append(max);
        }
        return sb.toString();
    }
}
