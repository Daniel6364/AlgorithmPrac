package com.algorithm.prac.programmers.controller;

import java.util.TreeSet;

/**
 * @author Daniel
 * @project_name AlgorithmPrac
 * @package_name com.algorithm.prac.programmers.controller
 * @since 2021-03-05
 * <p>
 * 두 정수 사이의 합
 * <p>
 * [문제 설명]
 * 두 정수 a, b가 주어졌을 때 a와 b 사이에 속한 모든 정수의 합을 리턴하는 함수, solution을 완성하세요.
 * 예를 들어 a = 3, b = 5인 경우, 3 + 4 + 5 = 12이므로 12를 리턴합니다.
 * <p>
 * [제한 조건]
 * a와 b가 같은 경우는 둘 중 아무 수나 리턴하세요.
 * a와 b는 -10,000,000 이상 10,000,000 이하인 정수입니다.
 * a와 b의 대소관계는 정해져있지 않습니다.
 * <p>
 * [입출력 예]
 * a	b	return
 * 3	5	12
 * 3	3	3
 * 5	3	12
 */
public class SumNumber {

    public static long solution(int a, int b) {

        System.out.println("==// solution");

        TreeSet<Integer> hs = new TreeSet<>();
        hs.add(a);
        hs.add(b);

        long answer = 0;
        if (hs.size() == 1) {
            answer = hs.first();
        } else {
            for (int i = hs.first(); i <= hs.last(); i++) {
                answer += i;
            }
        }


        System.out.println("answer : " + answer);


        return answer;
    }

    public static long solution2(int a, int b) {

        System.out.println("==// solution2");

        long answer = 0;

        int start = Math.min(a, b);
        int end = Math.max(a, b);

        for (int i = start; i <= end ; i++) {
            answer += i;
        }

        System.out.println("answer : " + answer);


        return answer;
    }

    public static void main(String[] args) {
        int a = 3;
        int b = 5;

        solution2(a, b);
    }
}
