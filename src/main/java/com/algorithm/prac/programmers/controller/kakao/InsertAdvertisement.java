package com.algorithm.prac.programmers.controller.kakao;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;

public class InsertAdvertisement {


    public int timeToSec(String time) {

        int[] strTime = Arrays.stream(time.split(":")).mapToInt(Integer::parseInt).toArray();
        int result = strTime[0] * 60 * 60 + strTime[1] * 60 + strTime[2];
        System.out.println("=====/ " + time + ": " + result);
        return result;
    }

    public String solution(String play_time, String adv_time, String[] logs) {

        String answer = "";

        int playTime = timeToSec(play_time);
        int advTime = timeToSec(adv_time);

        long[] playCnt = new long[playTime + 1];
        for (String log : logs) {
//            System.out.println("log : " + log);
            String[] logSplit = log.split("-");
//            playCnt[timeToSec(logSplit[0])]++;
//            playCnt[timeToSec(logSplit[1])]--;
            int s = timeToSec(logSplit[0]);
            int e = timeToSec(logSplit[1]);
            for (int i = s; i < e; i++) playCnt[i]++;
        }

        System.out.println("==// 2. Arrays.toString(playCnt)");
        System.out.println(Arrays.toString(playCnt));

        int startTime = 0;
        int endTime = advTime;
        long sum = 0;
        for (int i = startTime; i < endTime; i++) {
            sum += playCnt[i];
        }

        


        return answer;
    }

    public static void main(String[] args) {

        String play_time = "02:03:55";
        String adv_time = "00:14:15";
        String[] logs = {
                "01:20:15-01:45:14",
                "00:40:31-01:00:00",
                "00:25:50-00:48:29",
                "01:30:59-01:53:29",
                "01:37:44-02:02:30"
        };

        InsertAdvertisement ia = new InsertAdvertisement();
        System.out.println(ia.solution(play_time, adv_time, logs));

    }
}
