package com.myepark.programmers.basics;

import java.util.*;

class K번째수 {
    public int[] solution(int[] array, int[][] commands) {
        List<Integer> answer = new ArrayList<>();
        for(int[] command : commands) {
            int[] splittedArray = Arrays.copyOfRange(array, command[0] - 1, command[1]);
            answer.add(getIndex(splittedArray, command[2]- 1));
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    int getIndex(int[] splittedArray, int index) {
        Arrays.sort(splittedArray);
        return splittedArray[index];
    }
}