public class NFLDE extends NFLPlayer {

    private int sacks;
    private double pressureRate;  // we’ll store this as 0–100 now, e.g. 55.0 for 55%

    public NFLDE(String name, int age, String team, int sacks, double pressureRate) {
        super(name, age, team);
        this.sacks = sacks;
        this.pressureRate = pressureRate;
    }

    @Override
    public void intro() {
        System.out.println(name + " is a DE for the " + team +
                " with " + sacks + " sacks and a pressure rate of " + pressureRate + "%.");
    }

    public int getSacks() {
        return sacks;
    }

    public double getPressureRate() {
        return pressureRate;
    }
}

