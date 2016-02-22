package net.bensullivan.connect4;

import net.bensullivan.connect4.cli.CLIFrameDimensionParser;
import net.bensullivan.connect4.cli.CLITurnColumnParser;
import net.bensullivan.connect4.model.Checker;
import net.bensullivan.connect4.model.Frame;
import net.bensullivan.connect4.model.FrameDimension;
import net.bensullivan.connect4.model.Result;
import net.bensullivan.connect4.rules.ResultChecker;

public class Connect4 {

    private final CLIFrameDimensionParser cliFrameDimensionParser;
    private final CLITurnColumnParser cliTurnColumnParser;
    private final ResultChecker resultChecker;

    private Frame frame;
    private Result result = Result.PENDING;

    public Connect4(CLIFrameDimensionParser cliFrameDimensionParser, CLITurnColumnParser cliTurnColumnParser
                    , ResultChecker resultChecker) {
        this.cliFrameDimensionParser = cliFrameDimensionParser;
        this.cliTurnColumnParser = cliTurnColumnParser;
        this.resultChecker = resultChecker;
    }

    public Connect4 frameDimensions(String userInput) {
        FrameDimension frameDimension = cliFrameDimensionParser.parseFrameDimension(userInput);
        frame = new Frame(frameDimension);
        return this;
    }

    public Result yellowsTurn(String userInput) {
        int columnIndex = cliTurnColumnParser.parse(userInput);
        System.out.println("YELLOW chooses slot " + columnIndex + ":");
        frame.dropCheckerIntoSlot(Checker.YELLOW, columnIndex);
        result = resultChecker.check(frame);
        return result;
    }

    public Result redsTurn(String userInput) {
        int columnIndex = cliTurnColumnParser.parse(userInput);
        System.out.println("RED chooses slot " + columnIndex + ":");
        frame.dropCheckerIntoSlot(Checker.RED, columnIndex);
        result = resultChecker.check(frame);
        return result;
    }

    public Frame getFrame() {
        return frame;
    }

    public Result getResult() {
        return result;
    }
}
