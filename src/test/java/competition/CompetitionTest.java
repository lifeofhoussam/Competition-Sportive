package competition;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;


public abstract class CompetitionTest {
    protected   Match match;
    protected   List<Competitor> competitorsList;
    protected   Competition competition;

    protected abstract Competition createCompetition(List<Competitor>competitorsList);

    @Before
    public void init(){
        this.competitorsList = new ArrayList<>();
        this.match = new RandomScore();
        this.competition = this.createCompetition(this.competitorsList);
    }

    @Test(expected = NoPlayersException.class)
    public void throwsEmptyCompetitorExceptionWhenPlayIsCallOnWithEmptyList() throws NoPlayersException, PlayersNumberNotPowerOfTwo {
        this.competition.play(this.competitorsList);
    }
    @Test
    public void falseWhenCompetitorsListSizeIsNotPowerOfTwo(){
        Competitor A = new Competitor("A");
        Competitor B = new Competitor("B");
        Competitor C = new Competitor("C");
        competitorsList.add(A);
        competitorsList.add(B);
        competitorsList.add(C);
        assertFalse(this.competition.isPowerOfTwo(this.competitorsList));
    }

    @Test
    public void trueWhenCompetitorsListSizeIsPowerOfTwo(){
        Competitor A = new Competitor("A");
        Competitor B = new Competitor("B");
        Competitor C = new Competitor("C");
        Competitor D = new Competitor("D");
        competitorsList.add(A);
        competitorsList.add(B);
        competitorsList.add(C);
        competitorsList.add(D);
        assertTrue(this.competition.isPowerOfTwo(this.competitorsList));
    }
}

