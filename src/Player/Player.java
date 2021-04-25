package Player;

import Items.ItemContainer;

public class Player extends ItemContainer {
    private String name, description;
    private Graph.Node currentRoom;

    public Player(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public void displayInventory() {
        System.out.print("Player.Player Items: ");
        this.display();
    }

    public Graph.Node getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Graph.Node newroom) {
        currentRoom = newroom;
    }

    public boolean moveToRoom(String name) {
        Graph.Node temp = currentRoom.getNeighbor(name);
        if(temp != null) {
            setCurrentRoom(temp);
            return true;
        }
        System.out.println("You can't go to " + name + " try again");
        return false;
    }
}
