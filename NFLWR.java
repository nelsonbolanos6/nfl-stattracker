public class NFLWR extends NFLPlayer {

    private int receptions;
    private int yards;

    public NFLWR(String name, int age, String team, int receptions, int yards) {
        super(name, age, team);
        this.receptions = receptions;
        this.yards = yards;
    }

    @Override
    public void intro() {
        System.out.println(name + " is a WR for the " + team +
                " with " + receptions + " receptions for " + yards + " yards.");
    }

    public int getReceptions() {
        return receptions;
    }

    public int getYards() {
        return yards;
    }
}

