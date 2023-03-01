package competition;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RandomScoreTest {
    private RandomScore randomScore;
    private Competitor competitorA;
    private Competitor competitorB;

    @Before
    public void init(){
        this.competitorA = new Competitor("A");
        this.competitorB = new Competitor("B");
        this.randomScore = new RandomScore();
    }

    @Test
    public void ifWinnerPointChangeAfterCallrunMatch(){
        int sumPointBeforerunMatch = this.competitorA.getCompetitorPoint() + this.competitorB.getCompetitorPoint();
        this.randomScore.playMatch(competitorA, competitorB);
        assertEquals(sumPointBeforerunMatch+1, competitorA.getCompetitorPoint()+competitorB.getCompetitorPoint());
    }
}
