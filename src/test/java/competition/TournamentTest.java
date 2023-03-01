package competition;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertFalse;

public class TournamentTest extends CompetitionTest{
    @Override
    protected Competition createCompetition(List<Competitor> competitorsList) {
        return new Tournament(competitorsList);
    }

}
