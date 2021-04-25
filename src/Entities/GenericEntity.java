package Entities;

public abstract class GenericEntity implements Entity {
    private String species, name, description;
    private Graph.Node currentRoom;

    public GenericEntity(String species, String name, String description) {
        this.species = species;
        this.name = name;
        this.description = description;
    }

    public Graph.Node getRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Graph.Node currentRoom) {
        this.currentRoom = currentRoom;
    }

    public String getName() {
        return name;
    }

//    public void setName(String name) {
//        this.name = name;
//    }

//    public void setDescription(String description) {
//        this.description = description;
//    }

//    public void setSpecies(String species) {
//        this.species = species;
//    }

    public String getSpecies() {
        return species;
    }

    public String getDescription() {
        return description;
    }

    public abstract void move();
}
