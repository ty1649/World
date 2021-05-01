package commands;

import main.*;

public class DropCommand implements Command {
    private Player p;
    private String itemName;

    public DropCommand() {
        this.p = Graph.getInstance().getPlayer();
    }

    @Override
    public void init(String userString) {
        itemName = userString.substring(5).trim();
    }

    @Override
    public boolean execute() {
        p.getCurrentRoom().addItem(p.removeItem(itemName));
        return false;
    }

    @Override
    public String getCommandWord() {
        return "drop";
    }
}
