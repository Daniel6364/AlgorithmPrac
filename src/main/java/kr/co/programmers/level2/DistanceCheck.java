package kr.co.programmers.level2;

import java.util.Arrays;

public class DistanceCheck {

    public static boolean bfs(String[] line, int x, int y) {

        boolean result = false ;

        System.out.println("=====// bfs");
        System.out.println(Arrays.toString(line));
        System.out.println("x:y => " + x + ":" + y);

        


        return result;
    }


    public static int[] solution(String[][] places) {

        int[] answer = new int[places.length];
        for (String[] line : places) {
            System.out.println("line : " + Arrays.toString(line));

            for (int i = 0; i < line.length; i++) {
                for (int j = 0; j < line[i].length(); j++) {
                    if (line[i].charAt(j) == 'P') {
                        boolean distanceCheck = bfs(line, i, j);

                    }
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        String[][] places = {
                {"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
                {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
                {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
                {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
                {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}
        };

        solution(places);
    }

}
