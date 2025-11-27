public class NFLQB extends NFLPlayer {

    private int touchdowns;
    private double qbr;

    public NFLQB(String name, int age, String team, int touchdowns, double qbr) {
        super(name, age, team);
        this.touchdowns = touchdowns;
        this.qbr = qbr;
    }

    @Override
    public void intro() {
        System.out.println(name + " is a QB for the " + team +
                " with " + touchdowns + " TDs and a QBR of " + qbr + ".");
    }

    public int getTouchdowns() {
        return touchdowns;
    }

    public double getQbr() {
        return qbr;
    }
}
