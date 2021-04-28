package com.algorithm.prac.programmers.controller.second;


/* DFS & BFS practice 

    1. DFS : Depth First Search
        : Stack
        : DFS with Recursion
    2. BFS : Breadth First Search
        : Queue

    => 인접행렬로 구현 : 그래프의 연결관계를 2차원 배열로 표현
    => 인접리스트로 구현 : 리스트 자료형을 이용해 구현


타겟 넘버
문제 설명
n개의 음이 아닌 정수가 있습니다. 이 수를 적절히 더하거나 빼서 타겟 넘버를 만들려고 합니다. 
예를 들어 [1, 1, 1, 1, 1]로 숫자 3을 만들려면 다음 다섯 방법을 쓸 수 있습니다.

-1+1+1+1+1 = 3
+1-1+1+1+1 = 3
+1+1-1+1+1 = 3
+1+1+1-1+1 = 3
+1+1+1+1-1 = 3

사용할 수 있는 숫자가 담긴 배열 numbers, 타겟 넘버 target이 매개변수로 주어질 때 숫자를 적절히 더하고 빼서 타겟 넘버를 만드는 방법의 수를 
return 하도록 solution 함수를 작성해주세요.

제한사항
주어지는 숫자의 개수는 2개 이상 20개 이하입니다.
각 숫자는 1 이상 50 이하인 자연수입니다.
타겟 넘버는 1 이상 1000 이하인 자연수입니다.

입출력 예
numbers	            target	return
[1, 1, 1, 1, 1]	    3	    5




*/

public class TargetNumber {

    public static int bfs(int[] numbers, int target, int sum, int index, String check) {

        System.out.println("==// numbers.length : " + numbers.length + " / target : " + target + " / sum : " + sum
                + " / index : " + index + " / check : " + check);

        if (index == numbers.length) {

            System.out.println("-----> index : " + index + " / numbers.length : " + numbers.length);

            if (sum == target) {
                System.out.println("\t ==> sum == target");
                return 1;
            } else {
                System.out.println("\t ==> else");
                return 0;
            }
        }

        int result = 0;

        result += bfs(numbers, target, sum + numbers[index], index + 1, "P");
        result += bfs(numbers, target, sum - numbers[index], index + 1, "M");

        System.out.println("=====// result : " + result);

        return result;
    }

    public static int dfs(int prev, int index, int[] numbers, int target, String flag) {

        if (index >= numbers.length) {
            if (target == prev) {
                return 1;
            } else {
                return 0;
            }
        }

        int current1 = prev + numbers[index];
        int current2 = prev - numbers[index];

        int result = 0;
        result += dfs(current1, index + 1, numbers, target, "A");
        result += dfs(current2, index + 1, numbers, target, "B");

        return result;

    }

    public static int solution(int[] numbers, int target) {

        int answer = 0;

        int current = numbers[0];
        
        answer += dfs(current, 1, numbers, target, "A");
        
        answer += dfs(-current, 1, numbers, target, "B");

        System.out.println("answer : " + answer);

        return answer;

    }

    public static void main(String[] args) {

        int[] numbers = { 1, 1, 1, 1, 1 };
        int target = 3;
        solution(numbers, target);

    }

}
