package com.myepark.leetcode.from51to100;

public class SortColors {
    public void sortColors(int[] nums) {
        // init
        int[] colors = new int[3];

        // main logic -> count sort
        for (int num : nums) {
            colors[num]++;
        }

        // make answer
        int index = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < colors[i]; j++) {
                nums[index++] = i;
            }
        }
    }
}
