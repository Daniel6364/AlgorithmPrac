package com.algorithm.prac.programmers.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author : daniel
 * @version : 1.0.0
 * @package : com.algorithm.prac.programmers.controller
 * @name : SkillTree.java
 * @date : 2021/03/07 18:25
 * @modifyed :
 * <p>
 * <p>
 * [스킬트리]
 * 문제 설명
 * 선행 스킬이란 어떤 스킬을 배우기 전에 먼저 배워야 하는 스킬을 뜻합니다.
 * <p>
 * 예를 들어 선행 스킬 순서가 스파크 → 라이트닝 볼트 → 썬더일때, 썬더를 배우려면 먼저 라이트닝 볼트를 배워야 하고,
 * 라이트닝 볼트를 배우려면 먼저 스파크를 배워야 합니다.
 * <p>
 * 위 순서에 없는 다른 스킬(힐링 등)은 순서에 상관없이 배울 수 있습니다.
 * 따라서 스파크 → 힐링 → 라이트닝 볼트 → 썬더와 같은 스킬트리는 가능하지만,
 * 썬더 → 스파크나 라이트닝 볼트 → 스파크 → 힐링 → 썬더와 같은 스킬트리는 불가능합니다.
 * <p>
 * 선행 스킬 순서 skill과 유저들이 만든 스킬트리1를 담은 배열 skill_trees가 매개변수로 주어질 때,
 * 가능한 스킬트리 개수를 return 하는 solution 함수를 작성해주세요.
 * <p>
 * [제한 조건]
 * 스킬은 알파벳 대문자로 표기하며, 모든 문자열은 알파벳 대문자로만 이루어져 있습니다.
 * 스킬 순서와 스킬트리는 문자열로 표기합니다.
 * 예를 들어, C → B → D 라면 "CBD"로 표기합니다
 * 선행 스킬 순서 skill의 길이는 1 이상 26 이하이며, 스킬은 중복해 주어지지 않습니다.
 * <p>
 * skill_trees는 길이 1 이상 20 이하인 배열입니다.
 * skill_trees의 원소는 스킬을 나타내는 문자열입니다.
 * skill_trees의 원소는 길이가 2 이상 26 이하인 문자열이며, 스킬이 중복해 주어지지 않습니다.
 * <p>
 * [입출력 예]
 * skill	skill_trees	return
 * "CBD"	["BACDE", "CBADF", "AECB", "BDA"]	2
 * <p>
 * [입출력 예 설명]
 * "BACDE": B 스킬을 배우기 전에 C 스킬을 먼저 배워야 합니다. 불가능한 스킬트립니다.
 * "CBADF": 가능한 스킬트리입니다.
 * "AECB": 가능한 스킬트리입니다.
 * "BDA": B 스킬을 배우기 전에 C 스킬을 먼저 배워야 합니다. 불가능한 스킬트리입니다.
 **/
public class SkillTree {

    public static int solution(String skill, String[] skill_trees) {

        System.out.println("==// solution");

        int answer = skill_trees.length;

        LinkedList<String> list = new LinkedList<>();
        for (int i = 0; i < skill.length(); i++) {
            list.add(skill.substring(i, i + 1));
        }

        int checkCnt = 0;
        for (String skillTrees : skill_trees) {

            checkCnt = 0;
            for (int i = 0; i < skillTrees.length(); i++) {

                if (list.contains(skillTrees.substring(i, i + 1))) {

                    if (checkCnt == list.indexOf(skillTrees.substring(i, i + 1))) {
                        checkCnt++;
                    } else {
                        answer--;
                        break;
                    }
                }
            }
        }
        System.out.println("answer : " + answer);

        return answer;
    }

    public static int solution2(String skill, String[] skill_trees) {

        System.out.println("==// solution2");

        int answer = 0;

        ArrayList<String> skillTrees = new ArrayList<>(Arrays.asList(skill_trees));
        Iterator<String> it = skillTrees.iterator();

        while(it.hasNext()) {
            if (skill.indexOf(it.next().replaceAll("[^" + skill + "]", "")) != 0) {
                it.remove();
            }
        }
        answer = skillTrees.size();
        System.out.println("answer : " + answer);

        return answer;
    }

    public static void main(String[] args) {

        String skill = "CBD";
        String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};
        solution2(skill, skill_trees);

    }
}
