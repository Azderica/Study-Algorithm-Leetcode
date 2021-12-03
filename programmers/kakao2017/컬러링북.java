package com.myepark.programmers.kakao2017;

import java.util.*;

public class 컬러링북 {
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, -1, 0, 1};
    private boolean[][] visited;

    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0, maxSizeOfOneArea = 0;
        visited = new boolean[m][n];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(picture[i][j] != 0 && !visited[i][j]) {
                    maxSizeOfOneArea = Math.max(bfs(i, j, m, n, picture), maxSizeOfOneArea);
                    numberOfArea++;
                }
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

    private int bfs(int startY, int startX, int m, int n, int[][] picture) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{startY, startX});
        int count = 1;
        visited[startY][startX] = true;
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int curY = cur[0];
            int curX = cur[1];
            for(int dir = 0; dir < 4; dir++) {
                int nextY = curY + dy[dir];
                int nextX = curX + dx[dir];
                if(isInbound(nextY, nextX, m, n) && picture[nextY][nextX] != 0 && !visited[nextY][nextX] && picture[curY][curX] == picture[nextY][nextX]) {
                    q.add(new int[]{nextY, nextX});
                    visited[nextY][nextX] = true;
                    count++;
                }
            }
        }
        return count;
    }

    private boolean isInbound(int nextY, int nextX, int m, int n) {
        return nextY >= 0 && nextY < m && nextX >= 0 && nextX < n;
    }
}
