package com.myepark.programmers.kakao2018;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class 추석트래픽 {
    class Log {
        double startDate;
        double endDate;

        Log(double startDate, double endDate) {
            this.startDate = startDate;
            this.endDate = endDate;
        }
    }

    public int solution(String[] lines) {
        if (lines.length <= 1)
            return lines.length;

        int answer = 0;
        List<Log> logs = new ArrayList<>();

        // insert data
        for (String line : lines) {
            String[] command = line.split(" ");
            double endDate = getMilliDate(command[1]);
            double startDate = endDate - getMilliTime(command[2]) + 0.001;
            if (startDate < 0)
                startDate = 0;
            logs.add(new Log(startDate, endDate));
        }

        // make answer
        for (int i = 0; i < logs.size() - 1; i++) {
            double endTime = logs.get(i).endDate + 1;
            int count = 1;

            for (int j = i + 1; j < logs.size(); j++) {
                Log cur = logs.get(j);
                if (endTime > cur.startDate)
                    count++;
            }
            answer = Math.max(answer, count);
        }
        return answer;
    }


    private double getMilliDate(String date) {
        double nanoTime = 0;
        String[] val = date.split(":");
        nanoTime += Double.parseDouble(val[0]) * 3600;
        nanoTime += Double.parseDouble(val[1]) * 60;
        nanoTime += Double.parseDouble(val[2]);
        return nanoTime;
    }

    private double getMilliTime(String time) {
        return Double.parseDouble(time.substring(0, time.length() - 1));
    }

    @Test
    public void Test() {
        Assertions.assertEquals(solution(new String[]{"2016-09-15 01:00:04.001 2.0s",
                "2016-09-15 01:00:07.000 2s"}), 1);
        Assertions.assertEquals(solution(new String[]{"2016-09-15 01:00:04.002 2.0s",
                "2016-09-15 01:00:07.000 2s"}), 2);
        Assertions.assertEquals(solution(new String[]{"2016-09-15 20:59:57.421 0.351s",
                "2016-09-15 20:59:58.233 1.181s",
                "2016-09-15 20:59:58.299 0.8s",
                "2016-09-15 20:59:58.688 1.041s",
                "2016-09-15 20:59:59.591 1.412s",
                "2016-09-15 21:00:00.464 1.466s",
                "2016-09-15 21:00:00.741 1.581s",
                "2016-09-15 21:00:00.748 2.31s",
                "2016-09-15 21:00:00.966 0.381s",
                "2016-09-15 21:00:02.066 2.62s"}), 7);
    }
}
