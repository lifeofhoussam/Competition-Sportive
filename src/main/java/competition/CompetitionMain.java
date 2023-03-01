package competition;

import master.*;

import java.util.*;

public class CompetitionMain {
    public static void play(Competition competition){
        try{
            competition.play();
            System.out.println("*** Ranking ***");
            Set<Map.Entry<Competitor, Integer>> competitorEntry = competition.ranking().entrySet();
            Iterator<Map.Entry<Competitor, Integer>> iterator = competitorEntry.iterator();
            while (iterator.hasNext()){
                Map.Entry<Competitor, Integer> entry = iterator.next();
                System.out.println(entry.getKey().toString() + "-" + entry.getValue());
            }
        }catch (NoPlayersException | PlayersNumberNotPowerOfTwo except){
            System.out.println(except.getMessage());
        }
    }
    
    // Main function
    public static void main(String []args){
        Competition competition;
        SelectTeamMethodStrategy selectTeamMethod;
        List<Competitor> competitorList = new ArrayList<>();
        for(int i=1; i<args.length; i++){
            Competitor competitor = new Competitor(args[i]);
            competitorList.add(competitor);
        }
        switch (args[0]){
            case "L":
                competition = new League(competitorList);
                play(competition);
                break;
            case "T":
                competition = new Tournament(competitorList);
                play(competition);
                break;
            case "M16":
                selectTeamMethod = new SixteenTeamStrategy();
                competition = new Master(competitorList, selectTeamMethod);
                play(competition);
                break;
            case "M24":
                selectTeamMethod = new TwentyFourTeamStrategy();
                competition = new Master(competitorList, selectTeamMethod);
                play(competition);
                break;
            case "M32":
                for(int i=1; i<=32; i++){
                    Competitor competitor = new Competitor("Team"+i);
                    competitorList.add(competitor);
                }
                selectTeamMethod = new TwoFirstPlusTwoSecondStrategy();
                competition = new Master(competitorList, selectTeamMethod);
                play(competition);
                break;
        }

    }
}
