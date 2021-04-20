package com.algorithm.prac.test;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

/**
* @package : com.algorithm.prac.test
* @name : test3.java
* @date : 2021/04/03 14:12
* @author : daniel
* @version : 1.0.0
* @modifyed :
 *
 *
 *
 *전체 역의 개수 n,
 * 1번부터 n번 역까지 일일 이용객 수 passenger,
 * 역 사이의 철로 연결 정보 train이 매개변수로 주어질 때,
 * 종착역으로 지정할 역 번호와 그때의 이용객 수 합을 순서대로 배열에 담아 return 하도록 solution 함수를 완성해주세요.
 *
**/
public class test3 {


    public static int[] solution(int n, int[] passenger, int[][] train) {
        int[] answer = {};

        HashSet<Integer> xStation = new HashSet<>();
        HashSet<Integer> yStation = new HashSet<>();

        for (int[] station : train) {
            for (int i = 0; i < station.length; i++) {
                if (station[0] == 1) {
                    yStation.add(station[1]);
                }
            }
        }
        System.out.println("xStation : " + Arrays.toString(xStation.toArray()));
        System.out.println("yStation : " + Arrays.toString(yStation.toArray()));

        xStation.add(1);











        return answer;
    }

    public static void main(String[] args) {

        int n = 4;
        int[] passenger = {2,1,2,2};
        int[][] train = {{1,2},{1,3},{2,4}};

        /*int n = 5;
        int[] passenger = {1,1,2,3,4};
        int[][] train = {{1,2},{1,3},{1,4},{1,5}};*/


        solution(n, passenger, train);
    }
}
