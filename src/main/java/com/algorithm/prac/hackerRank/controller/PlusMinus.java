package com.algorithm.prac.hackerRank.controller;

public class PlusMinus {

    static void plusMinus(int[] arr) {

        System.out.println("==// solution");

        double plusNum = 0;
        double minusNum = 0;
        double zeroNum = 0;
        int arrLength = arr.length;

        for (float value : arr) {
            if (value == 0) {
                zeroNum++;
            }
            if (value < 0) {
                minusNum++;
            }
            if (value > 0) {
                plusNum++;
            }
        }
        System.out.println(Math.round((plusNum / (double) arrLength) * 1000000) / 1000000.0);
        System.out.println(Math.round((minusNum / (double) arrLength) * 1000000) / 1000000.0);
        System.out.println(Math.round((zeroNum / (double) arrLength) * 1000000) / 1000000.0);



    }


    public static void main(String[] args) {

        int[] arr = {-4, 3, -9, 0, 4, 1};
        plusMinus(arr);

    }
}
