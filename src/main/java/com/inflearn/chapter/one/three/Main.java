package com.inflearn.chapter.one.three;

import java.util.Scanner;

public class Main {

    public String solution(String input) {

        String answer = "";

        String[] inputArr = input.split(" ");
        for(String str : inputArr) {
            if (answer.equals("")) {
                answer = str;
            } else {
                if (str.length() > answer.length()) {
                    answer = str;
                }
            }
        }

        return answer;

    }

    public static void main(String[] args) {
        Main m = new Main();
        Scanner sc = new Scanner(System.in);
        String input = "It is time to study";

        System.out.println(m.solution(input));
    }
}
