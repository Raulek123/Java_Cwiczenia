package Stream;

import java.util.Comparator;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class MatchResultApp {
    public static void main(String[] args) {
        System.out.println("Wszystkie mecze:");
        getMatchResultsStream().sorted((m1, m2) -> Integer.compare(m2.getGoalDifference(), m1.getGoalDifference()))
                .forEach(System.out::println);
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println("Wszystkie spotkania Polski:");
        getMatchResultsStream().filter(matchResult -> matchResult.getTeam("Polska"))
                .forEach(System.out::println);
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println("Liczba drużyn biorących udział w rozgrywkach: ");
    }

    private static Stream<MatchResult> getMatchResultsStream() {
        return Stream.of(
                new MatchResult("Polska", "Irlandia", 2, 0),
                new MatchResult("Brazylia", "Francja", 0, 3),
                new MatchResult("Włochy", "Polska", 2, 1),
                new MatchResult("Brazylia", "Argentyna", 2, 2),
                new MatchResult("Anglia", "Niemcy", 1, 2),
                new MatchResult("Anglia", "Francja", 3, 0),
                new MatchResult("Polska", "Portugalia", 1, 0),
                new MatchResult("Brazylia", "Niemcy", 3, 3)
        );
    }
}
