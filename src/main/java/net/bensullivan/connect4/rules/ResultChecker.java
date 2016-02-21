package net.bensullivan.connect4.rules;

import net.bensullivan.connect4.model.*;

public class ResultChecker {

    GridColumnChecker columnChecker = new GridColumnChecker();
    GridRowChecker rowChecker = new GridRowChecker();
    GridUpwardDiagonalChecker upwardDiagonalChecker = new GridUpwardDiagonalChecker();
    GridDownwardDiagonalChecker downwardDiagonalChecker = new GridDownwardDiagonalChecker();

    public Result check(Frame frame) {
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
}
