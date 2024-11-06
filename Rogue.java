// Rogue class, inherits from Character
public class Rogue extends Character {
    // Constructor to initialize a Rogue with additional bonuses
    public Rogue(String name, String gender, int height) {
        super(name, gender, height);
        this.luck += 4;            // Rogue gets a bonus to Luck
        this.strength += 1;        // Rogue gets a small bonus to Strength
        calculateDerivedStats();   // Recalculate health and mana
    }

    // Display character information specific to the Rogue class
    @Override
    public void displayCharacterInfo() {
        System.out.println("Character Class: Rogue");
        System.out.println("Name: " + name + ", Gender: " + gender + ", Height: " + height + " cm");
        System.out.println("Stats - Strength: " + strength + ", Charisma: " + charisma + 
                           ", Magic: " + magic + ", Constitution: " + constitution + ", Luck: " + luck);
        System.out.println("Health: " + health + ", Mana: " + mana);
    }
}
