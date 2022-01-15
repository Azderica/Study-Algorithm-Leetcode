package com.myepark.leetcode.from151to200;

import java.util.*;

public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        // initialize
        int numberOfIsland = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        // main logic
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1' && !visited[i][j]) {
                    // if it is island and first time.
                    bfs(i, j, grid, visited);
                    numberOfIsland++;
                }
            }
        }

        return numberOfIsland;
    }

    private void bfs(int startY, int startX, char[][] grid, boolean[][] visited) {
        Queue<Pos> q = new LinkedList<>();
        int[] dy = {1, 0, -1, 0};
        int[] dx = {0, 1, 0, -1};

        q.add(new Pos(startY, startX));
        visited[startY][startX] = true;
        while(!q.isEmpty()) {
            Pos tmp = q.poll();
            int curY = tmp.y;
            int curX = tmp.x;
            for(int dir = 0; dir < 4; dir++) {
                int nextY = curY + dy[dir];
                int nextX = curX + dx[dir];
                if(isInBoard(nextY, nextX, grid.length, grid[0].length) && !visited[nextY][nextX] && grid[nextY][nextX] == '1') {
                    q.add(new Pos(nextY, nextX));
                    visited[nextY][nextX] = true;
                }
            }
        }
    }

    private boolean isInBoard(int y, int x, int m, int n) {
        return y >= 0 && y < m && x >= 0 && x < n;
    }

    class Pos {
        int y;
        int x;
        Pos(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
