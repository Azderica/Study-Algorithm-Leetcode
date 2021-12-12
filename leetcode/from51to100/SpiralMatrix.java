package com.myepark.leetcode.from51to100;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

  public static void ouptut(List<Integer> res) {
    for (Integer num : res) {
      System.out.print(num + " ");
    }
    System.out.println("");
  }

  public static void main(String[] args) {
    ouptut(spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));
    ouptut(spiralOrder(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}}));
    ouptut(spiralOrder(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}}));
  }

  static int[] dy = new int[]{0, 1, 0, -1};
  static int[] dx = new int[]{1, 0, -1, 0};

  public static List<Integer> spiralOrder(int[][] matrix) {
    List<Integer> res = new ArrayList<>();

    int height = matrix.length, width = matrix[0].length;
    boolean[][] visited = new boolean[height][width];
    int cur_y=0, cur_x=0, dir=0;

    res.add(matrix[cur_y][cur_x]);
    visited[cur_y][cur_x] = true;
    while(res.size() < height * width) {
      int next_y = cur_y + dy[dir];
      int next_x = cur_x + dx[dir];

      if(!isInBox(next_y, next_x, height, width) || visited[next_y][next_x]) {
        dir = (dir + 1) % 4;
        next_y = cur_y + dy[dir];
        next_x = cur_x + dx[dir];
      }

      res.add(matrix[next_y][next_x]);
      visited[next_y][next_x] = true;
      cur_y = next_y;
      cur_x = next_x;
    }

    return res;
  }

  public static boolean isInBox(int y, int x, int height, int width) {
    return y >= 0 && y < height && x >= 0 && x < width;
  }

}
