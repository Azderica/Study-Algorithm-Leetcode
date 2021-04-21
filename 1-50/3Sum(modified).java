package com.myepark;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {

    public static void output(List<List<Integer>> req) {
        for (List<Integer> row : req) {
            System.out.print("[ ");
            for (Integer val : row) {
                System.out.print(val + " ");
            }
            System.out.print("], ");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        output(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        output(threeSum(new int[]{}));
        output(threeSum(new int[]{0}));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int tmp;

        // end state
        if (nums.length < 3)
            return Collections.emptyList();

        int[] sorted_nums = Arrays.stream(nums).sorted().toArray();

        for (int j = 1; j < sorted_nums.length - 1; j++) {
            int i = 0;
            int k = sorted_nums.length - 1;

            while (i < j && j < k) {
                if(sorted_nums[i] + sorted_nums[j] > 0 || sorted_nums[j] + sorted_nums[k] < 0)
                    break;

                tmp = sorted_nums[i] + sorted_nums[j] + sorted_nums[k];

                if (tmp == 0) {
                    List<Integer> line = new ArrayList<Integer>(3);
                    line.add(sorted_nums[i]);
                    line.add(sorted_nums[j]);
                    line.add(sorted_nums[k]);
                    if (!res.contains(line))
                        res.add(line);
                    i++;
                    k--;
                } else if (tmp > 0) {
                    k--;
                } else {
                    i++;
                }
            }
        }

        // if res is null, return empty list
        if (res.size() == 0)
            return Collections.emptyList();

        return res;
    }
}
