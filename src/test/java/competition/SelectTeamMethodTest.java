package competition;

import master.SelectTeamMethodStrategy;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class SelectTeamMethodTest {
    protected SelectTeamMethodStrategy selectTeamMethod;

    protected abstract SelectTeamMethodStrategy createSelectMethod(List<Competitor>competitorList);

    @Test(expected = NumberOfCompetitorsNotAchievedException.class)
    public void throwNumberOfCompetitorsNotAchievedException() throws NumberOfCompetitorsNotAchievedException{
        List<Competitor>competitors = new ArrayList<>();
        Map<Integer, List<Competitor>>group = new HashMap<>();
        this.selectTeamMethod = this.createSelectMethod(competitors);
        this.selectTeamMethod.selectTeamMethod(group, competitors);
    }
}
