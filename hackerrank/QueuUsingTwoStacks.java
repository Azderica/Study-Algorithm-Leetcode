package com.myepark.hackerrank;

import java.io.*;
import java.util.*;

public class QueuUsingTwoStacks {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), rear = -1, front = 0;
        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            int ops = in.nextInt();
            if(ops == 1) {
                int num = in.nextInt();
                arr[++rear] = num;
            } else if(ops == 2) {
                int num = arr[front++];
            } else {
                System.out.println(arr[front]);
            }
        }
    }
}
