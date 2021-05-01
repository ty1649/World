package commands;

import java.util.HashMap;

public class CommandParser {
    private HashMap<String, Command> commands;

    public CommandParser() {
        commands = new HashMap<>();
    }

    public void addCommand(Command c) {
        commands.put(c.getCommandWord(), c);
    }

    public Command parseCommandString(String userString) {
        int space = userString.indexOf(" ");
        String firstWord = userString.substring(0, space > 0 ? space : userString.length());
        if(userString.contains("add room")) firstWord = "add room";
        if(!commands.containsKey(firstWord)) {
            displayCommands();
            return null;
        }
        else {
            Command command = commands.get(firstWord);
            command.init(userString);

            return command;
        }
    }

    private static void displayCommands() {
        System.out.println("You can do either: " +
                "\n > look " +
                "\n > add room <room> " +
                "\n > go <room> " +
                "\n > take <itemname> " +
                "\n > drop <itemname> " +
                "\n > <quit> \n");
    }
}
