package com.myepark.programmers.basics;

import java.util.*;

class 더맵게 {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        Queue<Integer> scovillePq = new PriorityQueue<>();
        for (int score : scoville)
            scovillePq.add(score);

        while(scovillePq.peek() < K) {
            // end state
            if(scovillePq.size() < 2) {
                return -1;
            }
            answer++;
            int newScoville = scovillePq.poll() + scovillePq.poll() * 2;
            scovillePq.add(newScoville);
        }

        return answer;
    }
}