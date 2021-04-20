package com.algorithm.prac.test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class test4 {
    public static int[] checkValue(int zeroCnt, int correctCnt) {

        System.out.println("zeroCnt : " + zeroCnt);
        System.out.println("correctCnt : " + correctCnt);

        HashMap<Integer, Integer> score = new HashMap<>();
        score.put(6, 1);
        score.put(5, 2);
        score.put(4, 3);
        score.put(3, 4);
        score.put(2, 5);
        score.put(1, 6);
        score.put(0, 6);

        int[] result = new int[2];
        if (zeroCnt == 6) {
            result[0] = 6;
            result[1] = 1;
        } else if (zeroCnt == 0) {
            result[0] = score.get(correctCnt);
            result[1] = score.get(correctCnt);
        } else {
            result[0] = score.get(correctCnt + zeroCnt);
            result[1] = score.get(correctCnt);
        }
        return result;
    }

    public static int[] solution(int[] lottos, int[] win_nums) {
        //int[] answer = new int[2];

        int zeroCnt = 0;
        int correctCnt = 0;
        for (int myNum : lottos) {
            if (myNum == 0) {
                zeroCnt++;
            }
            for (int winNum : win_nums) {
                if (myNum == winNum) {
                    correctCnt++;
                }
            }
        }
        int[] answer = checkValue(zeroCnt, correctCnt);
        System.out.println("answer : " + Arrays.toString(answer));


        return answer;
    }

    public static void main(String[] args) {

        //int[] lottos = {44, 1, 0, 0, 31, 25};
        //int[] win_nums = {31, 10, 45, 1, 6, 19};

        int[] lottos = {44, 1, 0, 0, 31, 25};
        int[] win_nums = {31, 10, 45, 1, 6, 19};

        solution(lottos, win_nums);
    }
}
