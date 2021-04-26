import java.util.ArrayList;
import java.util.List;

public class Graph {
    private List<Node> nodes;
    private List<GenericEntity> allEntities;
    private Player p;

    public Graph() {
        nodes = new ArrayList<Node>();
        allEntities = new ArrayList<GenericEntity>();
    }

    public Graph.Node getPlayerLocation() {
        return p.getCurrentRoom();
    }

    public void setPlayer(Player p) {
        this.p = p;
    }

    public void addNode(String name) {
        nodes.add(new Node(name));
    }

    public void addDirectedEdge(String name1, String name2) {
        Node n1 = getNode(name1);
        Node n2 = getNode(name2);
        n1.addNeighbor(n2);
    }

    public void addUndirectedEdge(String name1, String name2) {
        Node n1 = getNode(name1);
        Node n2 = getNode(name2);
        n1.addNeighbor(n2);
        n2.addNeighbor(n1);
    }

    protected void addAnimal(GenericEntity e) {
        allEntities.add(e);
    }

    public Node getNode(String name) {
        for (int i = 0; i < nodes.size(); i++) {
            if (nodes.get(i).getName().equals(name)) {
                return nodes.get(i);
            }
        }
        return null;
    }

    public void moveAnimals(Player p) {
        for (int i = 0; i < allEntities.size(); i++) {
            allEntities.get(i).move();
//            System.out.println(nodes.get(i).getName());
        }
    }

    public void createChicken(String node, String chickenName) {
        if(getNode(node) != null) {
            getNode(node).addAnimals(new Chicken(chickenName));
        }
    }

    public void createWumpus(String node, String wumpusName) {
        if(getNode(node) != null) {
            getNode(node).addAnimals(new Wumpus(wumpusName));
        }
    }

    public void createPopstar(String node, String popstarName) {
        if(getNode(node) != null) {
            getNode(node).addAnimals(new Popstar(popstarName));
        }
    }

    public void createItem(String itemName, String node) {
        if(getNode(node) != null) {
            getNode(node).addItem(itemName);
        }
    }

    public class Node extends ItemContainer {
        private String name;
        private ArrayList<Node> neighbors;
        private ArrayList<GenericEntity> animals;

        private Node(String name) {
            neighbors = new ArrayList<Node>();
            animals = new ArrayList<>();
            this.name = name;
        }

        public void addNeighbor(Node n) {
            neighbors.add(n);
        }

        public void addAnimals(GenericEntity e) {
            e.setCurrentRoom(this);
            addAnimal(e);
            animals.add(e);
        }

        public boolean containsPlayer() {
            if(getPlayerLocation() == this) {
                return true;
            }
            return false;
        }

        public GenericEntity removeAnimals(GenericEntity e) {
            for (int i = 0; i < animals.size(); i++) {
                if(animals.get(i) == e) {
                    animals.remove(i);
                    return e;
                }
            }
            return null;
        }

        public GenericEntity getAnimal(String name) {
            for (int i = 0; i < animals.size(); i++) {
                if(animals.get(i).getName().equals(name)) {
                    return animals.get(i);
                }
            }
            return null;
        }

        public void getAnimalNames() {
            String all = "Animals: ";
            for (int i = 0; i < animals.size(); i++) {
                all = all + animals.get(i).getName() + " (" + animals.get(i).getSpecies() + "), ";
            }
            if(animals.size() > 0) System.out.println(all.substring(0, all.length()-2));
            else System.out.println("no animals");
        }

        public String getNeighborNames() {
            String all = "";
            for (int i = 0; i < neighbors.size(); i++) {
                all = all + neighbors.get(i).getName() + ", ";
            }
            if(neighbors.size() > 0) return all.substring(0, all.length()-2);
            return "no neighbors";
        }

        public ArrayList<Node> getNeighborList() {
            return neighbors;
        }

        public Node getNeighbor(String name) {
            for (int i = 0; i < neighbors.size(); i++) {
                if(neighbors.get(i).getName().equals(name)) {
                    return neighbors.get(i);
                }
            }
            return null;
        }

        public void displayItems() {
            System.out.print("Items in this room: ");
            this.display();
        }

        public String getName() {
            return name;
        }
    }
}
