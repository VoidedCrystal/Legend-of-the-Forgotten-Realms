import java.io.Serializable;

public class Armor implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private int defense;

    public Armor(String name, int defense) {
        this.name = name;
        this.defense = defense;
    }

    public String getName() {
        return name;
    }

    public int getDefense() {
        return defense;
    }
}
