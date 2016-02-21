package net.bensullivan.connect4;

import net.bensullivan.connect4.cli.CLIFrameDimensionParser;
import net.bensullivan.connect4.cli.CLITurnColumnParser;
import net.bensullivan.connect4.model.Checker;
import net.bensullivan.connect4.model.Frame;
import net.bensullivan.connect4.model.FrameDimension;

public class Connect4 {

    private Frame frame;
    private final CLIFrameDimensionParser cliFrameDimensionParser;
    private final CLITurnColumnParser cliTurnColumnParser;

    public Connect4(CLIFrameDimensionParser cliFrameDimensionParser, CLITurnColumnParser cliTurnColumnParser) {
        this.cliFrameDimensionParser = cliFrameDimensionParser;
        this.cliTurnColumnParser = cliTurnColumnParser;
    }

    public Frame boardDimensions(String userInput) {
        FrameDimension frameDimension = cliFrameDimensionParser.parseFrameDimension(userInput);
        frame = new Frame(frameDimension);
        return frame;
    }

    public Frame yellowsTurn(String userInput) {
        int columnIndex = cliTurnColumnParser.parse(userInput);
        System.out.println("YELLOW chooses slot " + columnIndex + ":");
        frame.dropCheckerIntoSlot(Checker.YELLOW, columnIndex);
        return frame;
    }

    public Frame redsTurn(String userInput) {
        int columnIndex = cliTurnColumnParser.parse(userInput);
        System.out.println("RED chooses slot " + columnIndex + ":");
        frame.dropCheckerIntoSlot(Checker.RED, columnIndex);
        return frame;
    }
}
