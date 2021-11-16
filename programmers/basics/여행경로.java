package com.myepark.programmers.basics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 여행경로 {
    boolean[] visited;
    List<String> paths;
    static final String START = "ICN";

    public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];
        paths = new ArrayList<String>();
        int count = 0;

        dfs(count, START, START, tickets);
        Collections.sort(paths);
        return paths.get(0).split(" ");
    }

    public void dfs(int count, String cur, String result, String[][] tickets) {
        if (count == tickets.length) {
            paths.add(result);
            return;
        }
        for (int i = 0; i < tickets.length; i++) {
            if (!visited[i] && tickets[i][0].equals(cur)) {
                visited[i] = true;
                dfs(count + 1, tickets[i][1], result + " " + tickets[i][1], tickets);
                visited[i] = false;
            }
        }
    }
}
