package commands;

import main.*;

public class AddRoomCommand implements Command {
    private Player p;
    private String nodeName;

    public AddRoomCommand() {
        this.p = Graph.getInstance().getPlayer();
    }


    @Override
    public void init(String userString) {
        this.nodeName = userString.substring(9).trim();
    }

    @Override
    public boolean execute() {
        Graph.getInstance().addNode(nodeName);
        Graph.getInstance().addUndirectedEdge(p.getCurrentRoom().getName(), nodeName);
        return false;
    }

    @Override
    public String getCommandWord() {
        return "add room";
    }
}
