package com.myepark.leetcode.from251to300;

import java.util.*;

public class WallsAndGates {
    class Room {
        int y;
        int x;
        int distance;
        Room(int y, int x, int distance) {
            this.y = y;
            this.x = x;
            this.distance = distance;
        }
    }

    public void wallsAndGates(int[][] rooms) {
        final int[] dx = {-1, 0, 1, 0};
        final int[] dy = {0, -1, 0, 1};

        int m = rooms.length, n = rooms[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<Room> q = new LinkedList<>();

        // initialize q
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(rooms[i][j] == 0) {
                    q.add(new Room(i, j, 0));
                    visited[i][j] = true;
                }
            }
        }

        // find answer with room
        while(true) {
            Queue<Room> tmp = new LinkedList<>();   // temporary queue
            while(!q.isEmpty()) {
                Room cur = q.poll();
                for(int dir = 0; dir < 4; dir++) {
                    int nextY = cur.y + dy[dir];
                    int nextX = cur.x + dx[dir];

                    if(isValid(nextY, nextX, rooms)) {
                        if(!visited[nextY][nextX]) {
                            rooms[nextY][nextX] = cur.distance + 1;
                            visited[nextY][nextX] = true;
                            tmp.add(new Room(nextY, nextX, cur.distance + 1));
                        }
                    }
                }
            }
            // if no change, break;
            if(tmp.isEmpty()) break;
            q.addAll(tmp);
        }

        // check answer;
        // for(int i = 0; i < m; i++) {
        //     for(int j = 0; j < n; j++) {
        //         System.out.print(rooms[i][j] + " ");
        //     }
        //     System.out.println("");
        // }
    }

    private boolean isValid(int y, int x, int[][] rooms) {
        if(y >= 0 && y < rooms.length && x >= 0 && x < rooms[0].length) {
            return rooms[y][x] != -1;
        }
        return false;
    }
}
