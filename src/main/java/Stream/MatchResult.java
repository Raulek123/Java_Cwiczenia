package Stream;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Comparator;

@Data
@AllArgsConstructor
public class MatchResult {
    private String host;
    private String guest;
    private int hostGoals;
    private int guestGoals;

    @Override
    public String toString() {
        return host + " - " + guest + " (" + hostGoals + ":" + guestGoals + ")";
    }
    public int getGoalDifference() {
        return hostGoals - guestGoals;
    }

    public boolean getTeam(String team){
        return (host.equalsIgnoreCase(team) || guest.equalsIgnoreCase(team));
    }
}
