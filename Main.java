import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Character character = null;

        while (true) {
            // Display the starting menu
            System.out.println("Welcome to 'Legends of the Forgotten Realm'!");
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
                        System.out.println("Your adventure begins...");
                        startStory(character, scanner); // Start the story immediately
                    }
                    case 2 -> {
                        // Load an existing character
                        character = loadCharacter(scanner);
                        if (character != null) {
                            System.out.println("Character loaded successfully!");
                            System.out.println("Your adventure continues...");
                            startStory(character, scanner); // Continue the story immediately
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

    // Method to start the story
    private static void startStory(Character character, Scanner scanner) {
        StoryManager storyManager = new StoryManager(character);
        storyManager.startStory(scanner);
    }

    // Method to save character data to a file with the character's name in the filename
    private static void saveCharacter(Character character) {
        String fileName = character.name.replaceAll("\\s+", "_") + "_character.dat"; // Replace spaces with underscores
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(character);
            System.out.println("Character saved successfully to " + fileName + ".");
        } catch (IOException e) {
            System.out.println("Failed to save character: " + e.getMessage());
        }
    }

    // Method to load character data from a file
    private static Character loadCharacter(Scanner scanner) {
        System.out.print("Enter the name of the character to load: ");
        String name = scanner.nextLine();
        String fileName = name.replaceAll("\\s+", "_") + "_character.dat"; // Replace spaces with underscores

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            return (Character) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading character: " + e.getMessage());
            return null;
        }
    }
}
