package org.example.util;

public class Rq {
    private String actionName;
    private String[] commandParts;

    public Rq(String command) {
        command = command.trim();
        commandParts = command.split(" ");
        actionName = commandParts[0];
    }

    public String getActionName() {
        return actionName;
    }

    public String getIdStr() {
        if (commandParts.length < 2) {
            return "";
        }
        return commandParts[1];
    }

    public int getId() {
        try {
            return Integer.parseInt(getIdStr());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}