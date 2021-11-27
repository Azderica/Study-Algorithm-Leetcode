package com.myepark;

import java.util.*;

public class ShortestWordDistance2 {
    class WordDistance {
        private HashMap<String, List<Integer>> indexes;

        public WordDistance(String[] wordsDict) {
            indexes = new HashMap<String, List<Integer>>();
            for(int i = 0; i < wordsDict.length; i++) {
                if(indexes.containsKey(wordsDict[i])) {
                    indexes.get(wordsDict[i]).add(i);
                } else {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(i);
                    indexes.put(wordsDict[i], list);
                }
            }
        }

        public int shortest(String word1, String word2) {
            List<Integer> l1 = indexes.get(word1);
            List<Integer> l2 = indexes.get(word2);

            int result = Integer.MAX_VALUE;
            for(int i1 : l1)
                for(int i2 : l2)
                    result = Math.min(result, Math.abs(i1 - i2));
            return result;
        }
    }

}
