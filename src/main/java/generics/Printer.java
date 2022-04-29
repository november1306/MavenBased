package generics;

public class Printer <T> {
    T somethingToPrint;


    public Printer (T somethingToPrint) {
        this.somethingToPrint = somethingToPrint;
    }

    public void print(){
        System.out.println(somethingToPrint.toString());
    }
}
