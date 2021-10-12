package com.algorithm.prac.programmers.controller.first;

import java.util.Scanner;

public class SquareStarShot {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        String answer = "";

        for (int i = 0; i < b; i++) {
            for (int j = 0; j < a; j++) {
                answer += "*";
            }
            answer += "\n";
        }


        System.out.println(answer);

    }

}
