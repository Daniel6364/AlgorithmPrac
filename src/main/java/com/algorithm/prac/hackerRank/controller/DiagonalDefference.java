package com.algorithm.prac.hackerRank.controller;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Daniel
 * @project_name AlgorithmPrac
 * @package_name com.algorithm.prac.hackerRank.controller
 * @since 2021-03-05
 */
public class DiagonalDefference {

    public static int diagonalDifference(List<List<Integer>> arr) {

        int firstNum = 0;
        int secondNum = 0;

        for (int i = 0; i < arr.size(); i++) {
            firstNum += arr.get(i).get(i);
            secondNum += arr.get(i).get(arr.get(i).size() - 1 - i);
        }
        int answer = Math.abs(firstNum - secondNum);
        System.out.println(answer);

        return answer;

    }



    public static void main(String[] args) {

        List<Integer> firstRow = new ArrayList<>();
        List<Integer> secondRow = new ArrayList<>();
        List<Integer> thirdRow = new ArrayList<>();
        List<List<Integer>> arr = new ArrayList<>();

        firstRow.add(11);
        firstRow.add(2);
        firstRow.add(4);

        secondRow.add(4);
        secondRow.add(5);
        secondRow.add(6);

        thirdRow.add(10);
        thirdRow.add(8);
        thirdRow.add(-12);

        arr.add(firstRow);
        arr.add(secondRow);
        arr.add(thirdRow);

        System.out.println(arr.toString());

        diagonalDifference(arr);

    }
}
