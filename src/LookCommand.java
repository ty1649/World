public class LookCommand implements Command {
    private Player p;
    private Graph g;

    public LookCommand(Graph g, Player p) {
        this.p = p;
        this.g = g;
        Graph
    }


    @Override
    public void init(String userString) {
    }

    @Override
    public boolean execute() {
        System.out.println("Neighbors: " + g.getNode(p.getCurrentRoom().getName()).getNeighborNames());
        p.getCurrentRoom().displayItems();
        p.getCurrentRoom().getAnimalNames();
        return false;
    }

    @Override
    public String getCommandWord() {
        return "look";
    }
}
