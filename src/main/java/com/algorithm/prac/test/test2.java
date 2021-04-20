package com.algorithm.prac.test;

import java.util.*;

/**
 * @author : daniel
 * @version : 1.0.0
 * @package : com.algorithm.prac.test
 * @name : test2.java
 * @date : 2021/04/03 13:26
 * @modifyed :
 * <p>
 * <p>
 * <p>
 * 완제품을 만드는 데 필요한 부품의 정보 = needs
 * 최대로 구매 가능한 로봇 수 = r
 * <p>
 * 최대 몇 종류의 완제품을 만들 수 있나
 **/
public class test2 {


    public static int solution(int[][] needs, int r) {

        int answer = 0;

        String[] needsArr = new String[needs.length];
        TreeSet<String> set = new TreeSet<>();

        int idx = 0;
        for (int[] need : needs) {
            String needStr = "";
            for (int i = 0; i < need.length; i++) {
                needStr += need[i];
            }
            needsArr[idx] = needStr;
            set.add(needStr);
            idx++;
        }

        List<Integer> result = new ArrayList<>();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            String value = it.next().toString();
            int count = 0;
            for (String need : needsArr) {
                if (value.equals(need)) {
                    count++;
                }
            }
            result.add(count);
        }


        for (int i = r; i < result.size(); i++) {
            answer += result.get(i);
        }



        System.out.println("needsArr : " + Arrays.toString(needsArr));
        System.out.println("set : " + Arrays.toString(set.toArray()));
        System.out.println("result : " + Arrays.toString(result.toArray()) + " / " + result.size() );
        System.out.println("answer : " + answer);





        return answer;
    }

    public static void main(String[] args) {


        int[][] needs = {{1, 0, 0}, {1, 1, 0}, {1, 1, 0}, {1, 0, 1}, {1, 1, 0}, {0, 1, 1}};
        int r = 2;

        solution(needs, r);

    }
}
