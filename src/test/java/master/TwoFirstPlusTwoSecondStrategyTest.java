package master;

import competition.Competitor;
import competition.SelectTeamMethodTest;

import java.util.List;

import static org.junit.Assert.*;

public class TwoFirstPlusTwoSecondStrategyTest extends SelectTeamMethodTest {

    @Override
    protected SelectTeamMethodStrategy createSelectMethod(List<Competitor> competitorList) {
        return new TwoFirstPlusTwoSecondStrategy();
    }
}
