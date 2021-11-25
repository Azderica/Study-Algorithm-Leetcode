package com.myepark;

import java.util.*;

public class LetterCombinationsOfAPhoneNumber {

    public static void output(List<String> req) {
        for (String val : req) {
            System.out.print(val + " ");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        output(letterCombinations("23"));
        output(letterCombinations(""));
        output(letterCombinations("2"));
    }

    static final String[] board = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public static List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();

        // end state
        if(digits.length() == 0)
            return res;

        combination("", digits, 0, res);

        return res;
    }

    public static void combination(String val, String digits, int length, List<String> res) {
        if(length >= digits.length()){
            res.add(val);
            return;
        }
        String letters = board[digits.charAt(length) - '0'];
        for(int i = 0; i<letters.length(); i++) {
            combination(val + letters.charAt(i), digits, length + 1, res);
        }
    }
}
