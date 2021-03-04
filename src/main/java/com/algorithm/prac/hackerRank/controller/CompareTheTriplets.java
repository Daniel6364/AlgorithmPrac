package com.algorithm.prac.hackerRank.controller;

import java.util.ArrayList;
import java.util.List;

public class CompareTheTriplets {

    public static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {

        System.out.println("==// compareTriplets");
        System.out.println("a : " + a.toString());
        System.out.println("b : " + b.toString());

        List<Integer> answer = new ArrayList<>();

        int aWin = 0;
        int bWin = 0;
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i) > b.get(i)) {
                aWin++;
                continue;
            } else if (a.get(i) < b.get(i)) {
                bWin++;
                continue;
            } else if (a.get(i) == b.get(i)) {
                continue;
            }
        }

        answer.add(aWin);
        answer.add(bWin);


        return answer;
    }


    public static void main(String[] args) {

        List<Integer> a = new ArrayList<>();
        a.add(17);
        a.add(28);
        a.add(30);

        List<Integer> b = new ArrayList<>();
        b.add(99);
        b.add(16);
        b.add(8);

        compareTriplets(a, b);
    }
}
