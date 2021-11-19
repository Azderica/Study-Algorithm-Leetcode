package com.myepark.programmers.basics;

public class 도둑질 {
    public int solution(int[] money) {
        int size = money.length;
        int[] dp_1 = new int[size];
        int[] dp_2 = new int[size];

        dp_1[0] = money[0];
        dp_1[1] = money[0];
        dp_2[1] = money[1];

        for (int i = 2; i < size; i++) {
            dp_1[i] = Math.max(dp_1[i - 1], dp_1[i - 2] + money[i]);
            dp_2[i] = Math.max(dp_2[i - 1], dp_2[i - 2] + money[i]);
        }

        return Math.max(dp_1[size - 2], dp_2[size - 1]);
    }
}
