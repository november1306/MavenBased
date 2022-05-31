package other;

import inheritance.Parrot;
import inheritance.Printable;
import inheritance.PrintableExt;
import org.junit.jupiter.api.Test;

public class LambdaTest {

    static void printThing(Printable thing) {
        thing.print();
    }

    static String updateThing(PrintableExt thing) {
        return thing.print("hey ", "!");

    }


    @Test
    void parrotTest() {
        Parrot myParrot = new Parrot();
        printThing(myParrot);
    }

    @Test
    void lambdaTest() {
        Printable lambdaPrintable = () -> System.out.println("privet bro");
        lambdaPrintable.print();
//        printThing(lambdaPrintable);
    }

    @Test
    void extendedLambdaTest() {
        String text = updateThing(
                (p, s) ->
                {
                    String s1 = p + " privet bro " + s;
                    return s1;
                }
        );
        System.out.println(text);
    }

}
