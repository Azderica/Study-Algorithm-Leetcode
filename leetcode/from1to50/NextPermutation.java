package com.myepark.leetcode.from1to50;

import java.util.Arrays;
import java.util.Collections;

public class NextPermutation {

    public static void output(int[] nums) {
        for(int val : nums)
            System.out.print(val + " ");
        System.out.println("");
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3};
        nextPermutation(a);
        output(a);

        int[] b = new int[]{3, 2, 1};
        nextPermutation(b);
        output(b);

        int[] c = new int[]{1, 1, 5};
        nextPermutation(c);
        output(c);

        int[] d = new int[]{1};
        nextPermutation(d);
        output(d);

        int[] e = new int[]{1, 3, 2};
        nextPermutation(e);
        output(e);
    }

    public static void nextPermutation(int[] nums) {
        // find first decreasing point
        int index = -1;
        for(int i = nums.length - 1; i > 0; i--) {
            if(nums[i] > nums[i - 1]) {
                index = i - 1;
                break;
            }
        }

        // if nums is dec sorted, next is asc sorted
        if (index == -1) {
            Arrays.sort(nums);
            return;
        }

        int swap_index = nums.length - 1;
        for(int i = nums.length - 1; i >= index + 1; i--){
            if(nums[i] > nums[index]) {
                swap_index = i;
                break;
            }
        }

        swap(nums, index, swap_index);

        Arrays.sort(nums, index + 1, nums.length);
    }

    public static void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
