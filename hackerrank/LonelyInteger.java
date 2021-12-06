package com.myepark.hackerrank;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LonelyInteger {
    public static int lonelyinteger(List<Integer> a) {
        Set<Integer> numSet = new HashSet<>();
        for(Integer val : a) {
            if(numSet.contains(val))
                numSet.remove(val);
            else
                numSet.add(val);
        }
        return (int) numSet.toArray()[0];
    }

}
