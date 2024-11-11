import java.util.ArrayList;
import java.util.List;

public class Area {
    private String name;
    private String description;
    private List<NPC> npcs;
    private List<Quest> quests;

    public Area(String name, String description) {
        this.name = name;
        this.description = description;
        this.npcs = new ArrayList<>();
        this.quests = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<NPC> getNpcs() {
        return npcs;
    }

    public List<Quest> getQuests() {
        return quests;
    }

    public void addNpc(NPC npc) {
        npcs.add(npc);
    }

    public void addQuest(Quest quest) {
        quests.add(quest);
    }

    public void explore() {
        System.out.println("You explore the area and find hidden treasures and secrets.");
        // You can add more exploration logic here
    }
}
