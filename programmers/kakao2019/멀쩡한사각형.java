package com.myepark.programmers.kakao2019;

public class 멀쩡한사각형 {
    public long solution(int w, int h) {
        long answer = 0;
        if(w == h) {
            answer = (long) w * h - w;
        } else {
            int m = gcd(w, h);
            answer = (long) w * h - m * (w / m + h / m - 1);
        }
        return answer;
    }

    private int gcd(int a, int b) {
        while(b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
}
