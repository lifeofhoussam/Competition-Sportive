package master;

import competition.Competitor;
import competition.NumberOfCompetitorsNotAchievedException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public abstract class SelectTeamMethodStrategy {
    
    public abstract void selectTeamMethod(Map<Integer, List<Competitor>> groupStage, List<Competitor> competitorList) throws NumberOfCompetitorsNotAchievedException;

    abstract void selectTeamForPhaseTwo(List<Competitor>hens, List<Competitor>teamForPhaseTwo);

    public List<Competitor> bestCompetitors(List<Competitor>hens){
        List<Competitor>best = new ArrayList<>();
        while (best.size() < 2){
            Competitor bestComp = bestCompetitor(hens);
            best.add(bestComp);
            hens.remove(bestComp);
        }
        return best;
    }

    public Competitor bestCompetitor(List<Competitor>group){
        Competitor bestComp = group.get(0);
        for(int i = 1; i<group.size(); i++){
            if(bestComp.getCompetitorPoint() < group.get(i).getCompetitorPoint()){
                bestComp = group.get(i);
            }else if(bestComp.getCompetitorPoint() == group.get(i).getCompetitorPoint()){
                int random = new Random().nextInt(2);
                bestComp = group.get(random);
            }
        }
        return bestComp;
    }
}
