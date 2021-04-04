package com.myepark;

public class Solution {

    public static void output(int[] res) {
        System.out.println(res[0] + ", " + res[1]);
    }

    public static void main(String[] args) {
        output(searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8));
        output(searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6));
        output(searchRange(new int[]{}, 0));
    }

    public static int[] searchRange(int[] nums, int target) {
        return new int[]{findFirst(nums, target), findLast(nums, target)};
    }

    public static int findFirst(int[] nums, int target) {
        int low = 0, high = nums.length - 1, res = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] > target)
                high = mid - 1;
            else if (nums[mid] < target)
                low = mid + 1;
            else {
                res = mid;
                high = mid - 1;
            }
        }
        return res;
    }

    public static int findLast(int[] nums, int target) {
        int low = 0, high = nums.length - 1, res = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] > target)
                high = mid - 1;
            else if (nums[mid] < target)
                low = mid + 1;
            else {
                res = mid;
                low = mid + 1;
            }
        }
        return res;
    }
}
