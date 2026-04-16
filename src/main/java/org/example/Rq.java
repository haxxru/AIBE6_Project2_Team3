package org.example;

public class Rq {
    private String actionName;
    private String[] cmdBits;

    public Rq(String cmd) {
        cmd = cmd.trim();
        cmdBits = cmd.split(" ");
        actionName = cmdBits[0];
    }

    public String getActionName() {
        return actionName;
    }

    public String getIdStr() {
        if (cmdBits.length < 2) {
            return "";
        }
        return cmdBits[1];
    }

    public int getId() {
        try {
            return Integer.parseInt(getIdStr());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}