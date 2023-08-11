package Stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MatchResultApp {
    public static void main(String[] args) {
        System.out.println("Wszystkie mecze:");
        printAllResultSorted(getMatchResultsStream());
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println("Wszystkie spotkania Polski:");
        getResultWithTeam(getMatchResultsStream(), "Polska").forEach(System.out::println);
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        long count = countDistinctTeams(getMatchResultsStream());
        System.out.println("Liczba drużyn biorących udział w rozgrywkach: " + count);
    }

    private static void printAllResultSorted(Stream<MatchResult> result) {
        result.sorted(Comparator.comparing(MatchResult::getGoalDifference))
                .forEach(System.out::println);
    }

    private static List<MatchResult> getResultWithTeam(Stream<MatchResult> result, String team) {
        return result.filter(matchResult -> matchResult.hasParticipatedInTeamMatches(team))
                .collect(Collectors.toList());
    }

    private static long countDistinctTeams(Stream<MatchResult> result) {
        return result.map(MatchResult::getTeamNames)
                .flatMap(Arrays::stream)
                .distinct()
                .count();
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
