package com.sh.app.liskov.substitution.principle.fish;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class GoodLSP_UnspeakableFishTest {
    static class Animal {}
    static interface Speakable {
         void speak();
    }
    static class Dog extends Animal implements Speakable{

        @Override
        public void speak() {
            System.out.println("멍멍");
        }
    }
    static class Cat extends Animal implements Speakable{

        @Override
        public void speak() {
            System.out.println("냐옹");
        }
    }
    static class Fish extends Animal{}

    @DisplayName("일반화 관계에서 자식 클래스는 최소한 자신의 부모 클래스에서 가능한 행위를 수행할 수 있어야 한다.")
    @Test
    public void test() throws Exception {
        // given
        List<Animal> animals = Arrays.asList(new Dog(), new Cat(), new Fish());
        // when & then
        animals.forEach((animal) -> {
            // Speakable의 책임이 없는 fish는 speak기능을 수행하지 않는다
            if(animal instanceof Speakable)
                ((Speakable) animal).speak();
        });
    }
}
