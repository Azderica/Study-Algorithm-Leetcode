package com.myepark;

import java.util.*;

public class MissingRanges {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> answer = new ArrayList<>();

        if(nums.length == 0) {
            answer.add(makeRange(lower, upper));
            return answer;
        }

        if(lower < nums[0]) answer.add(makeRange(lower, nums[0] - 1));
        for(int i=0; i<nums.length - 1; i++) {
            if(nums[i] + 1 <= nums[i + 1] - 1)
                answer.add(makeRange(nums[i] + 1, nums[i + 1] - 1));
        }
        if(nums[nums.length - 1] < upper) answer.add(makeRange(nums[nums.length - 1] + 1, upper));
        return answer;
    }

    private String makeRange(int from, int to) {
        if(from == to)
            return Integer.toString(from);
        return (from + "->" + to);
    }
}
