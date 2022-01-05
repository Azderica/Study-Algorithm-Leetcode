package com.myepark.leetcode.from51to100;

import java.util.*;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        // initial
        List<List<Integer>> answer = new ArrayList<>();

        // main logic
        dfs(nums, answer, new ArrayList<>(), 0)    ;

        // then
        return answer;
    }

    private void dfs(int[] nums, List<List<Integer>> answer, List<Integer> list, int start) {
        answer.add(new ArrayList<>(list));

        for(int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            dfs(nums, answer, list, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
