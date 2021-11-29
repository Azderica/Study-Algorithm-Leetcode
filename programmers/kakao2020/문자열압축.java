package com.myepark.programmers.kakao2020;

public class 문자열압축 {
    public int solution(String s) {
        int answer = s.length();

        if(s.length() <= 2)
            return answer;

        // 1 ~ s.length()/2 길이의 패턴을 비교합니다.
        for(int len = 1; len <= s.length() / 2; len++) {
            int count = 1, word_len = s.length();
            String prev = s.substring(0, len);
            for(int i = len; i + len <= s.length(); i += len) {
                if(prev.equals(s.substring(i, i + len))){
                    count++;
                } else {
                    if(count > 1) {
                        word_len = word_len - len * (count - 1) + getDigit(count);
                        count = 1;
                    }
                }
                prev = s.substring(i, i + len);
            }
            if(count > 1)
                word_len = word_len - len * (count - 1) + getDigit(count);

            if(word_len < answer)
                answer = word_len;
        }
        return answer;
    }

    private int getDigit(int num) {
        int digit = 0;
        while(num >= 1) {
            digit++;
            num /= 10;
        }
        return digit;
    }
}
