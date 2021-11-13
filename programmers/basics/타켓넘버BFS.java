package com.myepark.programmers.basics;

import java.util.LinkedList;
import java.util.Queue;

public class 타켓넘버BFS {
    class Pair {
        int cur;
        int index;

        Pair(int cur, int index) {
            this.cur = cur;
            this.index = index;
        }
    }

    public int solution(int[] numbers, int target) {
        int answer = 0;
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(numbers[0], 0));
        queue.add(new Pair(-numbers[0], 0));

        while (!queue.isEmpty()) {
            Pair p = queue.poll();
            if (p.index == numbers.length - 1) {
                if (p.cur == target)
                    answer++;
                continue;
            }
            queue.add(new Pair(p.cur + numbers[p.index + 1], p.index + 1));
            queue.add(new Pair(p.cur - numbers[p.index + 1], p.index + 1));
        }

        return answer;
    }
}