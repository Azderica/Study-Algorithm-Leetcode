package com.myepark.leetcode.from1to50;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

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
        output(permute(new int[]{1, 2, 3}));
        output(permute(new int[]{0, 1}));
        output(permute(new int[]{1}));
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] visit = new boolean[nums.length];

        permutation(res, new ArrayList<Integer>(), visit, nums);

        return res;
    }

    public static void permutation(List<List<Integer>> res, ArrayList<Integer> list, boolean[] visit, int[] nums) {
        if(list.size() == nums.length) {
            res.add(new ArrayList<Integer>(list));
            return;
        }

        for(int i=0; i< nums.length; i++) {
            if(visit[i])
                continue;
            visit[i] = true;
            list.add(nums[i]);
            permutation(res, list, visit, nums);
            list.remove(list.size() - 1);
            visit[i] = false;
        }
    }
}
