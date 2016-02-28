package net.bensullivan.connect4.rules;

import net.bensullivan.connect4.model.Frame;
import net.bensullivan.connect4.model.Line;
import net.bensullivan.connect4.model.Position;

import java.util.ArrayList;
import java.util.List;

//TODO Refactor this component to adopt a more functional implementation
public class GridUpwardDiagonalChecker {

    public Position checkUpwardDiagonals(Frame frame) {
        Position[][] grid = frame.getGrid();
        List<Line> upwardDiagonals = getGridUpwardDiagonals(frame, grid);
        for (Line line : upwardDiagonals) {
            if (line.hasSequenceOfFour(Position.YELLOW)) return Position.YELLOW;
            if (line.hasSequenceOfFour(Position.RED)) return Position.RED;
        }
        return Position.EMPTY;
    }

    private List<Line> getGridUpwardDiagonals(Frame frame, Position[][] grid) {
        List<Line> upwardDiagonals = new ArrayList<>();
        for (int i = 3; i < frame.getFrameDimension().getNumRows(); i++) {
            Line upwardDiagonal = new Line();
            for (int j = i, k = 0; j >= 0 && k < frame.getFrameDimension().getNumColumns(); j--, k++) {
                upwardDiagonal.add(grid[j][k]);
            }
            upwardDiagonals.add(upwardDiagonal);
        }
        for (int j = 1; j < frame.getFrameDimension().getNumColumns() - 3; j++) {
            Line upwardDiagonal = new Line();
            for (int i = frame.getFrameDimension().getNumRows() - 1, k = j; i >= 0 && k < frame.getFrameDimension().getNumColumns(); i--, k++) {
                upwardDiagonal.add(grid[i][k]);
            }
            upwardDiagonals.add(upwardDiagonal);
        }
        return upwardDiagonals;
    }
}
