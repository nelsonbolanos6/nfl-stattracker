NFL StatTracker

A simple Java application for managing a small NFL player roster. The project was built to practice core Object-Oriented Programming concepts such as inheritance, polymorphism, abstract classes, and file input/output.

Players can be added, removed, viewed, saved to a file, and reloaded back into the program.

Features
Add Players

The application supports four different player types:

Quarterback (QB): touchdowns, QBR

Wide Receiver (WR): receptions, receiving yards

Running Back (RB): carries, rushing yards

Defensive End (DE): sacks, pressure rate

Each type stores different statistics and displays them differently.

View Roster

Displays all players currently stored in the roster.
Uses polymorphism so each subclass prints its own formatted description.

Remove Players

Players can be removed by entering their name (case-insensitive).

Save and Load

The roster can be saved to a text file and loaded back later.
Data is stored in a simple comma-separated format.

Concepts Demonstrated

Inheritance:
All player types extend a shared abstract class NFLPlayer.

Polymorphism:
Each subclass overrides the intro() method to display its own stats.

Encapsulation:
Player details are stored using constructors and getters.

File I/O:
FileStore.java handles reading from and writing to a roster.txt file.

Basic CLI Application:
The user interacts with the program through a looped menu in Main.java.