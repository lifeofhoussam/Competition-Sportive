package master;

import competition.Competitor;
import competition.NumberOfCompetitorsNotAchievedException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TwoFirstPlusTwoSecondStrategy extends SelectTeamMethodStrategy{
    private final int NBCOMPETITOR = 32;
    private List<Competitor>bestSecond = new ArrayList<>();

    @Override
    public void selectTeamMethod(Map<Integer, List<Competitor>> groupStage, List<Competitor> competitorList) throws NumberOfCompetitorsNotAchievedException {
        List<Competitor>competitors = new ArrayList<>();
        int cpt = 1;
        if(competitorList.size() != NBCOMPETITOR)
            throw new NumberOfCompetitorsNotAchievedException("Number of competitors must be equal to "+NBCOMPETITOR);
        for (Competitor competitor : competitorList) {
            competitors.add(competitor);
            if (competitors.size() == 8) {
                groupStage.put(cpt, competitors);
                competitors = new ArrayList<>();
                cpt++;
            }
        }
    }

    @Override
    void selectTeamForPhaseTwo(List<Competitor> hens, List<Competitor> teamForPhaseTwo) {
        teamForPhaseTwo.addAll(this.bestCompetitors(hens));
        this.bestSecond.addAll(this.bestCompetitors(hens));
        if(this.bestSecond.size() == 8){
            teamForPhaseTwo.addAll(this.bestSecond);
        }
    }
}
