package Commands;

public class TakeCommand implements Command {
    private Player player;
    private String itemName;

    public TakeCommand(Player p) {
        this.player = p;
    }

    @Override
    public void init(String userString) {
        this.itemName = userString.substring(5).trim();
    }

    @Override
    public boolean execute() {
        player.addItem(player.getCurrentRoom().removeItem(itemName));
        return false;
    }

    @Override
    public String getCommandWord() {
        return "take";
    }
}
