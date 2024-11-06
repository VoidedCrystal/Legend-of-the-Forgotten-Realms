// Import the Scanner class for user input
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Welcome message and user input for character details
        System.out.println("Welcome to the Text-Based RPG!");
        System.out.print("Enter your character's name: ");
        String name = scanner.nextLine();

        System.out.print("Enter your character's gender: ");
        String gender = scanner.nextLine();

        System.out.print("Enter your character's height (in cm): ");
        int height = scanner.nextInt();

        // Prompt the player to choose a class
        System.out.println("Choose a class: (1) Fighter, (2) Mage, (3) Rogue");
        int classChoice = scanner.nextInt();
        Character character;

        // Create a character based on the chosen class
        switch (classChoice) {
            case 1 -> character = new Fighter(name, gender, height); // Fighter class
            case 2 -> character = new Mage(name, gender, height);    // Mage class
            case 3 -> character = new Rogue(name, gender, height);   // Rogue class
            default -> {
                // Default to Fighter if an invalid choice is made
                System.out.println("Invalid choice. Defaulting to Fighter.");
                character = new Fighter(name, gender, height);
            }
        }

        // Allocate stats for the character and display the character information
        character.allocateStats();
        character.displayCharacterInfo();

        // Placeholder for the game loop
        System.out.println("Your adventure begins...");
        // This part can be expanded for more game content
    }
}
