package gen;

public class DoublePrinter {
    private Double somethingToPrint;

    public DoublePrinter(Double somethingToPrint) {
        this.somethingToPrint = somethingToPrint;
    }

    public void print() {
        System.out.println(somethingToPrint.toString());
    }
}
