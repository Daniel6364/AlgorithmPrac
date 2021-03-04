package com.algorithm.prac.programmers.controller;

import java.util.Stack;

/**
 * @author Daniel
 * @project_name AlgorithmPrac
 * @package_name com.algorithm.prac.controller
 * @since 2021-03-03
 * <p>
 * 문제 설명
 * 배열 arr가 주어집니다.
 * 배열 arr의 각 원소는 숫자 0부터 9까지로 이루어져 있습니다.
 * 이때, 배열 arr에서 연속적으로 나타나는 숫자는 하나만 남기고 전부 제거하려고 합니다.
 * 단, 제거된 후 남은 수들을 반환할 때는 배열 arr의 원소들의 순서를 유지해야 합니다.
 * 예를 들면,
 * <p>
 * arr = [1, 1, 3, 3, 0, 1, 1] 이면 [1, 3, 0, 1] 을 return 합니다.
 * arr = [4, 4, 4, 3, 3] 이면 [4, 3] 을 return 합니다.
 * 배열 arr에서 연속적으로 나타나는 숫자는 제거하고 남은 수들을 return 하는 solution 함수를 완성해 주세요.
 * <p>
 * 제한사항
 * 배열 arr의 크기 : 1,000,000 이하의 자연수
 * 배열 arr의 원소의 크기 : 0보다 크거나 같고 9보다 작거나 같은 정수
 * <p>
 * 입출력 예
 * arr	            answer
 * [1,1,3,3,0,1,1]	[1,3,0,1]
 * [4,4,4,3,3]
 */
public class DontLikeSameNum {

    public static int[] solution(int[] arr) {

        Stack<Integer> st = new Stack<>();
        for (int val : arr) {

            if (st.empty()) {
                st.add(val);
            } else if (st.lastElement() != val) {
                st.add(val);
            }
        }
        int[] answer = new int[st.size()];
        for (int i = 0; i < st.size(); i++) {
            answer[i] = st.get(i);
        }

        return answer;

    }


    public static void main(String[] args) {

        int[] arr = {1, 1, 3, 3, 0, 1, 1};
        solution(arr);
    }

}
