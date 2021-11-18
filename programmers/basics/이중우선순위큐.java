package com.myepark.programmers.basics;

import java.util.Comparator;
import java.util.PriorityQueue;

public class 이중우선순위큐 {
    public int[] solution(String[] operations) {
        int[] answer = {0, 0};
        PriorityQueue<Integer> ascPq = new PriorityQueue<>();
        PriorityQueue<Integer> descPq = new PriorityQueue<>(Comparator.reverseOrder());

        for(String operation : operations) {
            String[] command = operation.split(" ");
            int val = Integer.valueOf(command[1]);
            switch (command[0]) {
                case "I" -> {
                    ascPq.add(val);
                    descPq.add(val);
                }
                case "D" -> {
                    if(!ascPq.isEmpty()) {
                        if(val == 1) {
                            int maxVal = descPq.poll();
                            ascPq.remove(maxVal);
                        } else {
                            int minVal = ascPq.poll();
                            descPq.remove(minVal);
                        }
                    }
                }
            }
        }

        // make answer
        if(!ascPq.isEmpty()) {
            answer[0] = descPq.peek();
            answer[1] = ascPq.peek();
        }
        return answer;
    }
}
