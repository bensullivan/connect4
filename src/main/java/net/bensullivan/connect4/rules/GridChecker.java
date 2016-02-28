package net.bensullivan.connect4.rules;

import net.bensullivan.connect4.model.*;

import java.util.List;

public class GridChecker {

    //TODO Implement lightweight dependency injection (e.g. Silk DI) to abstract out the construction of the object graph
    GridColumnChecker columnChecker = new GridColumnChecker();
    GridRowChecker rowChecker = new GridRowChecker();
    GridUpwardDiagonalChecker upwardDiagonalChecker = new GridUpwardDiagonalChecker();
    GridDownwardDiagonalChecker downwardDiagonalChecker = new GridDownwardDiagonalChecker();

    //TODO Refactor this as we are unnecessarily repeating what we don't need to...
    public Result checkResult(Frame frame) {
        if (columnChecker.checkColumns(frame) == Position.RED) return Result.RED_WINS;
        if (columnChecker.checkColumns(frame) == Position.YELLOW) return Result.YELLOW_WINS;
        if (rowChecker.checkRows(frame) == Position.RED) return Result.RED_WINS;
        if (rowChecker.checkRows(frame) == Position.YELLOW) return Result.YELLOW_WINS;
        if (upwardDiagonalChecker.checkUpwardDiagonals(frame) == Position.RED) return Result.RED_WINS;
        if (upwardDiagonalChecker.checkUpwardDiagonals(frame) == Position.YELLOW) return Result.YELLOW_WINS;
        if (downwardDiagonalChecker.checkDownwardDiagonals(frame) == Position.RED) return Result.RED_WINS;
        if (downwardDiagonalChecker.checkDownwardDiagonals(frame) == Position.YELLOW) return Result.YELLOW_WINS;
        return Result.PENDING;
    }

    public boolean isGridFull(Frame frame) {
        List<Line> cols = columnChecker.getGridColumns(frame);
        for (Line line : cols) {
            if (line.isNotFull()){ return false; }
        }
        return true;
    }
}
