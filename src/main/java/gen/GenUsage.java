package gen;


import inheritance.Animal;
import inheritance.Cat;
import inheritance.Pet;
import inheritance.Wolf;

import java.util.ArrayList;
import java.util.List;

public class GenUsage {

    public static void main(String[] args) {

        shout(new Cat("Barsik"));

        Animal animal = new Cat("Tom");

        List<Animal> animalList = new ArrayList<>();
        List<Cat> cats = new ArrayList<>();
        printList(animalList);
        printList(cats);
    }

    public static <Type extends Animal & Pet> void shout(Type voiceLine) {
        System.out.println(voiceLine + "!!!!");
    }


    private static void printList(List<? extends Animal> myList) {
        for (Animal item : myList) {
            System.out.println(item);
        }

    }
}
