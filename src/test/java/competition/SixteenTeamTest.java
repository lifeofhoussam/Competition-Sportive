package competition;

import master.SelectTeamMethodStrategy;
import master.SixteenTeamStrategy;

import java.util.List;

public class SixteenTeamTest extends SelectTeamMethodTest{

    @Override
    protected SelectTeamMethodStrategy createSelectMethod(List<Competitor> competitorList) {
        return new SixteenTeamStrategy();
    }
}
