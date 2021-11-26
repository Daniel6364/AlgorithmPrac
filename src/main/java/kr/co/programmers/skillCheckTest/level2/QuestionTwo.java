package kr.co.programmers.skillCheckTest.level2;

/*
*
* 문제 설명
n개의 음이 아닌 정수가 있습니다. 이 수를 적절히 더하거나 빼서 타겟 넘버를 만들려고 합니다.
* 예를 들어 [1, 1, 1, 1, 1]로 숫자 3을 만들려면 다음 다섯 방법을 쓸 수 있습니다.

-1+1+1+1+1 = 3
+1-1+1+1+1 = 3
+1+1-1+1+1 = 3
+1+1+1-1+1 = 3
+1+1+1+1-1 = 3
* 사용할 수 있는 숫자가 담긴 배열 numbers,
* 타겟 넘버 target이 매개변수로 주어질 때 숫자를 적절히 더하고 빼서 타겟 넘버를 만드는 방법의 수를
* return 하도록 solution 함수를 작성해주세요.

제한사항
주어지는 숫자의 개수는 2개 이상 20개 이하입니다.
각 숫자는 1 이상 50 이하인 자연수입니다.
타겟 넘버는 1 이상 1000 이하인 자연수입니다.

* 입출력 예
numbers         target	return
[1, 1, 1, 1, 1]	3	    5

* 입출력 예 설명
문제에 나온 예와 같습니다.
*
* */

import java.util.Arrays;

public class QuestionTwo {

    private static int count = 0;

    public static void dfs(int[] numbers, int depth, int target, int result, String flag) {

        System.out.println("=========// " + flag);
        System.out.println("depth : " + depth);
        System.out.println("result : " + result);

        if (depth == numbers.length) {
            System.out.println("in if 1)");
            if (target == result) {
                count++;
            }
            return;
        }


        int add = result + numbers[depth];
        int sub = result - numbers[depth];

        System.out.println("add : " + add + " / sub : " + sub);

        dfs(numbers, depth + 1, target, add, "add");
        dfs(numbers, depth + 1, target, sub, "sub");

    }

    public static int solution(int[] numbers, int target) {
        int answer = 0;

        dfs(numbers, 0, target, 0, "init");
        answer = count;
        System.out.println("answer : " + answer);

        return answer;
    }

    public static void main(String[] args) {

        int[] numbers = {1, 1, 1, 1, 1};
        int target = 3;

        solution(numbers, target);
    }

}
