package other;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class StreamTest {

    List<String> myList = Arrays.asList("a1", "a2", "b1", "c2", "c1");


    @Test
    void stream1() {
        myList.stream()
                .filter(s -> s.startsWith("c"))
                .map(String::toUpperCase)
                .sorted()
                .forEach(System.out::println);
    }
}
