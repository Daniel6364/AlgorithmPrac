package com.designpattern.chapter.third.animal.ocp;

public class MainOcp {

    public static void main(String[] args) {
        HelloAnimalOcp ocp = new HelloAnimalOcp();

        AnimalOcp cat = new Cat();
        AnimalOcp dog = new Dog();

        ocp.hello(cat);
        ocp.hello(dog);
    }
}
