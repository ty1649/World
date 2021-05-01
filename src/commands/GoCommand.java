package commands;

import main.*;

public class GoCommand implements Command {
    private Player p;
    private String nodeName;

    public GoCommand() {
        this.p = Graph.getInstance().getPlayer();
    }

    @Override
    public void init(String userString) {
        this.nodeName = userString.substring(3).trim();
    }

    @Override
    public boolean execute() {
        p.moveToRoom(nodeName);
        return false;
    }

    @Override
    public String getCommandWord() {
        return "go";
    }
}
