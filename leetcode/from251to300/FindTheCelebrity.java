package com.myepark.leetcode.from251to300;

public class FindTheCelebrity {
    public int findCelebrity(int n) {
        if(n <= 1) return -1;

        // two pointer : 0, n - 1
        int left = 0, right = n - 1;

        // find the potential candidate
        while(left < right) {
            if(knows(left, right)) {
                left++;
            } else {
                right--;
            }
        }

        // validate
        int candidate = right;
        for(int i = 0; i < n; i++) {
            if(i != candidate && (!knows(i, candidate) || knows(candidate, i)))
                return -1;
        }
        return candidate;
    }

    private boolean knows(int a, int b) {
        // The knows API is defined in the parent class Relation.
        return true;
    }
}
