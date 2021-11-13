package com.myepark.programmers.basics;

public class 타켓넘버DFS {
    public int solution(int[] numbers, int target) {
        int answer = 0;
        answer += dfs(0, 0, numbers, target);
        return answer;
    }

    public int dfs(int sum, int index, int[] numbers, int target) {
        if (index == numbers.length) {
            if (target == sum)
                return 1;
            return 0;
        }
        return dfs(sum + numbers[index], index + 1, numbers, target)
                + dfs(sum - numbers[index], index + 1, numbers, target);
    }
}
