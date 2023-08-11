package Stream;

import java.util.stream.IntStream;

public class Example1 {
    public static void main(String[] args) {
        IntStream.iterate(0, n -> n + 1)
                .filter(number -> number > 100 && number < 1000 && number % 5 == 0)
                .limit(10)
                .map(number -> number * 3)
                .forEach(System.out::println);
    }
}
