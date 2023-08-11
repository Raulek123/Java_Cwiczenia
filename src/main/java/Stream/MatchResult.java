package Stream;

import lombok.AllArgsConstructor;
import lombok.Data;

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
}
