package com.myepark.programmers.basics;

import java.util.Arrays;

class 체육복 {
    public int solution(int n, int[] lost, int[] reserve) {
        int extra = 0;

        // assumption
        Arrays.sort(lost);
        Arrays.sort(reserve);

        // find user that brings clothes and lost clothes
        for (int i = 0; i < lost.length; i++)
            for (int j = 0; j < reserve.length; j++)
                if (lost[i] == reserve[j]) {
                    extra++;
                    lost[i] = -1;
                    reserve[j] = -1;
                    break;  // no duplication
                }

        // reserve clothes to adjacent friend
        for (int i = 0; i < lost.length; i++)
            for (int j = 0; j < reserve.length; j++)
                if (lost[i] == reserve[j] + 1 || lost[i] == reserve[j] - 1) {
                    extra++;
                    reserve[j] = -1;
                    break;
                }

        // make answer
        return n - lost.length + extra;
    }
}