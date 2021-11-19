package com.myepark.programmers.basics;

public class 조이스틱 {
    public int solution(String name) {
        int answer = 0, len = name.length();
        char[] keys = name.toCharArray();

        int min = len - 1;
        for (int i = 0; i < len; i++) {
            // 이전, 다음 알파벳으로 커서 이동. A...를 이름으로 바꾸는데 걸리는 횟수
            answer += Math.min(keys[i] - 'A', 'Z' - keys[i] + 1);

            // 이동 횟수, 왼쪽으로 가는 방법과 오른쪽으로 가는 방법이 있습니다.
            // 일반적으로 오른쪽으로 가는 것이 맞지만 오른쪽이 'A'라면 왼쪽으로 가는 경우가 더 빠를 수 있습니다.
            int nextIndex = i + 1;
            while(nextIndex < len && keys[nextIndex] == 'A')
                nextIndex++;
            // 왼쪽에서 오는 경우 min,
            // 오른쪽에서 오는 경우 'i'(현재 위치에서 왼쪽) + 'i + len - nextIndex'(오른쪽 끝에서 오는 경우)
            min = Math.min(min, 2 * i + len - nextIndex);
        }
        answer += min;

        return answer;
    }
}
