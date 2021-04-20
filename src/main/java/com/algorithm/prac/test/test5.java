package com.algorithm.prac.test;

import java.util.Arrays;
import java.util.HashMap;

public class test5 {

    public static int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = {};

        int[] sellerAmount = new int[seller.length];
        for (int i = 0; i < amount.length; i++) {
            sellerAmount[i] = amount[i] * 100;
        }

        HashMap<String, Integer> enrollPay = new HashMap<>();
        for (int i = 0; i < seller.length; i++) {
            for (int j = 0; j < enroll.length; j++) {
                if (seller[i].equals(enroll[j])) {
                    enrollPay.put(enroll[j], sellerAmount[i]);
                } else {
                    enrollPay.put(enroll[j], 0);
                }
            }
        }

        for (int i = 0; i < referral.length; i++) {
            
        }

        System.out.println("enrollPay : " + enrollPay.toString());


        return answer;
    }

    public static void main(String[] args) {

        String[] enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
        String[] referral = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
        String[] seller = {"young", "john", "tod", "emily", "mary"};
        int[] amount = {12, 4, 2, 5, 10};

        // result = {360, 958, 108, 0, 450, 18, 180, 1080};
        solution(enroll, referral, seller, amount);
    }
}
