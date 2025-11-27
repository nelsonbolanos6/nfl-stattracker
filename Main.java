import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        LeagueManager lm = new LeagueManager();
        Scanner sc = new Scanner(System.in);

        boolean running = true;

        while (running) {
            System.out.println("\n=== StatTrack NFL Manager ===");
            System.out.println("1) Add QB");
            System.out.println("2) Add WR");
            System.out.println("3) Add RB");
            System.out.println("4) Add DE");
            System.out.println("5) Remove Player");
            System.out.println("6) Show Roster");
            System.out.println("7) Save Roster");
            System.out.println("8) Load Roster");
            System.out.println("9) Exit");
            System.out.print("Choose an option: ");

            String input = sc.nextLine();
            int choice;

            // simple safety so it doesn't crash on bad input
            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number 1-9.");
                continue;
            }

            switch (choice) {

                case 1 -> { // Add QB
                    System.out.print("Name: ");
                    String name = sc.nextLine();

                    System.out.print("Age: ");
                    int age = Integer.parseInt(sc.nextLine());

                    System.out.print("Team: ");
                    String team = sc.nextLine();

                    System.out.print("Touchdowns: ");
                    int tds = Integer.parseInt(sc.nextLine());

                    System.out.print("QBR: ");
                    double qbr = Double.parseDouble(sc.nextLine());

                    lm.addPlayer(new NFLQB(name, age, team, tds, qbr));
                }

                case 2 -> { // Add WR
                    System.out.print("Name: ");
                    String name = sc.nextLine();

                    System.out.print("Age: ");
                    int age = Integer.parseInt(sc.nextLine());

                    System.out.print("Team: ");
                    String team = sc.nextLine();

                    System.out.print("Receptions: ");
                    int rec = Integer.parseInt(sc.nextLine());

                    System.out.print("Yards: ");
                    int yards = Integer.parseInt(sc.nextLine());

                    lm.addPlayer(new NFLWR(name, age, team, rec, yards));
                }

                case 3 -> { // Add RB
                    System.out.print("Name: ");
                    String name = sc.nextLine();

                    System.out.print("Age: ");
                    int age = Integer.parseInt(sc.nextLine());

                    System.out.print("Team: ");
                    String team = sc.nextLine();

                    System.out.print("Carries: ");
                    int carries = Integer.parseInt(sc.nextLine());

                    System.out.print("Rush Yards: ");
                    int ry = Integer.parseInt(sc.nextLine());

                    lm.addPlayer(new NFLRB(name, age, team, carries, ry));
                }

                case 4 -> { // Add DE
                    System.out.print("Name: ");
                    String name = sc.nextLine();

                    System.out.print("Age: ");
                    int age = Integer.parseInt(sc.nextLine());

                    System.out.print("Team: ");
                    String team = sc.nextLine();

                    System.out.print("Sacks: ");
                    int sacks = Integer.parseInt(sc.nextLine());

                    System.out.print("Pressure Rate (example: 0.19 for 19%): ");
                    double pr = Double.parseDouble(sc.nextLine());

                    lm.addPlayer(new NFLDE(name, age, team, sacks, pr));
                }

                case 5 -> { // Remove Player
                    System.out.print("Enter player name to remove: ");
                    String nameToRemove = sc.nextLine();
                    lm.removePlayerByName(nameToRemove);
                }

                case 6 -> lm.showRoster(); // Show Roster

                case 7 -> { // Save Roster
                    FileStore.save(lm.getRoster());
                }

                case 8 -> { // Load Roster
                    lm.setRoster(FileStore.load());
                }

                case 9 -> {
                    running = false;
                    System.out.println("Exiting StatTrack. Bye!");
                }

                default -> System.out.println("Invalid option. Choose 1-9.");
            }
        }

        sc.close();
    }
}
