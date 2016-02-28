package net.bensullivan.connect4;

import net.bensullivan.connect4.cli.CLIFrameDimensionParser;
import net.bensullivan.connect4.cli.CLITurnColumnParser;
import net.bensullivan.connect4.cli.exception.InvalidMoveException;
import net.bensullivan.connect4.model.Checker;
import net.bensullivan.connect4.model.Frame;
import net.bensullivan.connect4.model.FrameDimension;
import net.bensullivan.connect4.model.Result;
import net.bensullivan.connect4.rules.GridChecker;

public class Connect4 {

    private final CLIFrameDimensionParser cliFrameDimensionParser;
    private final CLITurnColumnParser cliTurnColumnParser;
    private final GridChecker gridChecker;

    private Frame frame;
    private Result result = Result.PENDING;

    public Connect4(CLIFrameDimensionParser cliFrameDimensionParser, CLITurnColumnParser cliTurnColumnParser
            , GridChecker gridChecker) {
        this.cliFrameDimensionParser = cliFrameDimensionParser;
        this.cliTurnColumnParser = cliTurnColumnParser;
        this.gridChecker = gridChecker;
    }

    public Connect4 frameDimensions(String userInput) {
        FrameDimension frameDimension = cliFrameDimensionParser.parseFrameDimension(userInput);
        frame = new Frame(frameDimension);
        return this;
    }

    public Result yellowsTurn(String userInput) {
        int columnIndex = cliTurnColumnParser.parse(userInput);
        System.out.println("YELLOW chooses slot " + columnIndex + ":");
        result = tryDroppingCheckerIntoSlot(Checker.YELLOW, columnIndex);
        return result;
    }

    public Result redsTurn(String userInput) {
        int columnIndex = cliTurnColumnParser.parse(userInput);
        System.out.println("RED chooses slot " + columnIndex + ":");
        result = tryDroppingCheckerIntoSlot(Checker.RED, columnIndex);
        return result;
    }

    public Frame getFrame() {
        return frame;
    }

    public Result getResult() { return result; }

    public GridChecker getGridChecker() { return gridChecker; }

    public void setResult(Result result) { this.result = result; }

    private Result tryDroppingCheckerIntoSlot(Checker checker, int columnIndex) {
        try {
            if (gridChecker.isGridFull(frame)) {
                return Result.DRAW;
            } else if (columnIndex > frame.getFrameDimension().getNumColumns()) {
                throw new RuntimeException("The frame slot index is invalid: " + columnIndex);
            }
            frame.dropCheckerIntoSlot(checker, columnIndex);
        } catch (InvalidMoveException ime) {
            return Result.INVALID_MOVE;
        }
        return gridChecker.checkResult(frame);
    }
}
