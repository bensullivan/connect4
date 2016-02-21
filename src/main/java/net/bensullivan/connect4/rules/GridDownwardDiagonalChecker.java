package net.bensullivan.connect4.rules;

import net.bensullivan.connect4.model.Frame;
import net.bensullivan.connect4.model.Line;
import net.bensullivan.connect4.model.Position;

import java.util.ArrayList;
import java.util.List;

public class GridDownwardDiagonalChecker {

    public Position checkDownwardDiagonals(Frame frame) {
        Position[][] grid = frame.getGrid();
        List<Line> upwardDiagonals = getGridDownwardDiagonals(frame, grid);
        for (Line line : upwardDiagonals) {
            if (line.hasSequenceOfFour(Position.YELLOW)) return Position.YELLOW;
            if (line.hasSequenceOfFour(Position.RED)) return Position.RED;
        }
        return Position.EMPTY;
    }

    private List<Line> getGridDownwardDiagonals(Frame frame, Position[][] grid) {
        List<Line> downwardDiagonals = new ArrayList<>();
        for (int i = 0; i < frame.getFrameDimension().getNumRows() - 3; i++) {
            Line downwardDiagonal = new Line();
            for (int j = i, k = 0; j < frame.getFrameDimension().getNumRows()
                    && k < frame.getFrameDimension().getNumColumns(); j++, k++) {
                downwardDiagonal.add(grid[j][k]);
            }
            downwardDiagonals.add(downwardDiagonal);
        }
        for (int j = 1; j < frame.getFrameDimension().getNumColumns() - 3; j++) {
            Line downwardDiagonal = new Line();
            for (int i = 0, k = j; i < frame.getFrameDimension().getNumRows() &&
                    k < frame.getFrameDimension().getNumColumns(); i++, k++) {
                downwardDiagonal.add(grid[i][k]);
            }
            downwardDiagonals.add(downwardDiagonal);
        }
        return downwardDiagonals;
    }
}
