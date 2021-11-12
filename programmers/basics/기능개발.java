package com.myepark.programmers.basics;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class 기능개발 {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer;
        Queue<Integer> taskQueue = new LinkedList<>();

        // insert workday in queue
        for(int i=0; i<progresses.length; i++) {
            taskQueue.add(getWorkday(progresses[i], speeds[i]));
        }

        answer = getWorkdayAsc(taskQueue);
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    public int getWorkday(int progress, int speed) {
        if((100 - progress) % speed == 0)
            return (100 - progress) / speed;
        return (100 - progress) / speed + 1;
    }

    public List<Integer> getWorkdayAsc(Queue<Integer> taskQueue) {
        List<Integer> employeeCountList = new ArrayList<>();
        int max_num = taskQueue.poll();
        int count = 1;
        while (!taskQueue.isEmpty()) {
            int item = taskQueue.poll();
            if(max_num < item) {
                employeeCountList.add(count);
                count = 1;
                max_num = item;
            } else {
                count++;
            }
        }
        employeeCountList.add(count);
        return employeeCountList;
    }
}