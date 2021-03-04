package com.algorithm.prac.programmers.controller;

import java.util.Stack;
import java.util.Vector;

/**
 * @author Daniel
 * @project_name AlgorithmPrac
 * @package_name com.algorithm.prac.controller
 * @since 2021-02-01
 */
public class PluckDoll {

    // Vector 사용
    public static int solution(int[][] board, int[] moves) {

        int answer = 0;

        Vector<Integer> vc = new Vector<Integer>();
        boolean flag = true;

        for (int move : moves) {
            int pick = move - 1;

            for (int row = 0; row < board.length; row++) {
                for (int box = 0; box < board[row].length; box++) {

                    if (pick == box) {

                        if (board[row][box] != 0 && flag) {
                            if (vc.size() > 0) {

                                if (vc.lastElement() != board[row][box]) {
                                    vc.add(board[row][box]);
                                    board[row][box] = 0;
                                    flag = false;
                                } else {
//                                    vc.remove(vc.lastElement());
                                    vc.remove(vc.size()-1);

                                    board[row][box] = 0;
                                    answer += 2;
                                    flag = false;
                                }

                            } else if (vc.size() == 0) {
                                vc.add(board[row][box]);
                                board[row][box] = 0;
                                flag = false;
                            }
                        }
                    }
                }
            }

            flag = true;
        }

        System.out.println("===============================// vc : " + vc.toString());
        System.out.println("===============================// answer : " + answer);

        return answer;
    }

    // Stack 사용
    public static int solution2(int[][] board, int[] moves) {

        int answer = 0;

        Stack<Integer> sc = new Stack<Integer>();
        boolean flag = true;

        for (int move : moves) {
            int pick = move - 1;

            for (int row = 0; row < board.length; row++) {
                for (int box = 0; box < board[row].length; box++) {

                    if (pick == box) {
                        if (board[row][box] != 0 && flag) {

                            if (sc.isEmpty()) {
                                sc.push(board[row][box]);
                                board[row][box] = 0;
                                flag = false;
                            } else {
                                if (sc.peek() == board[row][box]) {
                                    answer += 2;
                                    board[row][box] = 0;
                                    sc.pop();
                                    flag = false;
                                } else {
                                    sc.push(board[row][box]);
                                    board[row][box] = 0;
                                    flag = false;
                                }
                            }
                        }
                    }
                }
            }
            flag = true;
        }

        System.out.println("===============================// sc : " + sc.toString());
        System.out.println("===============================// answer : " + answer);


        return answer;
    }

    // Stack 사용
    public static int solution3(int[][] board, int[] moves) {

        int answer = 0;
        Stack<Integer> sc = new Stack<Integer>();
        for (int move : moves) {
            int pick = move - 1;
            for (int i = 0; i < board.length; i++) {
                if (board[i][pick] != 0) {
                    if (sc.isEmpty()) {
                        sc.push(board[i][pick]);
                        board[i][pick] = 0;
                    } else {
                        if (sc.peek() == board[i][pick]) {
                            answer += 2;
                            board[i][pick] = 0;
                            sc.pop();
//                            break;
                        } else {
                            sc.push(board[i][pick]);
                            board[i][pick] = 0;
                        }
                        break;
                    }
                }
            }
        }


        System.out.println("===============================// answer : " + answer);


        return answer;
    }

    public static void main(String[] args) {

        int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
        int[] moves = {1,5,3,5,1,2,1,4};

//        solution(board, moves);
//        solution2(board, moves);
        solution3(board, moves);

    }


}
