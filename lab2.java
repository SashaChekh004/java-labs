import java.util.ArrayList;
import java.util.List;

class Competition {
    private final String name;

    public Competition(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class TeamCompetition extends Competition {
    public TeamCompetition(String name) {
        super(name);
    }
}

class IndividualCompetition extends Competition {
    public IndividualCompetition(String name) {
        super(name);
    }
}

class Championship {
    private final List<Competition> competitions;

    public Championship() {
        this.competitions = new ArrayList<>();
    }

    public void addCompetition(Competition competition) {
        competitions.add(competition);
        System.out.println(competitions);
    }

    public int countTeamCompetitions() {
        int count = 0;
        for (Competition competition : competitions) {
            if (competition instanceof TeamCompetition) {
                count++;
            }
        }
        return count;
    }

    public int countIndividualCompetitions() {
        int count = 0;
        for (Competition competition : competitions) {
            if (competition instanceof IndividualCompetition) {
                count++;
            }
        }
        return count;
    }
}

public class lab2 {
    public static void main(String[] args) {
        Championship championship = new Championship();

        championship.addCompetition(new TeamCompetition("Football"));
        championship.addCompetition(new IndividualCompetition("Volleyball"));
        championship.addCompetition(new TeamCompetition("Basketball"));
        championship.addCompetition(new IndividualCompetition("Chess"));

        System.out.println("Team competitions amount: " + championship.countTeamCompetitions());
        System.out.println("Individual competitions amount: " + championship.countIndividualCompetitions());
    }
}

