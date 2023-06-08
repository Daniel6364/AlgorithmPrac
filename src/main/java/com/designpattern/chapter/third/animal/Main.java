package com.designpattern.chapter.third.animal;

public class Main {

    public static void main(String[] args) {
        HelloAnimal helloAnimal = new HelloAnimal();

        Animal cat = new Animal("cat");
        Animal dog = new Animal("dog");

        helloAnimal.hello(cat);
        helloAnimal.hello(dog);
    }

}
