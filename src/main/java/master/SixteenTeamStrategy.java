package master;

import competition.Competitor;
import competition.NumberOfCompetitorsNotAchievedException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SixteenTeamStrategy extends SelectTeamMethodStrategy {
    private final int NBCOMPETITOR = 16;
    public SixteenTeamStrategy(){}

    @Override
    public void selectTeamMethod(Map<Integer, List<Competitor>> groupStage, List<Competitor> competitorList) throws NumberOfCompetitorsNotAchievedException {
        List<Competitor>competitors = new ArrayList<>();
        int cpt = 1;
        if(competitorList.size() != NBCOMPETITOR)
            throw new NumberOfCompetitorsNotAchievedException("Number of competitors must be equal to "+NBCOMPETITOR);
        for (Competitor competitor : competitorList) {
            competitors.add(competitor);
            if (competitors.size() == 4) {
                groupStage.put(cpt, competitors);
                competitors = new ArrayList<>();
                cpt++;
            }
        }
    }

    @Override
    public void selectTeamForPhaseTwo(List<Competitor> hens, List<Competitor> teamForPhaseTwo) {
        teamForPhaseTwo.addAll(this.bestCompetitors(hens));
    }

}
