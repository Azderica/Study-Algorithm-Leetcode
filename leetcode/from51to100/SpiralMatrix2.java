package com.myepark.leetcode.from51to100;

public class SpiralMatrix2 {

  public static void output(int[][] res) {
    for(int[] list : res) {
      for(int element : list) {
        System.out.print(element + " ");
      }
      System.out.println("");
    }
    System.out.println("");
  }

  public static void main(String[] args) {
    output(generateMatrix(3));
    output(generateMatrix(4));
    output(generateMatrix(1));
  }

  static int[] dy = {0, 1, 0, -1};
  static int[] dx = {1, 0, -1, 0};

  public static int[][] generateMatrix(int n) {
    int[][] res = new int[n][n];
    int cur_y = 0, cur_x = 0, dir = 0;

    for(int i=0; i<n*n; i++) {
      res[cur_y][cur_x] = i + 1;
      int next_y = cur_y + dy[dir];
      int next_x = cur_x + dx[dir];
      if(isInBox(next_y, next_x, n) && isVisited(next_y, next_x, res)) {
        cur_y = next_y;
        cur_x = next_x;
      } else {
        dir = (dir + 1) % 4;
        cur_y = cur_y + dy[dir];
        cur_x = cur_x + dx[dir];
      }
    }
    return res;
  }

  public static boolean isInBox(int y, int x, int n) {
    return y >= 0 && y < n && x >= 0 && x < n;
  }

  public static boolean isVisited(int y, int x, int[][] res) {
    return res[y][x] == 0;
  }
}
