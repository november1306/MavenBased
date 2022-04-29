package gen;

import inheritance.Animal;
import inheritance.Pet;

public class Printer <K extends Animal, V> {

    K printName;
    V printValue;


    public Printer (K printName, V printValue) {
        this.printName = printName;
        this.printValue = printValue;
    }

    public void print (){
        System.out.println(printName.toString() + "has value  "+ printValue);
    }
}
