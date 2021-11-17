package com.myepark.programmers.basics;

import java.util.LinkedList;
import java.util.Queue;

public class 다리를지나는트럭 {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = bridge_length;
        int cur_weight = 0;
        Queue<Integer> q = new LinkedList<>();

        for (int truck_weight : truck_weights) {
            while (true) {
                if(q.isEmpty()) {                           // case 1. 다리 위에 트럭이 없는 경우
                    q.add(truck_weight);
                    cur_weight += truck_weight;
                    answer++;
                    break;
                } else if(q.size() == bridge_length) {      // case 2. 다리가 가득찬 경우
                    cur_weight -= q.poll();
                } else {
                    if(cur_weight + truck_weight > weight) {// case 3. 다리 무게가 다 찬 경우
                        q.add(0);
                        answer++;
                    } else {                                // case 4. 다리 무게가 덜 찬 경우
                        q.add(truck_weight);
                        cur_weight += truck_weight;
                        answer++;
                        break;
                    }
                }
            }
        }
        return answer;
    }
}
