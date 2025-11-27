import java.util.ArrayList;

public class LeagueManager {

    private ArrayList<NFLPlayer> roster = new ArrayList<>();

    public void addPlayer(NFLPlayer p) {
        roster.add(p);
        System.out.println(p.getName() + " added to roster.");
    }

    public void removePlayerByName(String name) {
        for (int i = 0; i < roster.size(); i++) {
            if (roster.get(i).getName().equalsIgnoreCase(name)) {
                System.out.println(roster.get(i).getName() + " removed from roster.");
                roster.remove(i);
                return;
            }
        }
        System.out.println("No player found with that name.");
    }

    public void showRoster() {
        if (roster.isEmpty()) {
            System.out.println("Roster is empty.");
            return;
        }

        System.out.println("\n--- Current Roster ---");
        for (NFLPlayer p : roster) {
            p.intro(); // polymorphism working
        }
        System.out.println("----------------------\n");
    }

    public ArrayList<NFLPlayer> getRoster() {
        return roster;
    }

    // 🔹 NEW: allow Main to replace the roster after loading from file
    public void setRoster(ArrayList<NFLPlayer> roster) {
        this.roster = roster;
    }
}

