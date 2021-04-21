package com.myepark;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void output(List<String> req) {
        for (String val : req) {
            System.out.print(val + " ");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        output(generateParenthesis(3));
        output(generateParenthesis(1));
    }

    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        dfs(res, "", n, n);
        return res;
    }

    private static void dfs(List<String> res, String s, int left, int right) {
        // ex. ())
        if(left > right)
            return;

        if(left == 0 && right == 0) {
            res.add(s);
            return;
        }

        if(left>0) {
            dfs(res, s + "(", left - 1, right);
        }
        if(right > 0) {
            dfs(res, s + ")", left, right - 1);
        }
    }
}
