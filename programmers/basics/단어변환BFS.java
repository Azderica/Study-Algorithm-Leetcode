package com.myepark.programmers.basics;

import java.util.LinkedList;
import java.util.Queue;

public class 단어변환BFS {
    class Node {
        String word;
        int depth;

        public Node(String word, int depth) {
            this.word = word;
            this.depth = depth;
        }
    }

    public int solution(String begin, String target, String[] words) {
        int n = words.length, answer = 0;
        Queue<Node> q = new LinkedList<>();
        boolean[] visited = new boolean[n];

        q.add(new Node(begin, 0));
        while(!q.isEmpty()) {
            Node cur = q.poll();
            if(cur.word.equals(target)) {
                answer = cur.depth;
                break;
            }
            for(int i=0; i<n; i++) {
                if(!visited[i] && isNext(cur.word, words[i])) {
                    visited[i] = true;
                    q.add(new Node(words[i], cur.depth + 1));
                }
            }
        }
        return answer;
    }

    private boolean isNext(String cur, String n) {
        int cnt = 0;
        for (int i=0; i<n.length(); i++) {
            if(cur.charAt(i) != n.charAt(i)) {
                if(++ cnt > 1) return false;
            }
        }
        return true;
    }
}
