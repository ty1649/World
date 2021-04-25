public class DropCommand implements Command {
    private Player p;
    private String itemName;

    public DropCommand(Player p) {
        this.p = p;
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
