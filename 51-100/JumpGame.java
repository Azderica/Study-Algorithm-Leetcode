package com.myepark;

public class Solution {

  public static void main(String[] args) {
    System.out.println(canJump(new int[]{2, 3, 1, 1, 4}));
    System.out.println(canJump(new int[]{3, 2, 1, 0, 4}));
    System.out.println(canJump(new int[]{0, 1}));
    System.out.println(canJump(new int[]{0, 2, 3}));
    System.out.println(canJump(new int[]{1, 2, 3}));
    System.out.println(canJump(new int[]{0}));
  }

  public static boolean canJump(int[] nums) {
    int pos = nums.length - 1;
    for (int i = nums.length - 1; i >= 0; i--) {
      if (i + nums[i] >= pos) {
        pos = i;
      }
    }
    return pos == 0;
  }

}
