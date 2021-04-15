package com.myepark;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public static void output(List<List<Integer>> res) {
        for(List<Integer> list : res) {
            System.out.print("[");
            for(Integer val : list) {
                System.out.print(val + " ");
            }
            System.out.print("], ");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        output(permuteUnique(new int[]{1, 1, 2}));
        output(permuteUnique(new int[]{1, 2, 3}));
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];

        Arrays.sort(nums);
        dfs(res, new ArrayList<Integer>(), visited, nums);

        return res;
    }

    private static void dfs(List<List<Integer>> res, List<Integer> list, boolean[] visited, int[] nums) {
        if(list.size() == nums.length) {
            res.add(new ArrayList<Integer>(list));
            return;
        }

        for(int i=0; i<nums.length; i++) {
            if(visited[i] == true) continue;
            if(i == 0 || nums[i] != nums[i - 1] || (nums[i] == nums[i - 1] && visited[i - 1])) {
                visited[i] = true;
                list.add(nums[i]);
                dfs(res, list, visited, nums);
                list.remove(list.size() - 1);
                visited[i] = false;
            }
        }
    }
}
