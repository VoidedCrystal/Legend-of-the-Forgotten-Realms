public class Fighter extends Character {
    public Fighter(String name, String gender, int height) {
        super(name, gender, height);
        this.strength += 3;
        this.constitution += 2;
        calculateDerivedStats();
    }

    @Override
    public void displayCharacterInfo() {
        System.out.println("Character Class: Fighter");
        System.out.println("Name: " + name + ", Gender: " + gender + ", Height: " + height + " cm");
        System.out.println("Stats - Strength: " + strength + ", Charisma: " + charisma + 
                           ", Magic: " + magic + ", Constitution: " + constitution + ", Luck: " + luck);
        System.out.println("Health: " + health + ", Mana: " + mana);
    }
}
