package przetwarzanieKolekcji;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        ReadFile readFile = new ReadFile();
        List<String> list = readFile.readText("src/main/resources/loremIpsum.csv");
        List<String> stringList = list.stream()
                .map(s -> s.replaceAll("[,.]", ""))
                .collect(Collectors.toList());

        System.out.println(stringList.stream()
                .filter(s -> s.startsWith("s"))
                .count());
        System.out.println(stringList.stream()
                .filter(s -> s.length() == 5)
                .count());
    }
}
