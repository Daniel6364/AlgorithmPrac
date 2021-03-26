package com.algorithm.prac.programmers.controller.second;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author Daniel
 * @project_name AlgorithmPrac
 * @package_name com.algorithm.prac.programmers.controller.second
 * @since 2021-03-26
 * <p>
 * 기능개발
 * 문제 설명
 * 프로그래머스 팀에서는 기능 개선 작업을 수행 중입니다.
 * 각 기능은 진도가 100%일 때 서비스에 반영할 수 있습니다.
 * <p>
 * 또, 각 기능의 개발속도는 모두 다르기 때문에 뒤에 있는 기능이 앞에 있는 기능보다 먼저 개발될 수 있고,
 * 이때 뒤에 있는 기능은 앞에 있는 기능이 배포될 때 함께 배포됩니다.
 * <p>
 * 먼저 배포되어야 하는 순서대로 작업의 진도가 적힌 정수 배열 progresses와
 * 각 작업의 개발 속도가 적힌 정수 배열 speeds가 주어질 때 각 배포마다 몇 개의 기능이 배포되는지를
 * return 하도록 solution 함수를 완성하세요.
 * <p>
 * 제한 사항
 * 작업의 개수(progresses, speeds배열의 길이)는 100개 이하입니다.
 * <p>
 * 작업 진도는 100 미만의 자연수입니다.
 * 작업 속도는 100 이하의 자연수입니다.
 * 배포는 하루에 한 번만 할 수 있으며, 하루의 끝에 이루어진다고 가정합니다.
 * 예를 들어 진도율이 95%인 작업의 개발 속도가 하루에 4%라면 배포는 2일 뒤에 이루어집니다.
 * 입출력 예
 * progresses	                speeds	                return
 * [93, 30, 55]	                [1, 30, 5]	            [2, 1]
 * [95, 90, 99, 99, 80, 99]	    [1, 1, 1, 1, 1, 1]	    [1, 3, 2]
 * 입출력 예 설명
 * 입출력 예 #1
 * 첫 번째 기능은 93% 완료되어 있고 하루에 1%씩 작업이 가능하므로 7일간 작업 후 배포가 가능합니다.
 * 두 번째 기능은 30%가 완료되어 있고 하루에 30%씩 작업이 가능하므로 3일간 작업 후 배포가 가능합니다.
 * 하지만 이전 첫 번째 기능이 아직 완성된 상태가 아니기 때문에 첫 번째 기능이 배포되는 7일째 배포됩니다.
 * 세 번째 기능은 55%가 완료되어 있고 하루에 5%씩 작업이 가능하므로 9일간 작업 후 배포가 가능합니다.
 * <p>
 * 따라서 7일째에 2개의 기능, 9일째에 1개의 기능이 배포됩니다.
 * <p>
 * 입출력 예 #2
 * 모든 기능이 하루에 1%씩 작업이 가능하므로, 작업이 끝나기까지 남은 일수는
 * 각각 5일, 10일, 1일, 1일, 20일, 1일입니다.
 * 어떤 기능이 먼저 완성되었더라도 앞에 있는 모든 기능이 완성되지 않으면 배포가 불가능합니다.
 * <p>
 * 따라서 5일째에 1개의 기능, 10일째에 3개의 기능, 20일째에 2개의 기능이 배포됩니다.
 */
public class FunctionDevelopment {

    public static int[] solution(int[] progresses, int[] speeds) {

        Queue<Integer> qProgresses = new ConcurrentLinkedQueue<>();
        for (int i = 0; i < progresses.length; i++) {
            qProgresses.add(
                    (100 - progresses[i]) % speeds[i] == 0 ?
                            (100 - progresses[i]) / speeds[i] :
                            (100 - progresses[i]) / speeds[i] + 1

            );
        }

        Vector<Integer> vc = new Vector<>();
        Stack<Integer> st = new Stack<>();
        for (int cnt : qProgresses) {
            if (vc.isEmpty()) {
                vc.add(cnt);
                st.add(1);
            } else {
                /*if (vc.lastElement().compareTo(cnt) == 1) {
                    st.add(st.pop() + 1);
                } else {
                    st.add(1);
                }*/
                if (vc.lastElement() >= cnt) {
                    st.add(st.pop() + 1);
                } else {
                    st.add(1);
                }

            }
        }
        int[] answer = new int[st.size()];
        for (int i = 0; i < st.size(); i++) {
            answer[i] = st.get(i);
        }

        System.out.println(Arrays.toString(answer));

        return answer;
    }

    public static int[] solution2(int[] progresses, int[] speeds) {


        Queue<Integer> qProgresses = new ConcurrentLinkedQueue<>();
        for (int i = 0; i < progresses.length; i++) {
            qProgresses.add(
                    (100 - progresses[i]) % speeds[i] == 0 ?
                            (100 - progresses[i]) / speeds[i] :
                            (100 - progresses[i]) / speeds[i] + 1

            );
        }

        ArrayList<Integer> list = new ArrayList<>();
        int numOfFuncs = 1;
        int prevFunc = qProgresses.poll();

        while (!qProgresses.isEmpty()) {
            int curFunc = qProgresses.poll();
            if (prevFunc >= curFunc) {
                numOfFuncs++;
            } else {
                list.add(numOfFuncs);
                numOfFuncs = 1;
                prevFunc = curFunc;
            }
        }
        list.add(numOfFuncs);
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        System.out.println(Arrays.toString(answer));




        return answer;
    }



    public static void main(String[] args) {

        // #1
        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};


        /*// #2
        int[] progresses = {95, 90, 99, 99, 80, 99};
        int[] speeds = {1, 1, 1, 1, 1, 1};*/

        solution2(progresses, speeds);

    }

}
