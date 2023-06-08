package com.designpattern.chapter.third.animal;

public class HelloAnimal {

    public void hello(Animal animal) {
        if (animal.type.equals("cat")) {
            System.out.println("냐옹~");
        } else if (animal.type.equals("dog")) {
            System.out.println("멍!멍!");
        }
    }

}
