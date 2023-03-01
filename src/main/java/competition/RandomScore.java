package competition;

import java.util.Random;

public class RandomScore implements Match{

    public RandomScore(){}

    // Picks a random winner for the game
    public Competitor playMatch(Competitor competitorA, Competitor competitorB) {
        Competitor winner;
        int random = new Random().nextInt(2);
        if(random > 0){
            competitorA.setCompetitorPoint();
            winner = competitorA;
        }
        else {
            competitorB.setCompetitorPoint();
            winner = competitorB;
        }
        return winner;
    }
}
