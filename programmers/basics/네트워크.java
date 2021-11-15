package com.myepark.programmers.basics;

public class 네트워크 {
    public boolean[] visited;

    public int solution(int n, int[][] computers) {
        // 초기화
        int answer = 0;
        visited = new boolean[n];

        // 덩어리별로 개수 탐색
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, computers);
                answer++;
            }
        }

        return answer;
    }

    private void dfs(int i, int[][] computers) {
        visited[i] = true;
        for(int j=0; j<computers.length; j++) {
            if(i != j && computers[i][j] == 1 && !visited[j]) {
                dfs(j, computers);
            }
        }
    }
}
