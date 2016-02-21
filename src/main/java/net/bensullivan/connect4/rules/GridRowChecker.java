package net.bensullivan.connect4.rules;

import net.bensullivan.connect4.model.Frame;
import net.bensullivan.connect4.model.Line;
import net.bensullivan.connect4.model.Position;

import java.util.ArrayList;
import java.util.List;

public class GridRowChecker {

    public Position checkRows(Frame frame) {
        Position[][] grid = frame.getGrid();
        List<Line> rows = getGridRows(frame, grid);
        for (Line line : rows) {
            if (line.hasSequenceOfFour(Position.YELLOW)) return Position.YELLOW;
            if (line.hasSequenceOfFour(Position.RED)) return Position.RED;
        }
        return Position.EMPTY;
    }

    private List<Line> getGridRows(Frame frame, Position[][] grid) {
        List<Line> rows = new ArrayList<>();
        for (int i = 0; i < frame.getFrameDimension().getNumRows(); i++) {
            Line row = new Line();
            for (int j = 0; j < frame.getFrameDimension().getNumColumns(); j++) {
                row.add(grid[i][j]);
            }
            rows.add(row);
        }
        return rows;
    }
}
