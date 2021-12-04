package com.myepark.programmers.basics;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class 나라와숫자124 {
    public String solution(int n) {
        String[] nums = {"4", "1", "2"};
        String answer = "";
        int num = n;

        while(num > 0) {
            int key = num % 3;

            num /= 3;
            if(key == 0) num--;
            answer = nums[key] + answer;
        }

        return answer;
    }

    @Test
    public void test() {
        Assertions.assertEquals("41", solution(10));
        Assertions.assertEquals("24", solution(9));
        Assertions.assertEquals("1", solution(1));
    }
}
