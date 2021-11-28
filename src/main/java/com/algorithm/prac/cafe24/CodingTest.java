package com.algorithm.prac.cafe24;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class CodingTest {


    /*문제 설명
    어느날 종이를 주웠는데

        1
        3 5 7
        9 11 13 15 17 (v)
        19 21 23 25 27 29 31
        19 21 23 25 27 29 31 33 35

        ...
    이런 식으로 노트에 적혀있었다고 합니다.

    n 번째 줄을 입력 하였을 때, 그 줄의 마지막 3개 수의 합을 출력하는 프로그램을 작성하십시오.

    입력 : 정수 n ( 2 ≤ n ≤ 1000 )

    출력 : n번째 줄 마지막 3개 수의 합*/
    public static int solution1(int n) {
        int answer = 0;

        List<int[]> list = new ArrayList<>();

        int s = 1;
        for (int i = 1; i <= n * 2; i = i + 2) {
            int[] tmpArr = new int[i];
            for (int j = 0; j < i; j++) {
                tmpArr[j] = s;
                s += 2;
            }
            list.add(tmpArr);
        }
        int[] arrAnswer = list.get(n - 1);
        for (int i = (arrAnswer.length - 1); i >= (arrAnswer.length - 1)-2; i--) {
            System.out.println(arrAnswer[i]);
            answer += arrAnswer[i];
        }

        System.out.println("answer : " + answer);

        return answer;
    }

    /*자신의 국어 수학 영어 3 과목의 시험 성적을 확인했습니다.
    평균과 등급을 구할 수 있는 프로그램을 작성하십시오.

    평균은 소수점 2 번째 자리까지만(3 번째 자리에서 반올림) 출력하며
    등급은 평균 90점 이상일 경우 A,
    90점 미만 80점 이상인 경우 B,
    80점 미만 70점 이상이 C,
    70점 미만 60점 이상이 D이고
    60점 미만으로는 F입니다.

    점수의 평균은 소수점 2번째 자리까지 표시하며,
    리턴값은 모두 String 형식으로 반환합니다.

    입력 : 국어 영어 수학 순으로 점수 입력(각 과목 당 100점 만점)

    출력 : 평균, 등급*/
    public static String[] solution2(int[] numArr) {
        String[] answer = new String[2];

        double sum = 0;
        for (double num : numArr) sum += num;

        double round = Math.round((sum / numArr.length) * 100);
        double avg = round / 100;
        String avgStr = String.format("%.2f", avg);
        answer[0] = avgStr;

        String grade;
        if (avg >= 90) {
            grade = "A";
        } else if (avg < 90 && avg >= 80) {
            grade = "B";
        } else if (avg < 80 && avg >= 70) {
            grade = "C";
        } else if (avg < 70 && avg >= 60) {
            grade = "D";
        } else {
            grade = "F";
        }
        answer[1] = grade;

        System.out.println(Arrays.toString(answer));

        return answer;
    }

    /*주어진 둘레의 길이로 만들 수 있는 삼각형의 개수를 구하는 프로그램을 작성하십시오.

    예를 들어 삼각형의 둘레의 길이가 9m라고 하면,

    한 변의 길이가 1m, 두 변의 길이가 4m인 삼각형

    한 변의 길이가 2m, 다른 변의 길이가 3m, 나머지 변의 길이가 4m인 삼각형

    세 변의 길이가 모두 3m인 삼각형

    총 3가지 삼각형을 만들 수 있습니다.

    입력 : 삼각형 둘레의 길이( 1이상 100이하 )

    출력 : 만들어질 수 있는 서로 다른 삼각형의 수*/
    public static int solution3(int size) {
        int answer = 0;

        for (int a = 1; a <= size / 3; a++) {
            for (int b = (size - a) / 2; b >= a; b--) {
                int c = size - a - b;
                if (c < a + b) {
                    answer++;
                } else {
                    break;
                }
            }
        }

        System.out.println("answer : " + answer);

        return answer;
    }

    /*입력된 숫자가 홀수인지 짝수인지를 판별하는 것이 목표입니다.
    홀수인 경우 "홀", 짝수인 경우 "짝"을 리턴하는 프로그램을 작성하십시오.

    입력 : 자연수 입력

    출력 : 홀수일 경우 홀, 짝수일 경우 짝 출력*/
    public static String solution4(int num) {
        String answer = "";

        if (num % 2 == 1) {
            answer = "홀";
        } else {
            answer = "짝";
        }

        System.out.println("answer : " + answer);

        return answer;
    }


    public static void main(String[] args) {

        // 1번 문제
        int n = 4;
        solution1(n);


        // 2번 문제
//        int[] numArr = {79, 80, 95};
        int[] numArr = {100, 100, 100};
//        solution2(numArr);

        // 3번 문제
        int size = 9;
//        solution3(size);

        // 4번 문제
//        int num = 7;
//        int num = 1;
        int num = 368;
//        solution4(num);


    }


}
