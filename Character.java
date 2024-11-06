import java.io.Serializable;
import java.util.InputMismatchException;
import java.util.Scanner;

// Abstract class representing a character in the game
public abstract class Character implements Serializable {
    private static final long serialVersionUID = 1L; // For serialization

    // Character attributes
    protected String name;
    protected String gender;
    protected int height;
    protected int strength;
    protected int charisma;
    protected int magic;
    protected int constitution;
    protected int luck;
    protected int level;
    protected int health;
    protected int mana;
    protected int pointsToAllocate;

    // Constructor to initialize character attributes
    public Character(String name, String gender, int height) {
        this.name = name;
        this.gender = gender;
        this.height = height;
        this.level = 1;
        this.pointsToAllocate = 21; // Points available for stat allocation
        this.strength = 5;
        this.charisma = 5;
        this.magic = 5;
        this.constitution = 5;
        this.luck = 5;
        calculateDerivedStats(); // Calculate health and mana
    }

    // Method for allocating stat points
    public void allocateStats() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("You have " + pointsToAllocate + " points to allocate to your stats.");
        while (pointsToAllocate > 0) {
            try {
                // Display current stats and prompt for allocation
                System.out.println("Current Stats: Strength: " + strength + ", Charisma: " + charisma + 
                                   ", Magic: " + magic + ", Constitution: " + constitution + ", Luck: " + luck);
                System.out.println("Points left to allocate: " + pointsToAllocate);
                System.out.println("Choose a stat to increase: (1) Strength, (2) Charisma, (3) Magic, (4) Constitution, (5) Luck");
                int choice = scanner.nextInt();

                // Allocate points based on the user's choice
                switch (choice) {
                    case 1 -> { strength++; pointsToAllocate--; }
                    case 2 -> { charisma++; pointsToAllocate--; }
                    case 3 -> { magic++; pointsToAllocate--; }
                    case 4 -> { constitution++; pointsToAllocate--; }
                    case 5 -> { luck++; pointsToAllocate--; }
                    default -> System.out.println("Invalid choice. Please select a number between 1 and 5."); // Handle invalid input
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number between 1 and 5.");
                scanner.next(); // Clear the invalid input from the scanner
            }
        }

        calculateDerivedStats(); // Recalculate health and mana after allocation
    }

    // Method to calculate derived stats like health and mana
    protected void calculateDerivedStats() {
        this.health = 100 + (constitution * 10); // Health starts at 100, then Constitution adds extra
        this.mana = 100 + (magic * 5);           // Mana starts at 100, then Magic adds extra
    }

    // Abstract method to display character information (implemented in subclasses)
    public abstract void displayCharacterInfo();
}
