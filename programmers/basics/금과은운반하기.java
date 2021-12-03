package com.myepark.programmers.basics;

public class 금과은운반하기 {
    public long solution(int a, int b, int[] g, int[] s, int[] w, int[] t) {
        long answer = (long)(1e9 * 2 * 1e5 * 2);
        long start = 0, end = answer;

        while(start <= end) {
            long mid = (start + end) / 2;

            // 운반 횟수 안에 각 도시에서 최대로 옮길 수 있는 금, 은, 광물의 무게들을 저장합니다.
            long gold = 0, silver = 0, add = 0;
            for(int i=0; i<g.length; i++) {
                long moveCnt = mid / ((long) t[i] * 2);
                if(mid % ((long) t[i] * 2) >= t[i]) moveCnt++;

                gold += ((long) g[i] < moveCnt * w[i]) ? g[i] : moveCnt * w[i];
                silver += ((long) s[i] < moveCnt * w[i]) ? s[i] : moveCnt * w[i];
                add += ((long) g[i] + (long) s[i] < moveCnt * w[i]) ? (long) g[i] + s[i] : moveCnt * w[i];
            }

            // 이동이 가능한 경우는 시간안에 해결이 되므로 end 조건을 바꿔주고 안되는 경우, start 조건을 바꿔줍니다.
            if(gold >= a && silver >= b && add >= a + b) {
                end = mid - 1;
                answer = Math.min(mid, answer);
            } else {
                start = mid + 1;
            }
        }
        return answer;
    }
}
