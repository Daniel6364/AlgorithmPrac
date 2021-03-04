package com.algorithm.prac.programmers.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RecommendId {
/*
1단계 new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.


예를 들어, new_id 값이 ...!@BaT#*..y.abcdefghijklm 라면, 위 7단계를 거치고 나면 new_id는 아래와 같이 변경됩니다.

1단계 대문자 'B'와 'T'가 소문자 'b'와 't'로 바뀌었습니다.
"...!@BaT#*..y.abcdefghijklm" → "...!@bat#*..y.abcdefghijklm"

2단계 '!', '@', '#', '*' 문자가 제거되었습니다.
"...!@bat#*..y.abcdefghijklm" → "...bat..y.abcdefghijklm"

3단계 '...'와 '..' 가 '.'로 바뀌었습니다.
"...bat..y.abcdefghijklm" → ".bat.y.abcdefghijklm"

4단계 아이디의 처음에 위치한 '.'가 제거되었습니다.
".bat.y.abcdefghijklm" → "bat.y.abcdefghijklm"

5단계 아이디가 빈 문자열이 아니므로 변화가 없습니다.
"bat.y.abcdefghijklm" → "bat.y.abcdefghijklm"

6단계 아이디의 길이가 16자 이상이므로, 처음 15자를 제외한 나머지 문자들이 제거되었습니다.
"bat.y.abcdefghijklm" → "bat.y.abcdefghi"

7단계 아이디의 길이가 2자 이하가 아니므로 변화가 없습니다.
"bat.y.abcdefghi" → "bat.y.abcdefghi"

따라서 신규 유저가 입력한 new_id가 ...!@BaT#*..y.abcdefghijklm일 때, 네오의 프로그램이 추천하는 새로운 아이디는 bat.y.abcdefghi 입니다.


[입출력 예]
no	new_id	                        result
예1	"...!@BaT#*..y.abcdefghijklm"	"bat.y.abcdefghi"
예2	"z-+.^."	                    "z--"
예3	"=.="	                        "aaa"
예4	"123_.def"	                    "123_.def"
예5	"abcdefghijklmn.p"	            "abcdefghijklmn"

*/

    public static String solution(String new_id) {

        System.out.println("==// solution");
        System.out.println("==// new_id : " + new_id);

        // 1 step
        String newId = new_id.toLowerCase();
        System.out.println("==// 1. step : " + newId);

        // 2 step
//        String regEx = "^*[^a-z^0-9^.^-^_]";
        String regEx = "[^a-z0-9-_.]";
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(newId);
        while (matcher.find()) {
            newId = matcher.replaceAll("");
        }
        System.out.println("==// 2. step : " + newId);

        // 3 step
        String regEx2 = "([.]+)";
        Pattern pattern2 = Pattern.compile(regEx2);
        Matcher matcher2 = pattern2.matcher(newId);
        while (matcher2.find()) {
            newId = matcher2.replaceAll(".");
        }
        System.out.println("==// 3. step : " + newId);

        // 4 step
        String regEx3 = "^[.]|[.]$";
        Pattern pattern3 = Pattern.compile(regEx3);
        Matcher matcher3 = pattern3.matcher(newId);
        while (matcher3.find()) {
            newId = matcher3.replaceAll("");
        }
        System.out.println("==// 4. step : " + newId);

        // 5 step
        newId = newId.replace(" ", "a");
        System.out.println("==// 5. step : " + newId);

        // 6 step
        if (newId.length() >= 16) {
            newId = newId.substring(0, 15);
        }
        System.out.println("==// 6-1. step : " + newId);

        String regEx5 = "[.]$";
        Pattern pattern5 = Pattern.compile(regEx5);
        Matcher matcher5 = pattern5.matcher(newId);
        while (matcher5.find()) {
            newId = matcher5.replaceAll("");
        }
        System.out.println("==// 6-2. step : " + newId);

        // 7 step
        if (newId.length() > 0 && newId.length() <= 2) {
            for (int i = newId.length() - 1; i < 2; i++) {
                newId += newId.substring(newId.length() - 1);
            }
        } else if (newId.length() == 0) {
            for (int i = 0; i < 3; i++) {
                newId += "a";
            }
        }
        System.out.println("==// 7. step : " + newId);

        String answer = newId;
        return answer;
    }

    /*===============================================================*/
    /*[다른사람 플이]*/
    public static String solution2(String new_id) {

        System.out.println("new_id : " + new_id);

        String newId = new_id.toLowerCase();
        newId = newId.replaceAll("[^0-9a-z-_.]", "");
        newId = newId.replaceAll("[.]{2,}", ".");
        newId = newId.replaceAll("^[.]|[.]$", "");

        if (newId.equals("")) {
            newId += "a";
        }

        if (newId.length() >= 16) {
            newId = newId.substring(0, 15);
            newId = newId.replaceAll("^[.]|[.]$", "");
        }

        if (newId.length() <= 2) {
            while(newId.length() < 3) {
                newId += newId.charAt(newId.length() - 1);
            }
        }


        System.out.println("newId : " + newId);

        String answer = newId;
        return answer;
    }


    public static void main(String[] args) {

//        String new_id = "...!@BaT#*..y.abcdefghijklm";
//        String new_id = "...!@BaT#*..y.abcdefgh.jklm";
//        String new_id = "...!@BaT#*..y.abcdefgh.jkl.";
//        String new_id = "123_.def";
//        String new_id = "z-+.^.";
        String new_id = "=.=";

        solution2(new_id);


    }


}
