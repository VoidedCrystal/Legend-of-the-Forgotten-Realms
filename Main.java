import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Character character = null;

        while (true) {
            // Display the starting menu
            System.out.println("Welcome to the Text-Based RPG!");
            System.out.println("1. Start New Game");
            System.out.println("2. Load Character");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");

            try {
                int menuChoice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline

                switch (menuChoice) {
                    case 1 -> {
                        // Start a new game
                        character = createNewCharacter(scanner);
                        character.allocateStats();
                        saveCharacter(character); // Save the new character
                        character.displayCharacterInfo();
                        System.out.println("Your adventure begins...");
                        // You can add more game content here
                    }
                    case 2 -> {
                        // Load an existing character
                        character = loadCharacter();
                        if (character != null) {
                            System.out.println("Character loaded successfully!");
                            character.displayCharacterInfo();
                            System.out.println("Your adventure continues...");
                            // You can add more game content here
                        } else {
                            System.out.println("Failed to load character or no save file found.");
                        }
                    }
                    case 3 -> {
                        // Exit the game
                        System.out.println("Exiting the game. Goodbye!");
                        return;
                    }
                    default -> System.out.println("Invalid choice. Please select 1, 2, or 3.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number between 1 and 3.");
                scanner.next(); // Clear the invalid input
            }
        }
    }

    // Method to create a new character
    private static Character createNewCharacter(Scanner scanner) {
        System.out.print("Enter your character's name: ");
        String name = scanner.nextLine();

        System.out.print("Enter your character's gender: ");
        String gender = scanner.nextLine();

        System.out.print("Enter your character's height (in cm): ");
        int height = scanner.nextInt();

        System.out.println("Choose a class: (1) Fighter, (2) Mage, (3) Rogue");
        int classChoice = scanner.nextInt();
        Character character;

        if (classChoice == 1) {
            character = new Fighter(name, gender, height);
        } else if (classChoice == 2) {
            character = new Mage(name, gender, height);
        } else if (classChoice == 3) {
            character = new Rogue(name, gender, height);
        } else {
            // Randomly choose a class if an invalid choice is made
            int randomClass = (int) (Math.random() * 3) + 1;
            switch (randomClass) {
                case 1 -> character = new Fighter(name, gender, height);
                case 2 -> character = new Mage(name, gender, height);
                case 3 -> character = new Rogue(name, gender, height);
                default -> throw new IllegalStateException("Unexpected value: " + randomClass);
            }
            System.out.println("Invalid choice. A random class has been selected for you!");
        }
        return character;
    }

    // Method to save character data to a file
    private static void saveCharacter(Character character) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("character.dat"))) {
            oos.writeObject(character);
            System.out.println("Character saved successfully.");
        } catch (IOException e) {
            System.out.println("Failed to save character: " + e.getMessage());
        }
    }

    // Method to load character data from a file
    private static Character loadCharacter() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("character.dat"))) {
            return (Character) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading character: " + e.getMessage());
            return null;
        }
    }
}
