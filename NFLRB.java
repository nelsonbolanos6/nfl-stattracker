public class NFLRB extends NFLPlayer {

    private int carries;
    private int rushYards;

    public NFLRB(String name, int age, String team, int carries, int rushYards) {
        super(name, age, team);
        this.carries = carries;
        this.rushYards = rushYards;
    }

    @Override
    public void intro() {
        System.out.println(name + " is a RB for the " + team +
                " with " + carries + " carries for " + rushYards + " rushing yards.");
    }

    public int getCarries() {
        return carries;
    }

    public int getRushYards() {
        return rushYards;
    }
}
