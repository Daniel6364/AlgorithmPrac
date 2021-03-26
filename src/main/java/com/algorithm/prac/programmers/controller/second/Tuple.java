package com.algorithm.prac.programmers.controller.second;

import java.util.*;

/**
 * @author Daniel
 * @project_name AlgorithmPrac
 * @package_name com.algorithm.prac.programmers.controller.second
 * @since 2021-03-26
 *
 *
 * 튜플
 * 문제 설명
 * 셀수있는 수량의 순서있는 열거 또는 어떤 순서를 따르는 요소들의 모음을 튜플(tuple)이라고 합니다.
 * n개의 요소를 가진 튜플을 n-튜플(n-tuple)이라고 하며, 다음과 같이 표현할 수 있습니다.
 *
 * (a1, a2, a3, ..., an)
 * 튜플은 다음과 같은 성질을 가지고 있습니다.
 *
 * 중복된 원소가 있을 수 있습니다. ex : (2, 3, 1, 2)
 * 원소에 정해진 순서가 있으며, 원소의 순서가 다르면 서로 다른 튜플입니다. ex : (1, 2, 3) ≠ (1, 3, 2)
 * 튜플의 원소 개수는 유한합니다.
 * 원소의 개수가 n개이고, 중복되는 원소가 없는 튜플 (a1, a2, a3, ..., an)이 주어질 때
 * (단, a1, a2, ..., an은 자연수), 이는 다음과 같이 집합 기호 '{', '}'를 이용해 표현할 수 있습니다.
 *
 * {{a1}, {a1, a2}, {a1, a2, a3}, {a1, a2, a3, a4}, ... {a1, a2, a3, a4, ..., an}}
 * 예를 들어 튜플이 (2, 1, 3, 4)인 경우 이는
 *
 * {{2}, {2, 1}, {2, 1, 3}, {2, 1, 3, 4}}
 * 와 같이 표현할 수 있습니다. 이때, 집합은 원소의 순서가 바뀌어도 상관없으므로
 *
 * {{2}, {2, 1}, {2, 1, 3}, {2, 1, 3, 4}}
 * {{2, 1, 3, 4}, {2}, {2, 1, 3}, {2, 1}}
 * {{1, 2, 3}, {2, 1}, {1, 2, 4, 3}, {2}}
 * 는 모두 같은 튜플 (2, 1, 3, 4)를 나타냅니다.
 *
 * 특정 튜플을 표현하는 집합이 담긴 문자열 s가 매개변수로 주어질 때,
 * s가 표현하는 튜플을 배열에 담아 return 하도록 solution 함수를 완성해주세요.
 *
 * [제한사항]
 * s의 길이는 5 이상 1,000,000 이하입니다.
 * s는 숫자와 '{', '}', ',' 로만 이루어져 있습니다.
 * 숫자가 0으로 시작하는 경우는 없습니다.
 * s는 항상 중복되는 원소가 없는 튜플을 올바르게 표현하고 있습니다.
 * s가 표현하는 튜플의 원소는 1 이상 100,000 이하인 자연수입니다.
 * return 하는 배열의 길이가 1 이상 500 이하인 경우만 입력으로 주어집니다.
 *
 * [입출력 예]
 * s	                            result
 * "{{2},{2,1},{2,1,3},{2,1,3,4}}"	[2, 1, 3, 4]
 * "{{1,2,3},{2,1},{1,2,4,3},{2}}"	[2, 1, 3, 4]
 * "{{20,111},{111}}"	            [111, 20]
 * "{{123}}"	                    [123]
 * "{{4,2,3},{3},{2,3,4,1},{2,3}}"	[3, 2, 4, 1]
 *
 */
public class Tuple {

    public static int[] solution(String s) {

        System.out.println("s : " + s);

        String tmp = s.substring(1, s.length() - 1);
        String tmp2 = tmp.replace("{", "}");
        String tmp3 = tmp2.replaceAll(",}", "");
        String tmp4 = tmp3.substring(1);

        String[] strArr = tmp4.split("}");
        Arrays.sort(strArr, (a, b) -> (a.length() - b.length()));

        Stack<Integer> st = new Stack<>();
        for (String el : strArr) {

            String[] tmpArr = el.split(",");
            for (String el2 : tmpArr) {

                int tmpInt = Integer.parseInt(el2.toString());
                if (st.isEmpty()) {
                    st.add(tmpInt);
                } else {
                    if (!st.contains(tmpInt)) {
                        st.add(tmpInt);
                    }
                }
            }
        }

        int[] answer = new int[st.size()];
        for (int i = 0; i < st.size(); i++) {
            answer[i] = st.get(i);
        }

        System.out.println(Arrays.toString(answer));

        /*
        String str = s.replace("{", "").replace("}", "");
        String[] arr = str.split(",");
        Stack<Integer> st = new Stack<>();
        for (String el : arr) {
            if (st.isEmpty()) {
                st.add(Integer.parseInt(el.toString()));
            } else {
                if (!st.contains(Integer.parseInt(el.toString()))) {
                    st.add(Integer.parseInt(el.toString()));
                }
            }
        }
        int[] answer = new int[st.size()];
        for (int i = 0; i < st.size(); i++) {
            answer[i] = st.get(i);
        }

        System.out.println(Arrays.toString(answer));
*/

//        int[] answer = {};


        return answer;
    }



    public static int[] solution2(String s) {

        System.out.println("s : " + s);

        Set<String> set = new HashSet<>();
        String[] arr = s.replaceAll("[{}]", " ").trim().split(" , ");
        Arrays.sort(arr, (a, b) -> (a.length() - b.length()));

        int[] answer = new int[arr.length];
        int idx = 0;
        for (String str : arr) {
            for (String str2 : str.split(",")) {
                if (set.add(str2)) {
                    System.out.println(idx);
                    answer[idx++] = Integer.parseInt(str2);
                    System.out.println(idx);
                }
            }
        }

        System.out.println("answer : " + Arrays.toString(answer));



        return answer;
    }


    public static void main(String[] args) {

//        String s = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
        String s = "{{1,2,3},{2,1},{1,2,4,3},{2}}";
        solution2(s);
    }
}
