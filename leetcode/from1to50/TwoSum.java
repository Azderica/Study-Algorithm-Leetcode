package com.myepark.leetcode.from1to50;

import java.util.*;

public class TwoSum {
    /* Time Complexity = T(n) + T(nlog(n)) + T(n/2) */
    public int[] twoSum(int[] nums, int target) {
        // initialize
        int start = 0, end = nums.length - 1;
        List<Pos> list = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            list.add(new Pos(i, nums[i]));
        }

        // solution
        Collections.sort(list, (a, b) -> a.getValue() - b.getValue());
        while(start < end) {
            int temp = list.get(start).getValue() + list.get(end).getValue();
            if(temp == target) {
                break;
            } else if (temp < target) {
                start++;
            } else {
                end--;
            }
        }

        // return answer
        int[] answer;
        if(list.get(start).getIndex() < list.get(end).getIndex()) {
            answer = new int[]{list.get(start).getIndex(), list.get(end).getIndex()};
        } else {
            answer = new int[]{list.get(end).getIndex(), list.get(start).getIndex()};
        }
        return answer;
    }

    public class Pos {
        int index;
        int value;
        public Pos(int index, int value) {
            this.index = index;
            this.value = value;
        }

        public int getIndex() {
            return index;
        }

        public int getValue() {
            return value;
        }
    }
}
