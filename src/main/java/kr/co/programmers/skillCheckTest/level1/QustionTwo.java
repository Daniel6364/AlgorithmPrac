package kr.co.programmers.skillCheckTest.level1;

public class QustionTwo {

    public static int solution(int[] numbers) {
        int answer = 0;

        int tmpNum = 0;
        for (int number : numbers) {
            tmpNum += number;
        }
        answer = 45 - tmpNum;

        System.out.println("answer : " + answer);

        return answer;
    }

    public static void main(String[] args) {

        int[] numbers = {1,2,3,4,6,7,8,0};
        solution(numbers);
    }
}
