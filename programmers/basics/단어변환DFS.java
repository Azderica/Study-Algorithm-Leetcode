package com.myepark.programmers.basics;

import java.util.Arrays;

public class 단어변환DFS {
    public boolean[] visited;
    public int answer = Integer.MAX_VALUE;

    public int solution(String begin, String target, String[] words) {
        // 초기화
        int n = words.length;
        visited = new boolean[n + 1];
        boolean[][] graph = new boolean[n + 1][n + 1];

        // 정답이 없는 경우.
        if (!Arrays.stream(words).anyMatch(target::equals))
            return 0;

        // 목적지를 마지막으로 보내기
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(target)) {
                words[i] = words[n - 1];
                words[n - 1] = target;
            }
        }

        // 각 단어들을 연결
        connectWord(graph, begin, words);

        // 답 만들기
        dfs(graph, 0, 0);
        if (answer == Integer.MAX_VALUE) answer = 0;
        return answer;
    }

    public void connectWord(boolean[][] graph, String begin, String[] words) {
        for (int i = 0; i < words.length; i++) {
            if (isConnected(begin, words[i])) {
                graph[0][i + 1] = true;
                graph[i + 1][0] = true;
            }
        }
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (isConnected(words[i], words[j])) {
                    graph[i + 1][j + 1] = true;
                    graph[j + 1][i + 1] = true;
                }
            }
        }
    }

    public void dfs(boolean[][] graph, int cur, int cnt) {
        // 종료 조건
        visited[cur] = true;
        if (cur == graph.length - 1) {
            if (answer > cnt)
                answer = cnt;
            return;
        }
        for (int i = 0; i < graph.length; i++) {
            if (i != cur && graph[cur][i] && !visited[i]) {
                visited[i] = true;
                dfs(graph, i, cnt + 1);
                visited[i] = false;
            }
        }
    }

    private boolean isConnected(String str1, String str2) {
        if (str1.length() != str2.length())
            return false;
        int cnt = 0;
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i))
                cnt++;
            if (cnt > 1)
                return false;
        }
        return true;
    }
}
