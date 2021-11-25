package com.myepark;

public class JumpGame2 {

    public static void main(String[] args) {
        System.out.println(jump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(jump(new int[]{2, 3, 0, 1, 4}));
    }

    public static int jump(int[] nums) {
        int[] count = new int[nums.length];

        for(int i=0; i<nums.length; i++) {
            for(int j=1; j<=nums[i]; j++) {
                if(i + j < nums.length) {
                    if(count[i+j] == 0)
                        count[i + j] = count[i] + 1;
                    else
                        continue;
                }
            }
        }

//        for(int val : count)
//            System.out.print(val + " ");
//        System.out.println("");

        return count[nums.length - 1];
    }
}
