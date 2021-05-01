package commands;

import main.*;

public class LookCommand implements Command {
    private Player p;

    public LookCommand() {
        this.p = Graph.getInstance().getPlayer();
    }


    @Override
    public void init(String userString) {
    }

    @Override
    public boolean execute() {
        System.out.println("Neighbors: " + p.getCurrentRoom().getNeighborNames());
        p.getCurrentRoom().displayItems();
        p.getCurrentRoom().getAnimalNames();
        return false;
    }

    @Override
    public String getCommandWord() {
        return "look";
    }
}
