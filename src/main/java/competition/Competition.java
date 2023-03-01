package competition;

import java.util.*;

import static util.MapUtil.sortByDescendingValue;

// Abstract main class to Tournament & League
public abstract class Competition {
    protected Match match;
    protected List<Competitor>competitorList;
    protected Map<Competitor, Integer>competitors = new HashMap<>();

    public Competition(List<Competitor> competitorList) {
        this.competitorList = competitorList;
        this.match = new RandomScore();
    }
    
    // Starts the competition
    void play() throws NoPlayersException, PlayersNumberNotPowerOfTwo {
        play(this.competitorList);
    }
    
    // Plays the matches based off competition type
    protected abstract void play(List<Competitor>competitors)throws NoPlayersException, PlayersNumberNotPowerOfTwo;
    
    // Sorts competitors based off their points 
    public Map<Competitor, Integer> ranking(){
        return sortByDescendingValue(this.competitors);
    }
    
    // Prints the winner of the match 
    private void printWinner(Competitor A, Competitor B, Competitor Winner){
        System.out.println(A.toString()+" vs "+B.getCompetitorName()+ " --> "+Winner.getCompetitorName()+" wins!");
    }
    
    // Plays the match between the two competitors
    protected void playMatch(Competitor A, Competitor B){
        Competitor winner = this.match.playMatch(A, B);
        printWinner(A, B, winner);
    }

    public abstract boolean isPowerOfTwo(List<Competitor>competitorsList);

    public abstract void classify(List<Competitor>competitorList);
    
}
