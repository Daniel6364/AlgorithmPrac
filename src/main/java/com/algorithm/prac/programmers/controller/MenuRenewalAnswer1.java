package com.algorithm.prac.programmers.controller;

import java.util.*;

/**
 * @author : daniel
 * @version : 1.0.0
 * @package : com.algorithm.prac.programmers.controller
 * @name : MenuRenewal.java
 * @date : 2021-03-10 오후 3:41
 * @modifyed :
 * <p>
 * 메뉴 리뉴얼
 * 문제 설명
 * 레스토랑을 운영하던 스카피는 코로나19로 인한 불경기를 극복하고자 메뉴를 새로 구성하려고 고민하고 있습니다.
 * 기존에는 단품으로만 제공하던 메뉴를 조합해서 코스요리 형태로 재구성해서 새로운 메뉴를 제공하기로 결정했습니다.
 * 어떤 단품메뉴들을 조합해서 코스요리 메뉴로 구성하면 좋을 지 고민하던 "스카피"는
 * 이전에 각 손님들이 주문할 때 가장 많이 함께 주문한 단품메뉴들을 코스요리 메뉴로 구성하기로 했습니다.
 * 단, 코스요리 메뉴는 최소 2가지 이상의 단품메뉴로 구성하려고 합니다.
 * 또한, 최소 2명 이상의 손님으로부터 주문된 단품메뉴 조합에 대해서만 코스요리 메뉴 후보에 포함하기로 했습니다.
 * <p>
 * 예를 들어, 손님 6명이 주문한 단품메뉴들의 조합이 다음과 같다면,
 * (각 손님은 단품메뉴를 2개 이상 주문해야 하며, 각 단품메뉴는 A ~ Z의 알파벳 대문자로 표기합니다.)
 * <p>
 * 손님 번호	주문한 단품메뉴 조합
 * <p>
 * 1번 손님	    A, B, C, F, G
 * 2번 손님	    A, C
 * 3번 손님	    C, D, E
 * 4번 손님	    A, C, D, E
 * 5번 손님	    B, C, F, G
 * 6번 손님	    A, C, D, E, H
 * <p>
 * 가장 많이 함께 주문된 단품메뉴 조합에 따라 "스카피"가 만들게 될 코스요리 메뉴 구성 후보는 다음과 같습니다.
 * <p>
 * 코스 종류	    메뉴 구성	설명
 * 요리 2개 코스	A, C	    1번, 2번, 4번, 6번 손님으로부터 총 4번 주문됐습니다.
 * 요리 3개 코스	C, D, E	    3번, 4번, 6번 손님으로부터 총 3번 주문됐습니다.
 * 요리 4개 코스	B, C, F, G	1번, 5번 손님으로부터 총 2번 주문됐습니다.
 * 요리 4개 코스	A, C, D, E	4번, 6번 손님으로부터 총 2번 주문됐습니다.
 * [문제]
 * 각 손님들이 주문한 단품메뉴들이 문자열 형식으로 담긴 배열 orders,
 * "스카피"가 추가하고 싶어하는 코스요리를 구성하는 단품메뉴들의 갯수가 담긴 배열 course가 매개변수로 주어질 때,
 * "스카피"가 새로 추가하게 될 코스요리의 메뉴 구성을 문자열 형태로 배열에 담아 return 하도록
 * solution 함수를 완성해 주세요.
 * <p>
 * [제한사항]
 * orders 배열의 크기는 2 이상 20 이하입니다.
 * orders 배열의 각 원소는 크기가 2 이상 10 이하인 문자열입니다.
 * 각 문자열은 알파벳 대문자로만 이루어져 있습니다.
 * 각 문자열에는 같은 알파벳이 중복해서 들어있지 않습니다.
 * <p>
 * course 배열의 크기는 1 이상 10 이하입니다.
 * course 배열의 각 원소는 2 이상 10 이하인 자연수가 오름차순으로 정렬되어 있습니다.
 * course 배열에는 같은 값이 중복해서 들어있지 않습니다.
 * <p>
 * 정답은 각 코스요리 메뉴의 구성을 문자열 형식으로 배열에 담아 사전 순으로 오름차순 정렬해서 return 해주세요.
 * 배열의 각 원소에 저장된 문자열 또한 알파벳 오름차순으로 정렬되어야 합니다.
 * 만약 가장 많이 함께 주문된 메뉴 구성이 여러 개라면, 모두 배열에 담아 return 하면 됩니다.
 * orders와 course 매개변수는 return 하는 배열의 길이가 1 이상이 되도록 주어집니다.
 * <p>
 * [입출력 예]
 * orders	                                            course	result
 * ["ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"]	    [2,3,4]	["AC", "ACDE", "BCFG", "CDE"]
 * ["ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"]	[2,3,5]	["ACD", "AD", "ADE", "CD", "XYZ"]
 * ["XYZ", "XWY", "WXA"]	                            [2,3,4]	["WX", "XY"]
 * <p>
 * [입출력 예에 대한 설명]
 * 입출력 예 #1
 * 문제의 예시와 같습니다.
 * <p>
 * 입출력 예 #2
 * AD가 세 번, CD가 세 번, ACD가 두 번, ADE가 두 번, XYZ 가 두 번 주문됐습니다.
 * 요리 5개를 주문한 손님이 1명 있지만, 최소 2명 이상의 손님에게서 주문된 구성만 코스요리 후보에 들어가므로, 요리 5개로 구성된 코스요리는 새로 추가하지 않습니다.
 * <p>
 * 입출력 예 #3
 * WX가 두 번, XY가 두 번 주문됐습니다.
 * 3명의 손님 모두 단품메뉴를 3개씩 주문했지만, 최소 2명 이상의 손님에게서 주문된 구성만 코스요리 후보에 들어가므로,
 * 요리 3개로 구성된 코스요리는 새로 추가하지 않습니다.
 * 또, 단품메뉴를 4개 이상 주문한 손님은 없으므로, 요리 4개로 구성된 코스요리 또한 새로 추가하지 않습니다.
 **/
