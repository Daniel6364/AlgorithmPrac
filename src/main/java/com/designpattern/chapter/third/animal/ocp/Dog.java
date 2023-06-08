package com.designpattern.chapter.third.animal.ocp;

public class Dog extends AnimalOcp {
    @Override
    void speak() {
        System.out.println("멍!멍!~~~");
        dogType();
    }


    void dogType() {
        System.out.println("나는 허스키");
    }
}
