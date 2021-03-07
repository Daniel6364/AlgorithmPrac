package com.algorithm.prac.programmers.controller;

import java.util.*;

/**
* @package : com.algorithm.prac.programmers.controller
* @name : DescendingString.java
* @date : 2021/03/06 17:13
* @author : daniel
* @version : 1.0.0
* @modifyed :
 *
 *
 *[문자열 내림차순으로 배치하기]
 *
 * [문제 설명]
 * 문자열 s에 나타나는 문자를 큰것부터 작은 순으로 정렬해 새로운 문자열을 리턴하는 함수,
 * solution을 완성해주세요.
 * s는 영문 대소문자로만 구성되어 있으며, 대문자는 소문자보다 작은 것으로 간주합니다.
 *
 * [제한 사항]
 * str은 길이 1 이상인 문자열입니다.
 *
 * [입출력 예]
 * s	        return
 * "Zbcdefg"	"gfedcbZ"
 *
**/
public class DescendingString {

    public static String solution(String s) {

        System.out.println("==// solution");

        Character[] characters = new Character[s.length()];
        for (int i = 0; i < s.length(); i++) {
            characters[i] = s.charAt(i);
        }
        Arrays.sort(characters, Collections.reverseOrder());

        String answer = "";
        for (int i = 0; i < characters.length; i++) {
            answer += characters[i];
        }

        System.out.println("answer : " + answer);


        return answer;
    }

    public static void main(String[] args) {

        String s = "Zbcdefg";
        solution(s);

    }
}
