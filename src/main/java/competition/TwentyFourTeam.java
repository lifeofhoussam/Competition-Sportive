package competition;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class TwentyFourTeam extends SelectTeamMethod{
    private List<Competitor>bestThird = new ArrayList<>();

    @Override
    public void selectTeamMethod(Map<Integer, List<Competitor>> groupStage, List<Competitor> competitorList) throws NumberOfCompetitorsNotAchievedException {
        List<Competitor>competitors = new ArrayList<>();
        int cpt = 1;
        if(competitorList.size() != 24)
            throw new NumberOfCompetitorsNotAchievedException("Number of competitors must be equal to 32");
        for(int i =0; i<competitorList.size(); i++){
            competitors.add(competitorList.get(i));
            if(competitors.size() == 8){
                groupStage.put(cpt, competitors);
                competitors = new ArrayList<>();
                cpt++;
            }
        }
    }

    @Override
    public void selectTeamForPhaseTwo(List<Competitor> hens, List<Competitor> teamForPhaseTwo) {
        teamForPhaseTwo.addAll(this.bestCompetitors(hens));
        this.bestThird.add(this.bestCompetitor(hens));
        if(this.bestThird.size() == 3){
            while (this.bestThird.size() != 1) {
                Competitor best = this.bestCompetitor(this.bestThird);
                teamForPhaseTwo.add(best);
                this.bestThird.remove(best);
            }
        }
    }
}
