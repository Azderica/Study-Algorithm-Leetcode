package com.myepark.programmers.basics;

import java.util.Arrays;

public class 입국심사 {
    public long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times);

        long start, mid, end, sum;
        start = 0;
        end = (long) n * times[times.length - 1];   // 가장 오래걸리는 시간, 제일 긴 시간 * 모든 사람 수
        while (start <= end) {
            mid = (start + end) / 2;
            sum = 0;    // 총 심사한 인원
            for (int i = 0; i < times.length; i++) { // 빨리 심사하는 심사관 순으로 처리
                sum += mid / times[i];
            }
            if (sum < n) {
                // 해야할 인원보다 심사처리를 못했음으로 시간을 더 줍니다.
                start = mid + 1;
            } else {
                // 해야할 인원보다 심사처리를 더 했음으로 시간을 줄여서, 답을 찾습니다.
                end = mid - 1;
                answer = mid;
            }
        }
        return answer;
    }
}
