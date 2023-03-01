package competition;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public abstract class SelectTeamMethod {

    // Separates competitors list based off the selected competition
    // groupStage is a map that contains list of competitors  
    abstract void selectTeamMethod(Map<Integer, List<Competitor>> groupStage, List<Competitor>competitorList) throws NumberOfCompetitorsNotAchievedException;

    // Allows to select the teams according an certain criteria define by each class that implement the method
    // hens is competitors list who just finished to play
    // teamForPhaseTwo is competitors list for the next step
    abstract void selectTeamForPhaseTwo(List<Competitor>hens, List<Competitor>teamForPhaseTwo);

    // Returns the two best competitors of the group
    // return ArrayList
    public List<Competitor> bestCompetitors(List<Competitor>hens){
        List<Competitor>best = new ArrayList<>();
        while (best.size() < 2){
            Competitor bestComp = bestCompetitor(hens);
            best.add(bestComp);
            hens.remove(bestComp);
        }
        return best;
    }

    // Return the best competitor in the group
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
