package com.myepark;

public class Solution {

  public static void main(String[] args) {
    System.out.println(uniquePaths(3, 7));
    System.out.println(uniquePaths(3, 2));
    System.out.println(uniquePaths(7, 3));
    System.out.println(uniquePaths(3, 3));
  }

  public static int uniquePaths(int m, int n) {
    int[][] mem = new int[m][n];

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        mem[i][j] = -1;
      }
    }

    return helper(mem, m - 1, n - 1);
  }

  public static int helper(int[][] mem, int m, int n) {
    if (m == 0 || n == 0) {
      mem[m][n] = 1;
      return 1;
    }

    if (mem[m][n] != -1) {
      return mem[m][n];
    }

    mem[m][n] = helper(mem, m - 1, n) + helper(mem, m, n - 1);
    return mem[m][n];
  }
}
