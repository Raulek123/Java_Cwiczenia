package Stream;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

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

    public boolean hasParticipatedInTeamMatches(String team){
        return (host.equalsIgnoreCase(team) || guest.equalsIgnoreCase(team));
    }

    public String[] getTeamNames() {
        return new String[] {guest, host};
    }

    public Integer[] allGoals() {
        return new Integer[] {guestGoals, hostGoals};
    }
}
