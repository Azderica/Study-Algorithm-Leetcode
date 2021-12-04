package com.myepark.programmers.basics;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

// todo. 문제 못품경우
public class 브라이언의고민 {
    private StringBuilder sb;

    public String solution(String sentence) {
        char[] sentences = sentence.toCharArray();
        char prev = ' ';
        int prevIndex = 0, curRule = 0, count = 0;
        sb = new StringBuilder();

        for(int i = 0; i < sentences.length; i++) {
            if(isUpperCase(sentences[i])) {
                sb.append(sentences[i]);
            } else {
                if(prev == ' ') {
                    count++;
                    if(i == 0) curRule = 2;
                } else if (prev == sentences[i]) {
                    count++;
                    if(count != 2) {
                        if(curRule == 2)
                            return "invalid";
                        curRule = 1;
                    }
                } else {
                    curRule = findRule(i, sentences, prevIndex, curRule);
                    if(curRule == -1)
                        return "invalid";
                    count = 1;
                }
                prev = sentences[i];
                prevIndex = i;
            }
            System.out.println(i + "th cur : " + sb.toString());
        }
        return sb.toString();
    }

    /**
     * rule 0: default, 1: XaYaZ, 2: aXYZa, -1: invalid;
     */
    private int findRule(int index, char[] sentences, int prevIndex, int curRule) {
        if(index - prevIndex == 1) {
            if(curRule == 1)
                return -1;
            sb.append(" ");
            return 2;
        } else if (index - prevIndex == 2) {
            if(curRule == 1) {
                sb.append(" ");
                return 2;
            }
            else if(curRule == 2) {
                sb.deleteCharAt(sb.length() - 1);
                sb.append(" ").append(sentences[index - 1]);
                return 1;
            }
            else return 0;
        } else if (index - prevIndex == 3) {
            if(curRule == 2)
                return -1;
            sb.deleteCharAt(sb.length() - 1);
            sb.append(" ").append(sentences[index - 1]);
            return 1;
        } else {
            return -1;
        }
    }

    private boolean isUpperCase(char ch) {
        return ch >= 'A' && ch <= 'Z';
    }

    @Test
    public void test() {
//        Assertions.assertEquals("HELLO WORLD", solution("HaEaLaLaObWORLDb"));
//        Assertions.assertEquals("SIGONG JOA", solution("SpIpGpOpNpGJqOqA"));
//        Assertions.assertEquals("invalid", solution("AxAxAxAoBoBoB"));
        Assertions.assertEquals("I AM", solution("aIaAM"));
        Assertions.assertEquals("invalid", solution("aaA"));
        Assertions.assertEquals("invalid", solution("Aaa"));
        Assertions.assertEquals("HELLOWORLD", solution("aHELLOWORLDa"));
        Assertions.assertEquals("HELL O WORLD", solution("HaEaLaLObWORLDb"));
    }
}
