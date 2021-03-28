package com.algorithm.prac.devmatching;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class DevMatchingTest {

    public static int[] solution(int[][] v) {
        int[] answer = new int[2];
        System.out.println("Hello Java");



        Map<Integer, Integer> pointX = new HashMap<>();
        Map<Integer, Integer> pointY = new HashMap<>();
        for (int[] v1 : v) {

            for (int i = 0; i < v1.length; i++) {

                if (i == 0) {

                    if (pointX.get(v1[i]) == null) {
                        pointX.put(v1[i], 1);
                    } else {
                        pointX.put(v1[i], pointX.get(v1[i]) + 1);
                    }

                } else {

                    if (pointY.get(v1[i]) == null) {
                        pointY.put(v1[i], 1);
                    } else {
                        pointY.put(v1[i], pointY.get(v1[i]) + 1);
                    }

                }

            }

        }

        for (int xKey : pointX.keySet()) {
            if (pointX.get(xKey) == 1) {
                System.out.println("xKey : " + xKey);
                answer[0] = xKey;
            }
        }
        for (int yKey : pointY.keySet()) {
            if (pointY.get(yKey) == 1) {
                System.out.println("yKey : " + yKey);
                answer[1] = yKey;
            }
        }

        System.out.println(Arrays.toString(answer));




        return answer;
    }


    public static void main(String[] args) {


        int[][] v = {{1,4}, {3,4}, {3,10}};
        solution(v);

    }
}
