import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Welcome Message
        System.out.println("Welcome to the Text-Based RPG!");
        System.out.print("Enter your character's name: ");
        String name = scanner.nextLine();

        System.out.print("Enter your character's gender: ");
        String gender = scanner.nextLine();

        System.out.print("Enter your character's height (in cm): ");
        int height = scanner.nextInt();

        // Choose Class
        System.out.println("Choose a class: (1) Fighter, (2) Mage, (3) Rogue");
        int classChoice = scanner.nextInt();
        Character character;

        switch (classChoice) {
            case 1 -> character = new Fighter(name, gender, height);
            case 2 -> character = new Mage(name, gender, height);
            case 3 -> character = new Rogue(name, gender, height);
            default -> {
                System.out.println("Invalid choice. Defaulting to Fighter.");
                character = new Fighter(name, gender, height);
            }
        }

        // Character Creation and Stat Allocation
        character.allocateStats();
        character.displayCharacterInfo();

        // Game Loop (placeholder)
        System.out.println("Your adventure begins...");
        // You can expand this part for quests, battles, and exploration
    }
}
