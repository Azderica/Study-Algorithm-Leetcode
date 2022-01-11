package com.myepark.leetcode.from1to50;

import java.util.*;

public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();

        for(int i = 0; i < s.length(); i++) {
            if(isLeft(s.charAt(i))) {
                st.push(s.charAt(i));
            } else {
                if(st.isEmpty()) return false;
                char leftSymbol = st.pop();
                if(isMatchingSymbol(leftSymbol, s.charAt(i))) {
                    continue;
                } else {
                    return false;
                }
            }
        }

        if(st.isEmpty())
            return true;
        return false;
    }

    private boolean isLeft(char a) {
        String leftSymbol = "({[";
        return leftSymbol.indexOf(a) >= 0;
    }

    private boolean isMatchingSymbol(char a, char b) {
        if(a == '(' && b == ')') return true;
        if(a == '{' && b == '}') return true;
        if(a == '[' && b == ']') return true;
        return false;
    }
}
