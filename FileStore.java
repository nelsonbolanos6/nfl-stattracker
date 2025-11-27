import java.io.*;
import java.util.ArrayList;

public class FileStore {

    private static final String FILE_NAME = "roster.txt";

    // SAVE: type,name,age,team,stat1,stat2
    public static void save(ArrayList<NFLPlayer> roster) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(FILE_NAME))) {

            for (NFLPlayer p : roster) {

                if (p instanceof NFLQB) {
                    NFLQB qb = (NFLQB) p;
                    // QB,name,age,team,tds,qbr
                    pw.printf("QB,%s,%d,%s,%d,%.2f%n",
                            qb.getName(),
                            qb.getAge(),
                            qb.getTeam(),
                            qb.getTouchdowns(),
                            qb.getQbr());
                } else if (p instanceof NFLWR) {
                    NFLWR wr = (NFLWR) p;
                    // WR,name,age,team,rec,yards
                    pw.printf("WR,%s,%d,%s,%d,%d%n",
                            wr.getName(),
                            wr.getAge(),
                            wr.getTeam(),
                            wr.getReceptions(),
                            wr.getYards());
                } else if (p instanceof NFLRB) {
                    NFLRB rb = (NFLRB) p;
                    // RB,name,age,team,carries,rushYards
                    pw.printf("RB,%s,%d,%s,%d,%d%n",
                            rb.getName(),
                            rb.getAge(),
                            rb.getTeam(),
                            rb.getCarries(),
                            rb.getRushYards());
                } else if (p instanceof NFLDE) {
                    NFLDE de = (NFLDE) p;
                    // DE,name,age,team,sacks,pressureRate
                    pw.printf("DE,%s,%d,%s,%d,%.4f%n",
                            de.getName(),
                            de.getAge(),
                            de.getTeam(),
                            de.getSacks(),
                            de.getPressureRate());
                }
            }

            System.out.println("Roster saved to " + FILE_NAME);

        } catch (IOException e) {
            System.out.println("Error saving roster: " + e.getMessage());
        }
    }

    // LOAD: reads the full format for each position
    public static ArrayList<NFLPlayer> load() {
        ArrayList<NFLPlayer> roster = new ArrayList<>();

        File file = new File(FILE_NAME);
        if (!file.exists()) {
            System.out.println("No saved roster found yet.");
            return roster;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {

            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");

                if (parts.length < 6) {
                    // line is malformed or old format; skip it
                    continue;
                }

                String type = parts[0];
                String name = parts[1];
                int age = Integer.parseInt(parts[2]);
                String team = parts[3];
                int stat1 = Integer.parseInt(parts[4]);
                double stat2 = Double.parseDouble(parts[5]);

                switch (type) {
                    case "QB":
                        roster.add(new NFLQB(name, age, team, stat1, stat2));
                        break;
                    case "WR":
                        roster.add(new NFLWR(name, age, team, stat1, (int) stat2));
                        break;
                    case "RB":
                        roster.add(new NFLRB(name, age, team, stat1, (int) stat2));
                        break;
                    case "DE":
                        roster.add(new NFLDE(name, age, team, stat1, stat2));
                        break;
                    default:
                        // unknown type; ignore
                        break;
                }
            }

            System.out.println("Roster loaded from " + FILE_NAME);

        } catch (IOException e) {
            System.out.println("Error loading roster: " + e.getMessage());
        }

        return roster;
    }
}
