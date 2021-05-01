package items;

import java.util.ArrayList;
import java.util.List;

public class ItemContainer {
    private List<Item> items = new ArrayList<Item>();

    public void addItem(Item item) {
        if(item == null) {
            System.out.println("Could not find item.");
            return;
        }
        items.add(item);
    }

    public void addItem(String name) {
        items.add(new Item(name, "no description"));
    }

    public void addItem(String name, String description) {
        items.add(new Item(name, description));
    }

    public Item removeItem(String name) {
        int temp = getIndexForItem(name);
        if(temp != -1) {
            Item item = items.get(temp);
            items.remove(temp);
            return item;
        }

        return null;
    }

    public boolean contains(String itemName) {
        return (getIndexForItem(itemName) != -1);
    }

    public void display() {
        String output = "";
        for (int i = 0; i < items.size(); i++) {
            output += items.get(i).getName() + ", ";
        }
        if(items.size() > 0) System.out.println(output.substring(0, output.length()-2));
        else {
            System.out.println("no items");
        }
    }

    private int getIndexForItem(String name) {
        for (int index = 0; index < items.size(); index++) {
            if (items.get(index).getName().equals(name)) {
                return index;
            }
        }
        return -1;
    }
}
