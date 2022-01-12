package com.myepark.leetcode.from51to100;

import java.util.*;

public class WordSerach {
    private static int[] dy = {0, 1, 0, -1};
    private static int[] dx = {1, 0, -1, 0};

    public boolean exist(char[][] board, String word) {
        // initialize
        Queue<Pos> q = new LinkedList<>();

        // input start point to queue
        setStartPosition(board, word.charAt(0), q);

        // find valid path;
        while(!q.isEmpty()) {
            Pos start = q.poll();
            boolean[][] visited = new boolean[board.length][board[0].length];
            visited[start.y][start.x] = true;
            if(isSameWord(board, visited, start, word)) {
                return true;
            }
            visited[start.y][start.x] = false;
        }

        // no mathing word, return false;
        return false;
    }

    private void setStartPosition(char[][] board, char startKey, Queue<Pos> q) {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j] == startKey) {
                    q.add(new Pos(i, j, 0));
                }
            }
        }
    }

    private boolean isSameWord(char[][] board, boolean[][] visited, Pos cur, String word) {
        // end state
        if(cur.index == word.length() - 1)
            return true;

        for(int dir = 0; dir < 4; dir++) {
            int nextY = cur.y + dy[dir];
            int nextX = cur.x + dx[dir];
            int nextIndex = cur.index + 1;
            if(isValidPos(board, nextY, nextX) && !visited[nextY][nextX]) {
                if(word.charAt(nextIndex) == board[nextY][nextX]) {
                    visited[nextY][nextX] = true;
                    if(isSameWord(board, visited, new Pos(nextY, nextX, nextIndex), word)) return true;
                    visited[nextY][nextX] = false;
                }
            }
        }
        return false;
    }


    private boolean isValidPos(char[][] board, int y, int x) {
        return y >= 0 && y < board.length && x >= 0 && x < board[0].length;
    }

    class Pos {
        int y;
        int x;
        int index;
        Pos(int y, int x, int index) {
            this.y = y;
            this.x = x;
            this.index = index;
        }
    }
}
