package competition;

import java.util.List;

public class Tournament extends Competition{

    public Tournament(List<Competitor> competitorList) {
        super(competitorList);
    }

    // Plays tournament matches 
    @Override
    public void play(List<Competitor> competitorList) throws NoPlayersException, PlayersNumberNotPowerOfTwo{
        if(competitorList.isEmpty())
            throw new NoPlayersException("Competitors list can't be empty!");
        if(isPowerOfTwo(competitorList)){
            boolean flag = true;
            int pts = 0;
            while (flag){
                this.playMatch(competitorList.get(pts), competitorList.get(pts+1));
                if(competitorList.get(pts).getCompetitorPoint()>competitorList.get(pts+1).getCompetitorPoint())
                    competitorList.remove(competitorList.get(pts+1));
                else
                    competitorList.remove(competitorList.get(pts));
                pts ++;
                if(pts == competitorList.size())
                    pts = 0;
                if(competitorList.size() == 1)
                    flag = false;
            }
            classify(competitorList);
        }else{
            throw new PlayersNumberNotPowerOfTwo("Competitors list size must be a power of 2!");
        }
    }

    // Checks if the total number of competitors is a power of 2 
    public boolean isPowerOfTwo(List<Competitor>competitorList){
        float n = (float)competitorList.size();
        while(n%2 == 0) n=n/2;
        if (n == 1) return true;
        return false;
    }
    
    // Adds competitors and their points to the map 
    public void classify(List<Competitor>competitorList){
        this.competitorList.forEach(competitor -> {
            this.competitors.put(competitor, competitor.getCompetitorPoint());
        });
    }
}
