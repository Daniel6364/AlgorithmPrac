package com.algorithm.prac.programmers.controller;

/**
 * @author Daniel
 * @project_name AlgorithmPrac
 * @package_name com.algorithm.prac.programmers.controller
 * @since 2021-03-05
 *
 * 문자열 내 p와 y의 개수
 * 문제 설명
 * 대문자와 소문자가 섞여있는 문자열 s가 주어집니다.
 * s에 'p'의 개수와 'y'의 개수를 비교해 같으면 True, 다르면 False를 return 하는 solution를 완성하세요.
 * 'p', 'y' 모두 하나도 없는 경우는 항상 True를 리턴합니다.
 * 단, 개수를 비교할 때 대문자와 소문자는 구별하지 않습니다.
 *
 * 예를 들어 s가 "pPoooyY"면 true를 return하고 "Pyy"라면 false를 return합니다.
 *
 * [제한사항]
 * 문자열 s의 길이 : 50 이하의 자연수
 * 문자열 s는 알파벳으로만 이루어져 있습니다.
 *
 * [입출력 예]
 * s	answer
 * "pPoooyY"	true
 * "Pyy"	false
 *
 * [입출력 예 설명]
 * 입출력 예 #1
 * 'p'의 개수 2개, 'y'의 개수 2개로 같으므로 true를 return 합니다.
 *
 * 입출력 예 #2
 * 'p'의 개수 1개, 'y'의 개수 2개로 다르므로 false를 return 합니다.
 *
 */

public class PYinString {


    public static boolean solution(String s) {

        System.out.println("==// solution");

        String str = s.toLowerCase();
        int cntP = 0;
        int cntY = 0;
        for (int i = 0; i < str.length(); i++) {

            if (str.charAt(i) == 'p') {
                cntP++;
            } else if (str.charAt(i) == 'y') {
                cntY++;
            }
        }

        boolean answer = true;
        if (cntP != cntY) {
            answer = false;
        }

        System.out.println(answer);

        return answer;
    }

    public static boolean solution2(String s) {

        System.out.println("==// solution");
        String str = s.toLowerCase();
        boolean answer = str.chars().filter(e -> 'p' == e).count() == str.chars().filter(e -> 'y' == e).count();
        System.out.println(answer);

        return answer;
    }

    public static void main(String[] args) {
        String s = "pPoooyYp";
        solution2(s);

    }


}
