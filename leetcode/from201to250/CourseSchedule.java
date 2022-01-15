package com.myepark.leetcode.from201to250;

import java.util.*;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjacencyList = new ArrayList<>();
        Queue<Integer> result = new LinkedList<>();
        Queue<Integer> queue = new LinkedList<>();
        int[] indegree = new int[numCourses];

        for(int i = 0; i < numCourses; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        for(int[] courses : prerequisites) {
            int start = courses[0];
            int end = courses[1];
            adjacencyList.get(start).add(end);
            indegree[end]++;
        }

        for(int i = 0; i < numCourses; i++) {
            if(indegree[i] == 0) {
                queue.add(i);
            }
        }

        while(!queue.isEmpty()) {
            int curNode = queue.poll();
            result.add(curNode);

            for(int child : adjacencyList.get(curNode))  {
                indegree[child]--;

                if(indegree[child] == 0) {
                    queue.add(child);
                }
            }
        }
        if(result.size() == numCourses) return true;
        return false;
    }
}
