package net.bensullivan.connect4.rules;

import net.bensullivan.connect4.model.Frame;
import net.bensullivan.connect4.model.Line;
import net.bensullivan.connect4.model.Position;

import java.util.ArrayList;
import java.util.List;

public class GridColumnChecker {

    public Position checkColumns(Frame frame) {
        Position[][] grid = frame.getGrid();
        List<Line> cols = getGridColumns(frame, grid);
        for (Line line : cols) {
            if (line.hasSequenceOfFour(Position.YELLOW)) return Position.YELLOW;
            if (line.hasSequenceOfFour(Position.RED)) return Position.RED;
        }
        return Position.EMPTY;
    }

    private List<Line> getGridColumns(Frame frame, Position[][] grid) {
        List<Line> cols = new ArrayList<>();
        for (int j = 0; j < frame.getFrameDimension().getNumColumns(); j++) {
            Line column = new Line();
            for (int i = 0; i < frame.getFrameDimension().getNumRows(); i++) {
                column.add(grid[i][j]);
            }
            cols.add(column);
        }
        return cols;
    }
}
