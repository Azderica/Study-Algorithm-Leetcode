package com.myepark.leetcode.from1to50;

public class RotateImage {

    public static void output(int[][] res) {
        for (int[] list : res) {
            System.out.print("[");
            for (Integer val : list) {
                System.out.print(val + " ");
            }
            System.out.print("], ");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        int[][] input_1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] input_2 = {{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};

        rotate(input_1);
        rotate(input_2);

        output(input_1);
        output(input_2);
    }

    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        int[][] copy_matrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                copy_matrix[j][n - i - 1] = matrix[i][j];
            }
        }

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                matrix[i][j] = copy_matrix[i][j];

    }
}
