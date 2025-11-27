public abstract class NFLPlayer {

    // protected so child classes (NFLQB, NFLWR, etc.) can use them
    protected String name;
    protected int age;
    protected String team;

    public NFLPlayer(String name, int age, String team) {
        this.name = name;
        this.age = age;
        this.team = team;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getTeam() {
        return team;
    }

    // each subclass prints itself its own way
    public abstract void intro();
}
