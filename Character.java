import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class Character implements Serializable {
    private static final long serialVersionUID = 1L;

    // Character attributes
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
    protected int experience;
    protected int experienceToNextLevel;

    // Inventory and equipment
    protected Weapon equippedWeapon;
    protected Armor equippedArmor;
    protected List<Item> inventory;

    // Constructor
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
        this.experience = 0;
        this.experienceToNextLevel = 100;
        this.inventory = new ArrayList<>();
        calculateDerivedStats();
    }

    // Method to calculate health and mana
    protected void calculateDerivedStats() {
        this.health = 100 + (constitution * 10);
        this.mana = 100 + (magic * 5);
    }

    // Method to equip a weapon
    public void equipWeapon(Weapon weapon) {
        this.equippedWeapon = weapon;
        System.out.println(name + " equipped " + weapon.getName() + "!");
    }

    // Method to equip armor
    public void equipArmor(Armor armor) {
        this.equippedArmor = armor;
        System.out.println(name + " equipped " + armor.getName() + "!");
    }

    // Method to use an item
    public void useItem(Item item) {
        if (inventory.contains(item)) {
            item.use(this);
            inventory.remove(item);
        } else {
            System.out.println("Item not found in inventory.");
        }
    }

    // Method to display inventory
    public void showInventory() {
        System.out.println("=== Inventory ===");
        if (inventory.isEmpty()) {
            System.out.println("Inventory is empty.");
        } else {
            for (Item item : inventory) {
                System.out.println(item.getName());
            }
        }
        System.out.println("=================");
    }

    // Combat method
    public void attack(Character enemy) {
        int damage = strength + (equippedWeapon != null ? equippedWeapon.getDamage() : 0);
        damage -= (enemy.equippedArmor != null ? enemy.equippedArmor.getDefense() : 0);
        damage = Math.max(damage, 0); // Ensure damage isn't negative
        enemy.takeDamage(damage);
        System.out.println(name + " attacks " + enemy.getName() + " for " + damage + " damage!");
    }

    // Method to take damage
    public void takeDamage(int damage) {
        health -= damage;
        if (health <= 0) {
            health = 0;
            System.out.println(name + " has been defeated!");
        } else {
            System.out.println(name + " has " + health + " health remaining.");
        }
    }

    // Spell casting method
    public void castSpell(String spell, Character enemy) {
        if (spell.equals("Fireball") && level >= 2) {
            if (mana >= 20) {
                int damage = magic * 2;
                mana -= 20;
                enemy.takeDamage(damage);
                System.out.println(name + " casts Fireball, dealing " + damage + " damage to " + enemy.getName() + "!");
            } else {
                System.out.println("Not enough mana to cast Fireball!");
            }
        } else if (spell.equals("Heal") && level >= 3) {
            if (mana >= 15) {
                int healAmount = magic * 3;
                mana -= 15;
                health = Math.min(health + healAmount, 100 + (constitution * 10));
                System.out.println(name + " casts Heal, restoring " + healAmount + " health!");
            } else {
                System.out.println("Not enough mana to cast Heal!");
            }
        } else {
            System.out.println("Spell not available or insufficient level!");
        }
    }

    public abstract void displayCharacterInfo();

    // Additional getters and setters
    public String getName() {
        return name;
    }
}
