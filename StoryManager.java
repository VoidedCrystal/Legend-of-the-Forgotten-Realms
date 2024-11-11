import java.util.Scanner;

public class StoryManager {
    private Character player;
    private Area currentArea;
    private Area town;
    private Area forest;
    private Area darkCave;
    private Area ancientRuins;

    public StoryManager(Character player) {
        this.player = player;
        initializeAreas();
        currentArea = town; // Start in the Town
    }

    private void initializeAreas() {
        // Initialize Areas
        town = new Area("Town", "A peaceful village with friendly townsfolk and many stories to tell.");
        forest = new Area("Forest", "A dense and dark forest with hidden secrets and dangers lurking within.");
        darkCave = new Area("Dark Cave", "A treacherous cave that houses one of the ancient artifacts.");
        ancientRuins = new Area("Ancient Ruins", "The final destination, where the fate of the world will be decided.");

        // Add quests and NPCs to areas
        town.addNpc(new NPC("Mayor Harold", "The town's mayor, who seeks brave souls to help protect the village."));
        town.addQuest(new Quest("Protect the Village", "Defend the village from bandits and gain the Mayor's trust."));

        forest.addNpc(new NPC("Forest Guardian", "A mystical being who will guide you if you prove your worth."));
        forest.addQuest(new Quest("Find the Forest Shrine", "Locate and cleanse the shrine to gain the Guardian's blessing."));

        darkCave.addNpc(new NPC("Old Miner", "An old miner who knows the secrets of the cave."));
        darkCave.addQuest(new Quest("Retrieve the Lost Artifact", "Venture into the Dark Cave and find the artifact."));

        ancientRuins.addQuest(new Quest("The Final Decision", "Choose to save or doom the world using the artifact's power."));
    }

    public void startStory(Scanner scanner) {
        while (true) {
            System.out.println("\nYou are currently in " + currentArea.getName() + ".");
            System.out.println(currentArea.getDescription());

            // Show available options
            System.out.println("What would you like to do?");
            System.out.println("1. Explore the area");
            System.out.println("2. Talk to NPCs");
            System.out.println("3. View Quests");
            System.out.println("4. Travel to another area");
            System.out.println("5. View Character Sheet");
            System.out.println("6. Exit Game");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    currentArea.explore();
                    break;
                case 2:
                    talkToNpcs();
                    break;
                case 3:
                    viewQuests();
                    break;
                case 4:
                    travelToArea(scanner);
                    break;
                case 5:
                    player.displayCharacterInfo();
                    break;
                case 6:
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void talkToNpcs() {
        if (currentArea.getNpcs().isEmpty()) {
            System.out.println("There are no NPCs to talk to in this area.");
            return;
        }
        for (NPC npc : currentArea.getNpcs()) {
            npc.interact(player);
        }
    }

    private void viewQuests() {
        if (currentArea.getQuests().isEmpty()) {
            System.out.println("There are no quests available in this area.");
            return;
        }
        for (Quest quest : currentArea.getQuests()) {
            System.out.println("- " + quest.getName() + ": " + quest.getDescription() + (quest.isCompleted() ? " (Completed)" : ""));
        }
    }

    private void travelToArea(Scanner scanner) {
        System.out.println("Where would you like to travel?");
        System.out.println("1. Town");
        System.out.println("2. Forest");
        System.out.println("3. Dark Cave");
        System.out.println("4. Ancient Ruins");

        int areaChoice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (areaChoice) {
            case 1:
                currentArea = town;
                break;
            case 2:
                currentArea = forest;
                break;
            case 3:
                currentArea = darkCave;
                break;
            case 4:
                currentArea = ancientRuins;
                break;
            default:
                System.out.println("Invalid choice.");
        }
        System.out.println("You have traveled to " + currentArea.getName() + ".");
    }
}
