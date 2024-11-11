public class NPC {
    private String name;
    private String description;

    public NPC(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void interact(Character player) {
        System.out.println("You talk to " + name + ": " + description);
        // NPC interaction logic could be extended here
    }
}
