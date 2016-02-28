package net.bensullivan.connect4.model;

public class FrameDimension {
    private final int numRows;
    private final int numColumns;

    public FrameDimension(int numRows, int numColumns) {
        this.numRows = numRows;
        this.numColumns = numColumns;
    }

    public int getNumRows() {
        return numRows;
    }

    public int getNumColumns() {
        return numColumns;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FrameDimension that = (FrameDimension) o;
        return numRows == that.numRows && numColumns == that.numColumns;
    }
}
