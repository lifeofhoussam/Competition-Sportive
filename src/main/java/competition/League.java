package competition;

import java.util.List;

public class League extends Competition{

    public League(List<Competitor>competitorList){
        super(competitorList);
    }
    
    // Plays league matches 
    @Override
    public void play(final List<Competitor> competitors) throws NoPlayersException {
        if(competitors.isEmpty())
            throw new NoPlayersException("Competitors list can't be empty!");

        this.competitorList.forEach(competitor -> this.competitorList.forEach(competitorB ->{
            if(!competitor.equals(competitorB)){
                this.playMatch(competitor, competitorB);
            }
        }));
        classify(competitors);
    }
    
    

    // Adds competitors and their points to the map 
    public void classify(List<Competitor>competitorList){
        competitorList.forEach(competitor -> {
            this.competitors.put(competitor, competitor.getCompetitorPoint());
        });
    }
    
    @Override
    public boolean isPowerOfTwo(List<Competitor>competitorList){
        float n = (float)competitorList.size();
        while(n%2 == 0) n=n/2;
        if (n == 1) return true;
        return false;
    }

}
