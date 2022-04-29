package generics;

import api.pojo.User;
import inheritance.Animal;
import utils.Calculator;

import java.util.ArrayList;
import java.util.List;

public class GenericsExample {

    public static void main(String[] args) {
        Printer<Integer> printer = new Printer<>(22);
        printer.print();

        Printer<Boolean> boolPrinter = new Printer<>(true);
        boolPrinter.print();
        ArrayList<User> usersList = new ArrayList<>();
        usersList.add(new User());

        shout("Gena", 34);

    }

    private static <T, V> void shout (T thingToshout, V otherShout) {
        System.out.println(thingToshout + "!!");
        System.out.println(otherShout + "!!11");
    }

    private static void printList(List<? extends Animal> myList) {
        for (Animal item : myList) {
            System.out.println(item);
        }

    }
}
