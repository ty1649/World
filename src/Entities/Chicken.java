package Entities;

public class Chicken extends GenericEntity {
    public Chicken(String name, String description) {
        super("Entities.Chicken", name, description);
    }

    public Chicken(String name) {
        super("Entities.Chicken", name, "none");
    }

    public void move() {
        if(getRoom().getNeighborList().size() != 0) {
//            System.out.println("chicken debug---" + getName());
//            System.out.println(getRoom().getNeighborNames());
//            System.out.println("---");
            int rand = (int) (Math.random() * getRoom().getNeighborList().size());
            getRoom().getNeighborList().get(rand).addAnimals(getRoom().removeAnimals(this));
        }
    }
}
