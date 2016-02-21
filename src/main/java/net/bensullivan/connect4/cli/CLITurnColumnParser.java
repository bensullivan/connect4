package net.bensullivan.connect4.cli;

public class CLITurnColumnParser {

    public int parse(String columnPlayerInput) {
        try {
            return Integer.parseInt(columnPlayerInput);
        } catch(NumberFormatException nfe) {
            throw new RuntimeException("The frame slot index is invalid: " + columnPlayerInput);
        }
    }
}
