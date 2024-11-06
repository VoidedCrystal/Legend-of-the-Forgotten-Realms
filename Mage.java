public class Mage extends Character {
    public Mage(String name, String gender, int height) {
        super(name, gender, height);
        this.magic += 4;
        this.charisma += 1;
        calculateDerivedStats();
    }

    @Override
    public void displayCharacterInfo() {
        System.out.println("Character Class: Mage");
        System.out.println("Name: " + name + ", Gender: " + gender + ", Height: " + height + " cm");
        System.out.println("Stats - Strength: " + strength + ", Charisma: " + charisma + 
                           ", Magic: " + magic + ", Constitution: " + constitution + ", Luck: " + luck);
        System.out.println("Health: " + health + ", Mana: " + mana);
    }
}

