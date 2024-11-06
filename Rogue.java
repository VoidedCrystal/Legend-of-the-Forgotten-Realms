public class Rogue extends Character {
    public Rogue(String name, String gender, int height) {
        super(name, gender, height);
        this.luck += 4;
        this.strength += 1;
        calculateDerivedStats();
    }

    @Override
    public void displayCharacterInfo() {
        System.out.println("Character Class: Rogue");
        System.out.println("Name: " + name + ", Gender: " + gender + ", Height: " + height + " cm");
        System.out.println("Stats - Strength: " + strength + ", Charisma: " + charisma + 
                           ", Magic: " + magic + ", Constitution: " + constitution + ", Luck: " + luck);
        System.out.println("Health: " + health + ", Mana: " + mana);
    }
}

