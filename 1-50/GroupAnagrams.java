package com.myepark;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {

    public static void output(List<List<String>> res) {
        for (List<String> list : res) {
            System.out.print("[");
            for (String val : list) {
                System.out.print(val + " ");
            }
            System.out.print("], ");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        output(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
        output(groupAnagrams(new String[]{""}));
        output(groupAnagrams(new String[]{"a"}));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        List<List<String>> res = new ArrayList<>();

        for(String str : strs) {
            // make key
            char[] strChars = str.toCharArray();
            Arrays.sort(strChars);
            String key = new String(strChars);

            if(!map.containsKey(key)) {
                List<String> set = new ArrayList<>();
                set.add(str);
                map.put(key, set);
            } else {
                map.get(key).add(str);
            }
        }

        map.forEach((key, value) -> {
            res.add(value);
        });

        return res;
    }
}
