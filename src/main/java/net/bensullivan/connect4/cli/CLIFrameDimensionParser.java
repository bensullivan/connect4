package net.bensullivan.connect4.cli;

import net.bensullivan.connect4.cli.exception.InvalidFrameDimensionsException;
import net.bensullivan.connect4.model.FrameDimension;

public class CLIFrameDimensionParser {

    public static final String SPACE = " ";

    public FrameDimension parseFrameDimension(String dimensionString) {
        return parse(dimensionString);
    }

    private FrameDimension parse(String dimensionString) {
        int[] dimensions = tokenize(dimensionString);
        int numRows = dimensions[0];
        int numColumns = dimensions[1];
        if (numRows < 4 || numColumns < 4) {
            throw new InvalidFrameDimensionsException(
                    "Supplied frame dimensions ["
                            + numRows + " " + numColumns + "] are invalid. The frame must be at least [4 4]");
        }
        return new FrameDimension(numRows, numColumns);
    }

    private int[] tokenize(String dimensionString) {
        try {
            String[] dimStrings = dimensionString.split(SPACE);
            return new int[]{Integer.parseInt(dimStrings[0]), Integer.parseInt(dimStrings[1])};
        } catch (NumberFormatException|IndexOutOfBoundsException e) {
            throw new InvalidFrameDimensionsException("Supplied frame dimensions are invalid. "
                    + "Width and height should be integers and separated by a single space.");
        }
    }
}
