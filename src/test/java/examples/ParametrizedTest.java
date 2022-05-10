package examples;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.ValueSource;
import utils.Calculator;
import utils.PropertyReader;

import java.util.*;
import java.util.stream.Stream;

import static org.hamcrest.Matchers.hasSize;
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
    @ValueSource(ints = {1, 15, Integer.MAX_VALUE})
    public void rawParamListTest(int a) {
        Calculator calc = new Calculator();

        assertEquals(Math.pow(a, 2), calc.square(a), "inceorrect square");
    }

    @ParameterizedTest
    @ArgumentsSource(MyArgumentsProvider.class)
    void testCollectionSize(Collection<Object> list, int expectedSize) {
        MatcherAssert.assertThat(list, hasSize(expectedSize));
    }

    private static class MyArgumentsProvider implements ArgumentsProvider {

        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
            return Stream.of(
                    Arguments.of(Collections.emptyList(), 0),
                    Arguments.of(Collections.singleton(true), 1),
                    Arguments.of(List.of(99, 100), 2),
                    Arguments.of(Set.of("foo", "bar", "baz"), 3)
            );
        }
    }


}
