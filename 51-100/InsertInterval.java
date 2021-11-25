package com.myepark;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class InsertInterval {

  public static void output(int[][] res) {
    for (int[] line : res) {
      System.out.printf("[");
      for (int val : line) {
        System.out.printf(val + " ");
      }
      System.out.printf("] ");
    }
    System.out.println("");
  }

  public static void main(String[] args) {
    output(insert(new int[][]{{1, 3}, {6, 9}}, new int[]{2, 5}));
    output(insert(new int[][]{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}}, new int[]{4, 8}));
    output(insert(new int[][]{}, new int[]{5, 7}));
    output(insert(new int[][]{{1, 5}}, new int[]{2, 3}));
    output(insert(new int[][]{{1, 5}}, new int[]{2, 7}));
  }

  public static int[][] insert(int[][] intervals, int[] newInterval) {
    if (intervals.length == 0) {
      return new int[][]{newInterval};
    }
    List<int[]> list = new ArrayList<>();
    // check insert y/n
    boolean isValid = true;

    for (int i = 0; i < intervals.length; i++) {
      int[] nowInterval = intervals[i];
      if (!isValid || nowInterval[0] > newInterval[1]) {
        // back and front part in interval
        list.add(nowInterval);
        continue;
      }
      if (nowInterval[1] < newInterval[0]) {
        list.add(nowInterval);
      } else {
        isValid = false;
        int minLeft = Math.min(nowInterval[0], newInterval[0]);
        int maxRight = Math.max(nowInterval[1], newInterval[1]);
        for (int j = i + 1; j < intervals.length; j++) {
          i++;
          int[] nextInterval = intervals[j];
          if (nextInterval[0] > maxRight) {
            i--;
            break;
          } else {
            // merge case
            maxRight = Math.max(maxRight, nextInterval[1]);
          }
        }
        list.add(new int[]{minLeft, maxRight});
      }
    }

    // no insert case
    if (isValid) {
      list.add(newInterval);
    }

    int[][] result = list.toArray(new int[][]{new int[list.size()]});
    Arrays.sort(result, new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        return o1[0] - o2[0];
      }
    });

    return result;
  }
}
