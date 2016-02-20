package net.bensullivan.connect4;

import net.bensullivan.connect4.cli.Connect4CLIFrameDimensionParser;

public class Connect4 {

    Connect4CLIFrameDimensionParser cliFrameDimensionParser;

    public Connect4(Connect4CLIFrameDimensionParser cliFrameDimensionParser) {
        this.cliFrameDimensionParser = cliFrameDimensionParser;
    }

    public static void main(String[] args) {
        System.out.println("This is the entry point for Connect4!");
    }

    public void enter(String userInput) {
        cliFrameDimensionParser.parseFrameDimension(userInput);
    }
}
