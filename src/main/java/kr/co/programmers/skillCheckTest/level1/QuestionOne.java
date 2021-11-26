package kr.co.programmers.skillCheckTest.level1;

public class QuestionOne {


    public static int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;

        for (int i = 0; i < signs.length; i++) {
            if (signs[i]) {
                System.out.println(absolutes[i]);
                answer += absolutes[i];
            } else {
                System.out.println((-absolutes[i]));
                answer += (-absolutes[i]);
            }
        }
        System.out.println("answer : " + answer);

        return answer;
    }

    public static void main(String[] args) {

        int[] absolutes = {4, 7, 12};
        boolean[] signs = {true, false, true};

        
        solution(absolutes, signs);
        
    }

}
