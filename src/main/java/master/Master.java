package master;

import competition.*;

import java.util.*;

public class Master  extends Competition {
    private Map<Integer, List<Competitor>>groupStage;
    private List<Competitor>competitorsForPhaseTwo;
    private SelectTeamMethodStrategy selectTeamMethod;
    
    // Constructor for Competition
    public Master(List<Competitor> competitorList, SelectTeamMethodStrategy selectTeamMethod) {
        super(competitorList);
        this.groupStage = new HashMap<>();
        this.competitorsForPhaseTwo = new ArrayList<>();
        this.selectTeamMethod = selectTeamMethod;
    }
    private void speaker(String msg){
        System.out.println("********* "+ msg + " **********");
    }
    
    // Allows all the hens in the competition to play   
    private void groupStage() throws NoPlayersException, NumberOfCompetitorsNotAchievedException {
        this.speaker("Group stage");
        this.selectTeamMethod.selectTeamMethod(this.groupStage, this.competitorList);
        League league;
        List<Competitor> competitorList;
        Set<Map.Entry<Integer, List<Competitor>>> competitorListEntry = this.groupStage.entrySet();
        Iterator<Map.Entry<Integer, List<Competitor>>> iterator = competitorListEntry.iterator();
        while (iterator.hasNext()){
            Map.Entry<Integer, List<Competitor>> entry = iterator.next();
            competitorList = entry.getValue();
            league = new League(competitorList);
            this.speaker("Games of group N°"+entry.getKey()+ " ");
            league.play(competitorList);
            this.selectTeamMethod.selectTeamForPhaseTwo(competitorList, this.competitorsForPhaseTwo);
        }
    }

    // Final phase 
    private void finalStage() throws PlayersNumberNotPowerOfTwo, NoPlayersException {
        this.speaker("Final phase");
        Tournament tournament = new Tournament(this.competitorsForPhaseTwo);
        this.resetCompetitorsPoint(this.competitorsForPhaseTwo);
        tournament.play(this.competitorsForPhaseTwo);
        classify(this.competitorsForPhaseTwo);
    }

    // Resets competitors points to zero
    private void resetCompetitorsPoint(List<Competitor>competitorList){
        competitorList.forEach(Competitor::resetPoint);
    }

    @Override
    public void play(List<Competitor> competitors) throws NoPlayersException, PlayersNumberNotPowerOfTwo {
        try{
            this.groupStage();
            this.finalStage();

        }catch (NumberOfCompetitorsNotAchievedException e){
            e.printStackTrace();
        }

    }

    @Override
    public void classify(List<Competitor>competitorList) {
        competitorList.forEach(competitor -> {
            this.competitors.put(competitor, competitor.getCompetitorPoint());
        });
    }

    @Override
    public boolean isPowerOfTwo(List<Competitor> competitorsList) {
        return false;
    }

}
