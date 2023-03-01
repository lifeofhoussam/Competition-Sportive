package competition;

// Competitors class
public class Competitor {
    private String competitorName;
    private int competitorPoint;

    public Competitor(String competitorName) {
        this.competitorName = competitorName;
        this.competitorPoint = 0;
    }

    public String getCompetitorName() {
        return competitorName;
    }

    public int getCompetitorPoint() {
        return competitorPoint;
    }

    public void setCompetitorPoint() {
        this.competitorPoint += 1;
    }

    @Override
    public String toString() {
        return this.getCompetitorName() + "";
    }

    public boolean equals(Object object){
        if(object instanceof Competitor){
            Competitor other = (Competitor)object;
            return this == other;
        }
        return false;
    }
    
    public void resetPoint(){
        this.competitorPoint = 0;
    }

}
