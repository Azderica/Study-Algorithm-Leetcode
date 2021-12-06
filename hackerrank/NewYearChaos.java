package com.myepark.hackerrank;

import java.util.List;

public class NewYearChaos {
    public static void minimumBribes(List<Integer> q) {
        boolean isChaotic = false;
        int bribes = 0;
        int[] mins = new int[]{q.size(), q.size()};

        for(int i = q.size() - 1; i >= 0; i--) {
            int pos = i + 1;
            if(q.get(i) - pos > 2) {
                System.out.println("Too chaotic");
                return;
            } else if(q.get(i) > mins[1]) {
                bribes += 2;
            } else if(q.get(i) > mins[0]) {
                bribes += 1;
            }

            // min[] is {1st small, 2nd small}
            if(q.get(i) < mins[0]) {
                mins[1] = mins[0];
                mins[0] = q.get(i);
            } else if(q.get(i) < mins[1]) {
                mins[1] = q.get(i);
            }
        }

        System.out.println(bribes);
    }
}
