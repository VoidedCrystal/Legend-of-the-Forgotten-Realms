public class ManaPotion extends Item {
    private static final long serialVersionUID = 1L;
    private int manaAmount;

    public ManaPotion(String name, int manaAmount) {
        super(name);
        this.manaAmount = manaAmount;
    }

    @Override
    public void use(Character character) {
        character.mana = Math.min(character.mana + manaAmount, 100 + (character.magic * 5));
        System.out.println(character.getName() + " used " + name + " and restored " + manaAmount + " mana!");
    }
}
