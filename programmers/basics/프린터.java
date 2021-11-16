package com.myepark.programmers.basics;

import java.util.LinkedList;
import java.util.Queue;

public class 프린터 {
    class Task {
        int location;
        int priority;
        public Task(int location, int priority) {
            this.location = location;
            this.priority = priority;
        }
    }

    public int solution(int[] priorities, int location) {
        Queue<Task> q = new LinkedList<>();
        int answer = 0, cnt = 0;

        for(int i=0; i<priorities.length; i++)
            q.add(new Task(i, priorities[i]));

        while(!q.isEmpty()) {
            Task cur = q.poll();
            boolean flag = false;
            for(Task t : q) {
                if(t.priority > cur.priority) {
                    flag = true;
                }
            }
            if(flag)
                q.add(cur);
            else {
                cnt++;
                if(cur.location == location) {
                    answer = cnt;
                    break;
                }
            }
        }
        return answer;
    }

}
