package com.myepark.hackerrank;

import java.io.*;
import java.util.*;

public class SimpleTextEditor {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Stack<String> st = new Stack<>();
        int n = in.nextInt(), val;
        String word;

        for(int i=0; i<n; i++) {
            int ops = in.nextInt();
            switch (ops) {
                case 1:
                    word = in.nextLine().replaceAll(" ", "");
                    if(st.isEmpty()) {
                        st.add(word);
                    } else {
                        st.add(st.peek() + word);
                    }
                    break;
                case 2:
                    val = in.nextInt();
                    word = st.peek();
                    st.add(word.substring(0, word.length() - val));
                    break;
                case 3:
                    val = in.nextInt();
                    System.out.println(st.peek().charAt(val - 1));
                    break;
                case 4:
                    st.pop();
                    break;
                default:
                    continue;
            }
            // System.out.println(st.peek());
        }
    }
}
