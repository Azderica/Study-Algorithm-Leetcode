package com.myepark;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Solution {

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
    output(merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}}));
    output(merge(new int[][]{{1, 4}, {4, 5}}));
  }

  public static int[][] merge(int[][] intervals) {
    if(intervals.length == 0) return new int[][]{};

    // Sorting intervals
    Arrays.sort(intervals, new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        if(o1[0]<o2[0]) return -1;
        else if(o1[0] == o2[0]) return 0;
        else return 1;
      }
    });

    ArrayList<int[]> list = new ArrayList<>();

    int start = intervals[0][0], end = intervals[0][1];
    for(int i=1; i<intervals.length; i++) {
      if(start<=intervals[i][0] && intervals[i][0] <=end){
        start = Math.min(start, intervals[i][0]);
        end = Math.max(end, intervals[i][1]);
      }
      else {
        list.add(new int[]{start, end});
        start = intervals[i][0];
        end = intervals[i][1];
      }
    }

    // add last interval in list
    list.add(new int[]{start, end});

    int[][] res = new int[list.size()][];
    for (int i=0; i< list.size(); i++)
      res[i] = list.get(i);

    return res;
  }

}
