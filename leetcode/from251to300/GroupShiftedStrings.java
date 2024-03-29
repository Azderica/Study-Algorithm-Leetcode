package com.myepark.leetcode.from251to300;

import java.util.*;

public class GroupShiftedStrings {
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> map = new LinkedHashMap<>();

        for(String s : strings) {
            boolean added = false;
            for(String k : map.keySet()) {
                if(s.length() != k.length()) continue;
                if(isShift(k, s)) {
                    added = true;
                    map.get(k).add(s);
                }
            }

            if(!added) {
                List<String> l = new ArrayList<>();
                l.add(s);
                map.put(s, l);
            }
        }

        return new ArrayList<List<String>>(map.values());
    }

    private boolean isShift(String k, String s) {
        int prev = (26 + s.charAt(0) - k.charAt(0)) % 26;
        for(int i = 1; i < k.length(); i++) {
            int cur = (26 + s.charAt(i) - k.charAt(i)) % 26;
            if(cur != prev) return false;
            prev = cur;
        }
        return true;
    }
}