public class MenuRenewalAnswer1 {


    private static List<String> combination;

    public static void dfs(char[] arr, int idx, int length, int course, String addOrder) {

        if (length == course) {    // 경우의 수 추가
            combination.add(addOrder);
        }

        for (int i = idx + 1; i < arr.length; i++) {
            dfs(arr, i, length + 1, course, addOrder + arr[i]);
        }

    }


    public static String[] solution(String[] orders, int[] course) {
        String[] answer;
        combination = new ArrayList<>();

        for (String order : orders) {
            char[] orders_char = order.toCharArray();
            Arrays.sort(orders_char);

            for (int index = 0; index < orders_char.length; index++) {

                for (int j = 0; j < course.length; j++) {   // course 에 있는 모든 경우

                    int course_cnt = course[j];
                    String addOrder = String.valueOf(orders_char[index]);

                    // array, index, depth, course, addOrder
                    dfs(orders_char, index, 1, course_cnt, addOrder);
                }

            }
        }

        System.out.println("combination : " + combination.toString());

        Map<String, Integer> map = new HashMap<>();
        for (String key : combination) {
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        System.out.println("map : " + map.toString());

        List<String> keySetList = new ArrayList<>(map.keySet());
        System.out.println("keySetList 1 : " + keySetList.toString());

        Collections.sort(keySetList, (o1, o2) -> (map.get(o2).compareTo(map.get(o1))));
        System.out.println("keySetList 2 : " + keySetList.toString());


        List<String> ansList = new ArrayList<>();
        for (int cnt : course) {
            int max_value = 0;

            for (String key : keySetList) {
                if (map.get(key) >= 2 && key.length() == cnt) {
                    if (map.get(key) >= max_value) {
                        ansList.add(key);
                        max_value = map.get(key);
                    }
                }
            }
        }
        System.out.println("ansList : " + Arrays.toString(ansList.toArray()));

        Collections.sort(ansList);
        answer = new String[ansList.size()];
        ansList.toArray(answer);

        System.out.println("answer : " + Arrays.toString(answer));

        return answer;
    }


    public static void main(String[] args) {

        String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
//        String[] orders = {"XYZ", "XWY", "WXA"};
        int[] course = {2, 3, 4};

//        String[] orders = {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"};
//        String[] orders = {"XYZ", "XWY", "WXA"};
//        int[] course = {2, 3, 5};
        solution(orders, course);
    }
}
