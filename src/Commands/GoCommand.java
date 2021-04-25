package Commands;

public class GoCommand implements Command {
    private Player p;
    private Graph g;
    private String nodeName;

    public GoCommand(Graph g, Player p) {
        this.p = p;
        this.g = g;
    }

    @Override
    public void init(String userString) {
        this.nodeName = userString.substring(3).trim();
    }

    @Override
    public boolean execute() {
        if(p.moveToRoom(nodeName)) {
            g.moveAnimals(p);
        }
        return false;
    }

    @Override
    public String getCommandWord() {
        return "go";
    }
}
