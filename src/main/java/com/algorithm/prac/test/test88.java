package com.algorithm.prac.test;

import org.springframework.web.bind.annotation.RequestParam;

import java.text.SimpleDateFormat;
import java.util.Date;

public class test88 {


    //@RequestParam
    public static void main(String[] args) {

        System.out.println("hello");

        String time = "2021-04-10 12:14:22";
        String today = "";
        if (time.equals("")) {
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
            today = sdf.format(date);
        } else {
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
            today = sdf.format(date);
        }



        System.out.println("today : " + today);
    }
}
