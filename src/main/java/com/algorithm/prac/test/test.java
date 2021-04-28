package com.algorithm.prac.test;

import java.util.Arrays;

public class test {

    public static int solution(int[] gift_cards, int[] wants) {
        int answer = 0;

        System.out.println(Arrays.toString(gift_cards));
        System.out.println(Arrays.toString(wants));

        int cnt = 0;
        for (int i = 0; i < gift_cards.length; i++) {
            for (int j = 0; j < wants.length; j++) {

                if (gift_cards[i] == wants[j]) {
                    wants[j] = 0;
                    cnt++;
                    break;
                }
            }
        }
        answer = gift_cards.length - cnt;

        System.out.println(Arrays.toString(wants));
        System.out.println(gift_cards.length);
        System.out.println(cnt);
        System.out.println("answer : " + answer);


        return answer;
    }

    public static void main(String[] args) {
        int[] gift_cards = {4, 5, 3, 2, 1};
        int[] wants = {2, 4, 4, 5, 1};

        /*int[] gift_cards = {5, 4, 5, 4, 5};
        int[] wants = {1, 2, 3, 5, 4};*/

        solution(gift_cards, wants);

    }
}
