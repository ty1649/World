public class AddRoomCommand implements Command {
    private Player p;
    private Graph g;
    private String nodeName;

    public AddRoomCommand(Graph g, Player p) {
        this.p = p;
        this.g = g;
    }


    @Override
    public void init(String userString) {
        this.nodeName = userString.substring(9).trim();
    }

    @Override
    public boolean execute() {
        g.addNode(nodeName);
        g.addUndirectedEdge(p.getCurrentRoom().getName(), nodeName);
        return false;
    }

    @Override
    public String getCommandWord() {
        return "add room";
    }
}
