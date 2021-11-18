package com.myepark.programmers.basics;

import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class 디스크컨트롤러 {
    class Job {
        int start;
        int time;

        public Job(int start, int time) {
            this.start = start;
            this.time = time;
        }
    }

    public int solution(int[][] jobs) {
        int total = 0, cnt = 0, cur;
        LinkedList<Job> waiting = new LinkedList<>();
        PriorityQueue<Job> pq = new PriorityQueue<>((j1, j2) -> j1.time - j2.time);

        // insert data and sort with start time
        for (int[] job : jobs) {
            waiting.add(new Job(job[0], job[1]));
        }
        Collections.sort(waiting, (j1, j2) -> j1.start - j2.start);

        // loop in the queue if job can start and has any waiting list
        cur = waiting.peek().start;
        while (cnt < jobs.length) {
            while (!waiting.isEmpty() && waiting.peek().start <= cur) {
                pq.add(waiting.pollFirst());
            }
            if (!pq.isEmpty()) {
                Job job = pq.poll();
                cur += job.time;
                total += cur - job.start;
                cnt++;
            } else {
                cur++;
            }
        }

        return total / cnt;
    }
}
