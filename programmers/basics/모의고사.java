package com.myepark.programmers.basics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class 모의고사 {
    public int[] solution(int[] answers) {
        // declare
        int[] user1_pattern = new int[]{1, 2, 3, 4, 5};
        int[] user2_pattern = new int[]{2, 1, 2, 3, 2, 4, 2, 5};
        int[] user3_pattern = new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int[] scores = new int[]{0, 0, 0};
        List<Integer> winner = new ArrayList<>();

        // main logic
        for (int i = 0; i < answers.length; i++) {
            if (user1_pattern[i % user1_pattern.length] == answers[i])
                scores[0]++;
            if (user2_pattern[i % user2_pattern.length] == answers[i])
                scores[1]++;
            if (user3_pattern[i % user3_pattern.length] == answers[i])
                scores[2]++;
        }

        // make answer
        int max_value = Arrays.stream(scores).max().getAsInt();
        for (int i = 0; i < scores.length; i++)
            if (scores[i] == max_value)
                winner.add(i + 1);
        return winner.stream().mapToInt(Integer::intValue).toArray();
    }
}