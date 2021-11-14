package com.myepark.programmers.basics;

import java.util.HashSet;
import java.util.Set;

public class N으로표현_dp {
    public int solution(int N, int number) {
        Set<Integer>[] dp = new HashSet[9];
        int answer = -1;
        int nNumber = N;    // N으로만 이루어진 수, ex) N, NN, NNN
        for (int i = 1; i < 9; i++) {
            // N으로만 이뤄진 수를 Set에 넣어줍니다.
            dp[i] = new HashSet<>();
            dp[i].add(nNumber);
            nNumber = nNumber * 10 + N;
        }
        // 모든 가능성의 수를 의미합니다. i는 N의 갯수입니다.
        for (int i = 1; i < 9; i++) {
            for (int j = 1; j < i; j++) {
                for (Integer num1 : dp[j]) {
                    for (Integer num2 : dp[i - j]) {
                        dp[i].add(num1 + num2);
                        dp[i].add(num1 - num2);
                        dp[i].add(num2 - num1);
                        dp[i].add(num1 * num2);
                        if (num2 != 0) dp[i].add(num1 / num2);
                        if (num1 != 0) dp[i].add(num2 / num1);
                    }
                }
            }
        }
        // 정답을 만듭니다.
        for (int i = 1; i < 9; i++) {
            if (dp[i].contains(number)) {
                answer = i;
                break;
            }
        }
        return answer;
    }
}
