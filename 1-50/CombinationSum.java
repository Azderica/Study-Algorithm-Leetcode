package com.myepark;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void output(List<List<Integer>> res) {
        for (int i = 0; i < res.size(); i++) {
            System.out.print("[ ");
            for (int num : res.get(i)) {
                System.out.print(num + " ");
            }
            System.out.print("], ");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        output(combinationSum(new int[]{2, 3, 6, 7}, 7));
        output(combinationSum(new int[]{2, 3, 5}, 8));
        output(combinationSum(new int[]{2}, 1));
        output(combinationSum(new int[]{1}, 1));
        output(combinationSum(new int[]{1}, 2));
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < candidates.length; i++) {
            List<Integer> temp = new ArrayList<>();
            temp.add(candidates[i]);
            if(target >= candidates[i]) {
                backtracking(candidates, i, 1, target - candidates[i], temp, res);
            }
        }

        return res;
    }

    public static void backtracking(int[] candidates, int index, int tempSize, int target, List<Integer> temp, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList(temp));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            if (candidates[i] <= target) {
                temp.add(candidates[i]);
                backtracking(candidates, i, tempSize + 1, target - candidates[i], temp, res);
                temp.remove(tempSize);
            }
        }
    }
}
