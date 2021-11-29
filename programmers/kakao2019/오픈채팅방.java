package com.myepark.programmers.kakao2019;

import java.util.*;

public class 오픈채팅방 {
    private Map<String, String> userIdMap;

    public String[] solution(String[] record) {
        List<String> answer = new ArrayList<>();
        userIdMap = new HashMap<String, String>();

        for(String log : record) {
            String[] command = log.split(" ");
            switch(command[0]) {
                case "Enter", "Change" -> userIdMap.put(command[1], command[2]);
            }
        }

        for(String log : record) {
            String[] command = log.split(" ");
            if(!command[0].equals("Change")) {
                answer.add(getMessage(command));
            }
        }
        return answer.stream().toArray(String[]::new);
    }

    private String getMessage(String[] command) {
        StringBuilder sb = new StringBuilder();
        switch(command[0]) {
            case "Enter" -> {sb.append(userIdMap.get(command[1])).append("님이 들어왔습니다.");}
            case "Leave" -> {sb.append(userIdMap.get(command[1])).append("님이 나갔습니다.");}
        }
        return sb.toString();
    }
}
