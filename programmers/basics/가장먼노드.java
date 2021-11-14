package com.myepark.programmers.basics;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class 가장먼노드 {
    public int solution(int n, int[][] edge) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        boolean[] visited = new boolean[n + 1];
        connectEdge(graph, n, edge);
        return bfs(graph, visited);
    }

    public void connectEdge(ArrayList<ArrayList<Integer>> graph, int n, int[][] edge) {
        for (int i = 0; i <= n; i++)
            graph.add(i, new ArrayList<>());
        for (int i = 0; i < edge.length; i++) {
            graph.get(edge[i][0]).add(edge[i][1]);
            graph.get(edge[i][1]).add(edge[i][0]);
        }
    }

    public int bfs(ArrayList<ArrayList<Integer>> graph, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited[1] = true;

        int answer = 0;
        while(true) {
            Queue<Integer> tmp = new LinkedList<>();
            while(!queue.isEmpty()) {
                int cur = queue.poll();
                for(int adj : graph.get(cur)) {
                    if(!visited[adj]) {
                        tmp.add(adj);
                        visited[adj] = true;
                    }
                }
            }
            // 종료조건
            if(tmp.isEmpty()) break;
            queue.addAll(tmp);
            answer = tmp.size();
        }
        return answer;
    }
}
