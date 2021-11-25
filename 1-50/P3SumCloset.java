package com.myepark;

import java.util.Arrays;

public class P3SumCloset {

    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
    }

    public static int threeSumClosest(int[] nums, int target) {
        int closetSum = 0, diff = Integer.MAX_VALUE;
        int start, end, curSum;

        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            start = i + 1;
            end = nums.length - 1;
            while (start < end) {
                curSum = nums[start] + nums[i] + nums[end];

                if (curSum == target)
                    return curSum;
                else if (curSum < target)
                    start++;
                else
                    end--;

                if (Math.abs(target - curSum) < diff) {
                    diff = Math.abs(target - curSum);
                    closetSum = curSum;
                }
            }
        }
        return closetSum;
    }
}
