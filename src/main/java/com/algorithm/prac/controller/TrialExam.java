package com.algorithm.prac.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Daniel
 * @project_name AlgorithmPrac
 * @package_name com.algorithm.prac.controller
 * @since 2021-02-17
 */
public class TrialExam {

    public static int[] solution(int[] answers) {

        int[] answer = new int[10000];
        int[] resultList = new int[3];

        int[] s1 = {1, 2, 3, 4, 5};
        int[] s2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] s3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int idx = 0;
        while (idx < 10000) {
            for (int val : answers) {
                answer[idx] = val;
                idx++;
            }
        }

        int correctAnswer = 0;
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == s1[i]) {
                correctAnswer += 1;
            }
        }
        resultList[0] = correctAnswer;

        correctAnswer = 0;
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == s2[i]) {
                correctAnswer += 1;
            }
        }
        resultList[1] = correctAnswer;

        correctAnswer = 0;
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == s3[i]) {
                correctAnswer += 1;
            }
        }
        resultList[2] = correctAnswer;

        idx = 0;
        for (int val : resultList) {
            if (val == Arrays.stream(resultList).max().getAsInt()) {
                idx += 1;
            }
        }
        System.out.println("idx : " + idx);
        int result[] = new int[idx];

        idx = 0;
        for (int i = 0; i < resultList.length; i++) {
            if (resultList[i] == Arrays.stream(resultList).max().getAsInt()) {
                result[idx] = (i + 1);
                idx++;
            }
        }
        for (int val : result) {
            System.out.println("val : " + val);
        }


        return result;
    }


    public static int[] solution2(int[] answers) {

        int[] resultList = new int[3];

        int[] s1 = {1, 2, 3, 4, 5};
        int[] s2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] s3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int idx = 0;

        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == s1[i]) resultList[0] += 1;
            if (answers[i] == s2[i]) resultList[1] += 1;
            if (answers[i] == s3[i]) resultList[2] += 1;
        }

        for (int val : resultList) {
            if (val == Arrays.stream(resultList).max().getAsInt()) {
                idx += 1;
            }
        }
        int answer[] = new int[idx];

        idx = 0;
        for (int i = 0; i < resultList.length; i++) {
            if (resultList[i] == Arrays.stream(resultList).max().getAsInt()) {
                answer[idx] = (i + 1);
                idx++;
            }
        }

        return answer;
    }


    public static int[] solution3(int[] answers) {

        int[][] student = {{1, 2, 3, 4, 5},{2, 1, 2, 3, 2, 4, 2, 5},{3, 3, 1, 1, 2, 2, 4, 4, 5, 5}};
        int[] score = new int[student.length];

        for (int i = 0; i < answers.length; i++) {
            for (int j = 0; j < student.length; j++) {

                System.out.println("i : " + i);
                System.out.println("student[j].length : " + student[j].length);
                int result = i % student[j].length;
                System.out.println("result : " + result);

                if (answers[i] == student[j][i % student[j].length]) {
                    score[j]++;
                }
                System.out.println("=============");
            }
        }

        int max = Arrays.stream(score).max().getAsInt();

        List<Integer> winner = new ArrayList<>();
        for (int i = 0; i < score.length; i++) {
            if (score[i] == max) {
                winner.add(i + 1);
            }
        }


        int[] answer = new int[winner.size()];
        for (int i = 0; i < winner.size(); i++) {
            answer[i] = winner.get(i);
        }



        return answer;
    }


    public static void main(String[] args) {

//        int[] answers = {1,2,3,4,5};
        int[] answers = {1,3,2,4,2};
        solution3(answers);

    }

}
