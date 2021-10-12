package kr.co.programmers.test;


import java.util.Arrays;

public class ChannelCorp {

    public static int solution(int[][] locations) {

        int answer = 0;
        int[] click = {2, 2};
        for (int[] bomb : locations) {
            answer += 1;
            if (Arrays.equals(bomb, click)) {
                answer = -1;
                break;
            }
        }
        System.out.println("answer : " + answer);
        return answer;

    }

    public static int solution2(int[][] cars) {
        int answer = -2;

        for (int i = 0; i < cars.length; i++) {
            for (int j = 0; j < cars[i].length; j++) {

                if (cars[i][j] == 1) {
                    System.out.println("car : " + i + ":" + j);
                }

                if (cars[i][j] == 4) {
                    System.out.println("exit : " + i + ":" + j);
                }
            }
        }

        return answer;
    }


    public static int solution3(int[] s1, int[] s2) {
        int answer = 0;

        if (!Arrays.equals(s1, s2)) {

            System.out.println(Arrays.toString(s1));
            System.out.println(Arrays.toString(s2));
//            System.out.println(s1.length);

            for (int i = 0; i < s1.length; i++) {
//               if (s2[s2.length - 1] != )
            }



            for (int i = 0; i < s1.length; i++) {

            }
        } else {
            answer = 0;
        }

        System.out.println("==> answer : " + answer);

        return answer;
    }

    public static void main(String[] args) {
        int[][] locations = {{1, 3}, {3, 1}};
//        int[][] locations = {{2,2}, {1,3}};
//        solution(locations);


        int[][] cars = {
                {0, 0, 3, 0, 0, 0, 0},
                {1, 0, 3, 0, 0, 0, 0},
                {0, 0, 3, 0, 0, 0, 0},
                {0, 0, 2, 0, 0, 3, 3},
                {2, 2, 2, 0, 2, 0, 0},
                {3, 3, 2, 0, 2, 0, 3},
                {3, 3, 2, 0, 2, 0, 4}
        };
//        solution2(cars);

        int[] s1 = {1, 2, 3, 0, 6, 5, 4};
        int[] s2 = {1, 2, 3, 4, 5, 6, 0};
        solution3(s1, s2);

    }
}
