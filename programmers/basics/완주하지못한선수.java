package com.myepark.programmers.basics;

import java.util.*;

class 완주하지못한선수 {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> participantMap = new HashMap<>();

        insertPlayers(participantMap, participant);
        deletePlayers(participantMap, completion);

        if(participantMap.size() != 1) {
            System.err.println("미 완료자가 두 명이상이거나 없음");
            System.out.println(participantMap);
        }
        return (String)participantMap.keySet().stream().toArray()[0];
    }

    public void insertPlayers(Map<String, Integer> playerMaps, String[] players) {
        for(String player : players) {
            if(playerMaps.containsKey(player)) {
                Integer count = playerMaps.get(player);
                playerMaps.put(player, count + 1);
            } else {
                playerMaps.put(player, 1);
            }
        }
    }

    public void deletePlayers(Map<String, Integer> playerMaps, String[] players) {
        for(String player : players) {
            // 완주자는 출발자에 다 있다고 가정
            Integer count = playerMaps.get(player);
            if(count > 1) {
                playerMaps.put(player, count - 1);
            } else {
                playerMaps.remove(player);
            }
        }
    }
}