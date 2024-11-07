public class HealthPotion extends Item {
    private static final long serialVersionUID = 1L;
    private int healAmount;

    public HealthPotion(String name, int healAmount) {
        super(name);
        this.healAmount = healAmount;
    }

    @Override
    public void use(Character character) {
        character.health = Math.min(character.health + healAmount, 100 + (character.constitution * 10));
        System.out.println(character.getName() + " used " + name + " and healed " + healAmount + " health!");
    }
}
