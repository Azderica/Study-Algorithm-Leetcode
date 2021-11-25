package com.myepark;

import java.util.Arrays;

public class ValidSudoku {

    public static void main(String[] args) {
        char[][] input_1 =
                {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}
                        , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                        , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                        , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                        , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                        , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                        , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                        , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                        , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

        char[][] input_2 =
                {{'8', '3', '.', '.', '7', '.', '.', '.', '.'}
                        , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                        , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                        , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                        , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                        , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                        , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                        , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                        , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};


        System.out.println(isValidSudoku(input_1));
        System.out.println(isValidSudoku(input_2));
    }

    public static boolean isValidSudoku(char[][] board) {
        boolean[] visited = new boolean[9];

        if (board == null || board.length != 9 || board[0].length != 9)
            return false;

        // check column
        for (int i = 0; i < 9; i++) {
            Arrays.fill(visited, false);
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    if (visited[board[i][j] - '1'])
                        return false;
                    visited[board[i][j] - '1'] = true;
                }
            }
        }

        // check row
        for (int j = 0; j < 9; j++) {
            Arrays.fill(visited, false);
            for (int i = 0; i < 9; i++) {
                if (board[i][j] != '.') {
                    if (visited[board[i][j] - '1'])
                        return false;
                    visited[board[i][j] - '1'] = true;
                }
            }
        }

        // check box
        for (int block = 0; block < 9; block++) {
            Arrays.fill(visited, false);
            for (int i = block / 3 * 3; i < block / 3 * 3 + 3; i++) {
                for (int j = block % 3 * 3; j < block % 3 * 3 + 3; j++) {
                    if (board[i][j] != '.') {
                        if (visited[board[i][j] - '1'])
                            return false;
                        visited[board[i][j] - '1'] = true;
                    }
                }
            }
        }

        return true;
    }
}
