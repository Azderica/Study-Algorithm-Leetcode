package com.myepark.leetcode.from1to50;

public class ContainerWithMostWater {

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
        System.out.println(maxArea(new int[]{1, 1}));
        System.out.println(maxArea(new int[]{4, 3, 2, 1, 4}));
        System.out.println(maxArea(new int[]{1, 2, 1}));
    }

    public static int maxArea(int[] height) {
        int res = 0, tmp = 0;
        int len = height.length;

        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                tmp = Math.min(height[i], height[j]) * (j - i);
                if(res < tmp)
                    res = tmp;
            }
        }

        return res;
    }
}
