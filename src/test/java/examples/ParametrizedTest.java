package examples;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import utils.Calculator;
import utils.PropertyReader;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParametrizedTest {

    @Test
    void checkBrowserParam() {
        List<String> arrList = new ArrayList<>();
        arrList.add("one");
        arrList.add("two");
        Set<String> treeSet = new TreeSet<>(arrList);
        Set<String> hashSet = new HashSet<>();
        hashSet = treeSet;

        System.out.println(hashSet);
        Properties properties = PropertyReader.getProperties();
        String propBrowser = properties.get("browser").toString();


        String paramBrowser = System.getProperty("browser");

        System.out.println("console browser = " + paramBrowser);


        assertEquals(propBrowser, paramBrowser);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, -3, 15, Integer.MAX_VALUE})
    public void rawParamListTest(int a) {
        Calculator calc = new Calculator();

        assertEquals(Math.pow(a, 2), calc.square(a), "inceorrect square");
    }
}
