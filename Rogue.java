public class Rogue extends Character {
    private static final long serialVersionUID = 1L;

    // Constructor for Rogue class
    public Rogue(String name, String gender, int height) {
        super(name, gender, height);
        luck += 3; // Rogues get a bonus to luck
        calculateDerivedStats(); // Recalculate health and mana
    }

    // Display character information for Rogue
    @Override
    public void displayCharacterInfo() {
        System.out.println("=== Character Sheet ===");
        System.out.println("Class: Rogue");
        System.out.println("Name: " + name);
        System.out.println("Gender: " + gender);
        System.out.println("Height: " + height + " cm");
        System.out.println("Level: " + level); // Show the level
        System.out.println("Strength: " + strength);
        System.out.println("Charisma: " + charisma);
        System.out.println("Magic: " + magic);
        System.out.println("Constitution: " + constitution);
        System.out.println("Luck: " + luck);
        System.out.println("Health: " + health);
        System.out.println("Mana: " + mana);
        System.out.println("=======================");
    }
}
