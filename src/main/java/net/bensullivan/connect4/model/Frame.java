package net.bensullivan.connect4.model;

import net.bensullivan.connect4.cli.exception.InvalidMoveException;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Frame {

    private final FrameDimension frameDimension;
    private final Position[][] grid;

    public Frame(FrameDimension frameDimension) {
        this.frameDimension = frameDimension;
        //TODO Move anything but instance variable assignment out of the constructor
        grid = new Position[frameDimension.getNumRows()][frameDimension.getNumColumns()];
        Arrays.stream(grid).forEach(row -> Arrays.fill(row, Position.EMPTY));
        System.out.println("FRAME INITIALIZED: ");
        prettyPrint();
    }

    public void dropCheckerIntoSlot(Checker checker, int userSpecifiedSlotIndex) {
        int rowIndex = findFirstNonEmptyRowPositionInGridSlot(userSpecifiedSlotIndex);
        grid[rowIndex][userSpecifiedSlotIndex - 1] = Position.fromChecker(checker);
        prettyPrint();
    }

    public Position[][] getGrid() {
        return grid;
    }

    public FrameDimension getFrameDimension() {
        return frameDimension;
    }

    private int findFirstNonEmptyRowPositionInGridSlot(int columnIndex) {
        int rowIndex = frameDimension.getNumRows() - 1;
        for (; rowIndex >= 0; rowIndex--) {
            if(grid[rowIndex][columnIndex - 1] == Position.EMPTY) {
                break;
            } else if (rowIndex == 0) {
                throw new InvalidMoveException("Selected slot is full. Please choose again.");
            }
        }
        return rowIndex;
    }

    private String prettyPrint() {
        StringBuffer rowString = new StringBuffer();
        Arrays.stream(grid).forEach( row -> {
            IntStream.range(0, frameDimension.getNumColumns()).forEach( i -> {
                rowString.append(row[i]).append(" ");
            });
            rowString.append("\n");
        });
        System.out.println(rowString);
        return rowString.toString();
    }
}
