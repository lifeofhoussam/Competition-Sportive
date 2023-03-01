package competition;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class SixteenTeam extends SelectTeamMethod{
    public SixteenTeam(){}
 
    @Override
    public void selectTeamMethod(Map<Integer, List<Competitor>> groupStage, List<Competitor> competitorList) throws NumberOfCompetitorsNotAchievedException{
        List<Competitor>competitors = new ArrayList<>();
        int cpt = 1;
        if(competitorList.size() != 16)
            throw new NumberOfCompetitorsNotAchievedException("Number of competitors must be equal to 16");
        for(int i =0; i<competitorList.size(); i++){
            competitors.add(competitorList.get(i));
            if(competitors.size() == 4){
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
