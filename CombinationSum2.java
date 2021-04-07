package com.myepark;

import java.util.ArrayList;
import java.util.Arrays;
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
        output(combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
        output(combinationSum2(new int[]{2, 5, 2, 1, 2}, 5));
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);

        List<Integer> temp = new ArrayList<>();
        dfs(candidates, 0, target, temp, res);

        return res;
    }

    public static void dfs(int[] candidate, int index, int target, List<Integer> temp, List<List<Integer>> res) {
        if(target == 0) {
            res.add(new ArrayList(temp));
            return;
        }

        for(int i=index; i<candidate.length; i++ ){
            if(target < candidate[i])
                break;
            if(i != index && candidate[i-1] == candidate[i]) {
                continue;
            }

            temp.add(candidate[i]);
            dfs(candidate, i + 1, target - candidate[i], temp, res);
            temp.remove(temp.size() - 1);
        }
    }
}
