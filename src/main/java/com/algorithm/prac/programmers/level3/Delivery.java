package com.algorithm.prac.programmers.level3;

import java.util.Arrays;

public class Delivery {

    public static int solution(int N, int[][] road, int K) {

        int answer = 0;

        int[][] map = new int[N][N];

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                if (i == j) {
                    map[i][j] = 0;
                    continue;
                }
                map[i][j] = Integer.MAX_VALUE;
            }
        }

        System.out.println("==// [1]");
        for (int i = 0; i < map.length; i++) {
            System.out.println(Arrays.toString(map[i]));
        }

        for (int[] r : road) {
            if (map[r[0]-1][r[1]-1] < r[2]) continue;
            map[r[0]-1][r[1]-1] = r[2];
            map[r[1]-1][r[0]-1] = r[2];
        }

        System.out.println("==// [2]");
        for (int i = 0; i < map.length; i++) {
            System.out.println(Arrays.toString(map[i]));
        }

        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] > map[i][k] + map[k][j]) {
                        map[i][j] = map[i][k] + map[k][j];
                    }
                }
            }
        }
        System.out.println("==// [3]");
        for (int i = 0; i < map.length; i++) {
            System.out.println(Arrays.toString(map[i]));
        }

        for (int i = 0; i < map.length; i++) {
            if (map[0][i] <= K) {
                System.out.println(map[0][i]);
                answer++;
            }
        }
        System.out.println("answer : " + answer);


        return answer ;
    }

    public static void main(String[] args) {

        int N = 5;
        int[][] road = {{1,2,1},{2,3,3},{5,2,2},{1,4,2},{5,3,1},{5,4,2}};
        int K = 3;

        solution(N, road, K);

    }
}
