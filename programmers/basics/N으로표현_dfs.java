package com.myepark.programmers.basics;

public class N으로표현_dfs {
    public int answer = -1;

    public int solution(int N, int number) {
        dfs(N, number, 0, 0);
        return answer;
    }

    public void dfs(int n, int num, int cnt, int val) {
        if (cnt > 8) return;
        // 만든 값이 number와 일치하고, 사용 횟수가 최솟값이면 갱신
        if (num == val) {
            if (answer > cnt || answer == -1) answer = cnt;
            return;
        }
        // N, NN, NNN 에 대한 사칙연산 추가
        int nn = 0;
        for (int i = 0; i < 8; i++) {
            nn = nn * 10 + n;
            dfs(n, num, cnt + 1 + i, val + nn);
            dfs(n, num, cnt + 1 + i, val - nn);
            dfs(n, num, cnt + 1 + i, val * nn);
            dfs(n, num, cnt + 1 + i, val / nn);
        }
    }
}
