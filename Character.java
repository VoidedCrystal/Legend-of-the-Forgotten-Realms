import java.util.Scanner;

public abstract class Character {
    protected String name;
    protected String gender;
    protected int height;
    protected int strength;
    protected int charisma;
    protected int magic;
    protected int constitution;
    protected int luck;
    protected int level;
    protected int health;
    protected int mana;
    protected int pointsToAllocate;

    public Character(String name, String gender, int height) {
        this.name = name;
        this.gender = gender;
        this.height = height;
        this.level = 1;
        this.pointsToAllocate = 21;
        this.strength = 5;
        this.charisma = 5;
        this.magic = 5;
        this.constitution = 5;
        this.luck = 5;
        calculateDerivedStats();
    }

    public void allocateStats() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("You have " + pointsToAllocate + " points to allocate to your stats.");
        while (pointsToAllocate > 0) {
            System.out.println("Current Stats: Strength: " + strength + ", Charisma: " + charisma + 
                               ", Magic: " + magic + ", Constitution: " + constitution + ", Luck: " + luck);
            System.out.println("Points left to allocate: " + pointsToAllocate);
            System.out.println("Choose a stat to increase: (1) Strength, (2) Charisma, (3) Magic, (4) Constitution, (5) Luck");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> { strength++; pointsToAllocate--; }
                case 2 -> { charisma++; pointsToAllocate--; }
                case 3 -> { magic++; pointsToAllocate--; }
                case 4 -> { constitution++; pointsToAllocate--; }
                case 5 -> { luck++; pointsToAllocate--; }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }

        calculateDerivedStats();
    }

    protected void calculateDerivedStats() {
        this.health = constitution * 10;
        this.mana = magic * 5;
    }

    public abstract void displayCharacterInfo();
}

