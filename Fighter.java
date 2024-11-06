// Fighter class, inherits from Character
public class Fighter extends Character {
    // Constructor to initialize a Fighter with additional bonuses
    public Fighter(String name, String gender, int height) {
        super(name, gender, height);
        this.strength += 3;        // Fighter gets a bonus to Strength
        this.constitution += 2;    // Fighter gets a bonus to Constitution
        calculateDerivedStats();   // Recalculate health and mana
    }

    // Display character information specific to the Fighter class
    @Override
    public void displayCharacterInfo() {
        System.out.println("Character Class: Fighter");
        System.out.println("Name: " + name + ", Gender: " + gender + ", Height: " + height + " cm");
        System.out.println("Stats - Strength: " + strength + ", Charisma: " + charisma + 
                           ", Magic: " + magic + ", Constitution: " + constitution + ", Luck: " + luck);
        System.out.println("Health: " + health + ", Mana: " + mana);
    }
}
