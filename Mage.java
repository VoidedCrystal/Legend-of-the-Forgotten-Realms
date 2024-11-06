// Mage class, inherits from Character
public class Mage extends Character {
    // Constructor to initialize a Mage with additional bonuses
    public Mage(String name, String gender, int height) {
        super(name, gender, height);
        this.magic += 4;           // Mage gets a bonus to Magic
        this.charisma += 1;        // Mage gets a bonus to Charisma
        calculateDerivedStats();   // Recalculate health and mana
    }

    // Display character information specific to the Mage class
    @Override
    public void displayCharacterInfo() {
        System.out.println("Character Class: Mage");
        System.out.println("Name: " + name + ", Gender: " + gender + ", Height: " + height + " cm");
        System.out.println("Stats - Strength: " + strength + ", Charisma: " + charisma + 
                           ", Magic: " + magic + ", Constitution: " + constitution + ", Luck: " + luck);
        System.out.println("Health: " + health + ", Mana: " + mana);
    }
}
