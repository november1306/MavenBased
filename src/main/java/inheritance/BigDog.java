package inheritance;

public class BigDog extends Dog {
    BigDog(String name) {
        super(name);
    }

    @Override
    public void greets() {
        System.out.println("Woow");
    }

    @Override
    public void greets(Dog another) {
        System.out.println("Woooow");
    }

    public void greets(BigDog another) {
        System.out.println("Woooooooow");
    }
}
