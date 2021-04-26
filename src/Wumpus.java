import java.util.ArrayList;

public class Wumpus extends GenericEntity {
    public Wumpus(String name, String description) {
        super("Wumpus", name, description);
    }

    public Wumpus(String name) {
        super("Wumpus", name, "always hiding");
    }

    public void move() {
        ArrayList<Graph.Node> neigbors = getRoom().getNeighborList();
        if(neigbors.size() > 1) {
            for (int i = 0; i < neigbors.size(); i++) {
                if(neigbors.get(i).containsPlayer()) {
                    int test = chooseNumNotIncluding(neigbors.size(), i);
                    if(test != -1) {
                        getRoom().getNeighborList().get(test).addAnimals(getRoom().removeAnimals(this));
                        return;
                    }
                    System.out.println("Could not move Wumpus: " + getName());
                }
            }
        }
    }

    //[0, end)
    private int chooseNumNotIncluding(int end, int notinclude) {
        int rand = (int) (Math.random()*end);
        int ct = 0;
        while(rand == notinclude) {
            rand = (int) (Math.random()*end);
            ct++;
            if(ct > end*10) {
                return -1;
            }
        }
        return rand;
    }
}
