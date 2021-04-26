import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Graph g = new Graph();
        CommandParser parser = new CommandParser();

        Player p = new Player("Terry", "god");
        g.setPlayer(p);

        initRooms(g);
        initItems(g);
        initEntities(g);

        p.setCurrentRoom(g.getNode("hall"));

        initCommands(parser, p, g);

        String response;
        Scanner s = new Scanner(System.in);

        do {
            System.out.println("You are in the " + p.getCurrentRoom().getName());
            p.displayInventory();
            System.out.print("What do you want to do? \n> ");
            response = s.nextLine();

            if(parser.parseCommandString(response) != null) {
                Command nextCommand = parser.parseCommandString(response);
                nextCommand.execute();
            }

            System.out.println("------------------");
        } while (!response.equals("quit"));
    }

    private static void initCommands(CommandParser parser, Player p, Graph g) {
        parser.addCommand(new LookCommand(g, p));
        parser.addCommand(new AddRoomCommand(g, p));
        parser.addCommand(new GoCommand(g, p));
        parser.addCommand(new TakeCommand(p));
        parser.addCommand(new DropCommand(p));
    }

    private static void initRooms(Graph g) {
        g.addNode("hall");
        g.addNode("closet");
        g.addNode("bathroom");
        g.addUndirectedEdge("closet", "bathroom");
        g.addNode("dungeon");

        g.addNode("test2");

        g.addDirectedEdge("hall", "dungeon");
        g.addUndirectedEdge("hall", "closet");
        g.addDirectedEdge("dungeon", "test2");
    }

    private static void initItems(Graph g) {
        g.createItem("item1", "hall");
        g.createItem("item2", "hall");
        g.createItem("item3", "dungeon");
        g.createItem("item4", "closet");
    }

    private static void initEntities(Graph g) {
        g.createChicken("dungeon", "dead1");
        g.createChicken("closet", "ew");
        g.createWumpus("closet", "IF THIS DOESNT WORK");
        g.createPopstar("bathroom", "pls work");
    }
}
