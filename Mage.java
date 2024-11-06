public class Mage extends Character {
    private static final long serialVersionUID = 1L;

    // Constructor for Mage class
    public Mage(String name, String gender, int height) {
        super(name, gender, height);
        magic += 3; // Mages get a bonus to magic
        calculateDerivedStats(); // Recalculate health and mana
    }

    // Display character information for Mage
    @Override
    public void displayCharacterInfo() {
        System.out.println("=== Character Sheet ===");
        System.out.println("Class: Mage");
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
