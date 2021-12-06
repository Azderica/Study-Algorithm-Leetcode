package com.myepark.hackerrank;

import java.util.Arrays;
import java.util.List;

public class GridChallenge {
    public static String gridChallenge(List<String> grid) {

        // sort with vertical
        for(int i = 0; i < grid.size(); i++) {
            char[] alphabets = grid.get(i).toCharArray();
            Arrays.sort(alphabets);
            grid.set(i, new String(alphabets));
        }

        // check
        for(String line : grid) {
            System.out.println(line);
        }

        // check horizon
        for(int i = 0; i < grid.get(0).length(); i++) {
            for(int j = 0; j < grid.size() - 1; j++) {
                if(grid.get(j).charAt(i) > grid.get(j + 1).charAt(i)) {
                    return "NO";
                }
            }
        }
        return "YES";
    }

}
