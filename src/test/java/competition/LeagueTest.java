package competition;

import java.util.List;

public class LeagueTest extends CompetitionTest{

    @Override
    protected Competition createCompetition(List<Competitor>competitors) {
        return new League(competitors);
    }
}
