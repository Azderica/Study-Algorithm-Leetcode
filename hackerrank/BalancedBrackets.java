package com.myepark.hackerrank;

import java.util.Stack;

public class BalancedBrackets {

    public static String isBalanced(String s) {
        Stack<Character> st = new Stack<>();
        char[] brackets = s.toCharArray();

        for (char bracket : brackets) {
            if(isLeft(bracket)) {
                st.add(bracket);
            } else {
                if(st.isEmpty()) return "NO";
                if(isValid(st.peek(), bracket)) {
                    st.pop();
                } else {
                    return "NO";
                }
            }
        }

        if (st.isEmpty())
            return "YES";
        return "NO";
    }

    private static boolean isValid(char c1, char c2) {
        return (c1 == '(' && c2 == ')') || (c1 == '{' && c2 == '}') || (c1 == '[' && c2 == ']');
    }

    private static boolean isLeft(char c1) {
        String left = "({[";
        return left.indexOf(c1) >= 0;
    }
}
