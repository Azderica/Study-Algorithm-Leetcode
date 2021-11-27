package com.myepark;

import java.util.*;

public class MeetingRooms2 {
    public int minMeetingRooms(int[][] intervals) {
        int rooms = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        Arrays.sort(intervals, Comparator.comparing((int[] itv) -> itv[0]));
        for(int[] itv : intervals) {
            if(pq.isEmpty()) {
                rooms++;
                pq.add(itv[1]);
            } else {
                if(itv[0] >= pq.peek()) {
                    pq.poll();
                } else {
                    rooms++;
                }
                pq.add(itv[1]);
            }
        }
        return rooms;
    }
}
