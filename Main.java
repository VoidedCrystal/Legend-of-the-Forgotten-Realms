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

        // Check the class choice and create a character, or choose randomly if invalid
        if (classChoice == 1) {
            character = new Fighter(name, gender, height);
        } else if (classChoice == 2) {
            character = new Mage(name, gender, height);
        } else if (classChoice == 3) {
            character = new Rogue(name, gender, height);
        } else {
            // Generate a random number between 1 and 3 to choose a random class
            int randomClass = (int) (Math.random() * 3) + 1;
            switch (randomClass) {
                case 1 -> character = new Fighter(name, gender, height);
                case 2 -> character = new Mage(name, gender, height);
                case 3 -> character = new Rogue(name, gender, height);
                default -> throw new IllegalStateException("Unexpected value: " + randomClass);
            }
            System.out.println("Invalid choice. A random class has been selected for you!");
        }

        // Allocate stats for the character and display the character information
        character.allocateStats();
        character.displayCharacterInfo();

        // Placeholder for the game loop
        System.out.println("Your adventure begins...");
        // This part can be expanded for more game content
    }
}