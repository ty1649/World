package Entities;

import java.util.ArrayList;

public class Popstar extends GenericEntity {
    public Popstar(String name, String description) {
        super("Entities.Popstar", name, "always hiding");

    }

    public Popstar(String name) {
        super("Entities.Popstar", name, "<3 you");
    }

    public void move() {
        ArrayList<Graph.Node> neigbors = getRoom().getNeighborList();
//        System.out.println(neigbors.get(0).getName());
        for (int i = 0; i < neigbors.size(); i++) {
//            System.out.print(neigbors.get(i).getName() + " current: ");
//            System.out.println(p.getCurrentRoom().getName());
            if(neigbors.get(i).containsPlayer()) {
                getRoom().getNeighborList().get(i).addAnimals(getRoom().removeAnimals(this));
                return;
            }
        }
    }
}
