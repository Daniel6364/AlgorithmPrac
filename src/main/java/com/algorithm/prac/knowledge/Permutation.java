package com.algorithm.prac.knowledge;

import java.util.Arrays;

/**
 * @author Daniel
 * @project_name AlgorithmPrac
 * @package_name com.algorithm.prac.knowledge
 * @since 2021-03-16
 *
 * 순열 알고리즘
 * perm(int[] arr, int depth, int n, int k)
 *
 * arr
 * 데이터를 교환되고 있는 배열
 *
 * depth
 * 위의 트리 구조에서 어떤 깊이에서 교환작업을 하고 잇는지에 대한 변수
 *
 * n
 * 배열안에 들어있는 숫자로 고정값으로 위의 사진에서는 3으로 고정되어 있다.
 *
 * k
 * 몇개를 뽑아내서 순열을 만들것인가이다.
 * 현재 같은 경우는 3개를 뽑아서 3개 모두 사용해 순열하기 때문에 3으로 고정되어 있다.
 *
 */
public class Permutation {

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
//        ar
    }

    public static void perm(int[] arr, int depth, int staticCnt, int num) {

        if (depth == num) {
            System.out.println(Arrays.toString(arr));
            return;
        }

        for (int i = depth; i < num; i++) {
            swap(arr, i, depth);


        }


    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        perm(arr, 0, arr.length, arr.length);
    }

}
