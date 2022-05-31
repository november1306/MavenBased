package inheritance;


public class Parrot implements Printable {

    String name;
    int age;

    @Override
    public void print() {
        System.out.println("chirik");
    }
}
