package net.bensullivan.connect4.cli

import net.bensullivan.connect4.cli.exception.InvalidFrameDimensionsException
import net.bensullivan.connect4.model.FrameDimension
import spock.lang.Specification

class Connect4CLIDimensionParserSpec extends Specification {

    static final INVALID_DIMENSIONS_MSG =
            "Supplied frame dimensions are invalid. Width and height should be integers and separated by a single space."

    def connect4CmdLineParser = new CLIFrameDimensionParser()

    def "should accept valid board dimensions"() {
        expect:
        new FrameDimension(5, 5) == connect4CmdLineParser.parseFrameDimension("5 5")
        new FrameDimension(5, 5) == connect4CmdLineParser.parseFrameDimension("5 5   ")
        new FrameDimension(4, 7) == connect4CmdLineParser.parseFrameDimension("4 7")
        new FrameDimension(4, 4) == connect4CmdLineParser.parseFrameDimension("4 4")
        new FrameDimension(7, 5) == connect4CmdLineParser.parseFrameDimension("7 5")
    }

    def "should throw an exception when invalid board dimensions are supplied"() {
        expect:
        try {
            connect4CmdLineParser.parseFrameDimension(dimensionString)
        } catch (InvalidFrameDimensionsException ifde) {
            assert expectedMessage == ifde.getMessage()
        }

        where:
        dimensionString | expectedMessage
        "0 0"           | "Supplied frame dimensions [0 0] are invalid. The frame must be at least [4 4]"
        "3 4"           | "Supplied frame dimensions [3 4] are invalid. The frame must be at least [4 4]"
        "3 3"           | "Supplied frame dimensions [3 3] are invalid. The frame must be at least [4 4]"
        "7,7"           | INVALID_DIMENSIONS_MSG
        "7  7"          | INVALID_DIMENSIONS_MSG
        "fn lancd asdk" | INVALID_DIMENSIONS_MSG
        "aDncd&*^\$#as" | INVALID_DIMENSIONS_MSG
        "7,.%7"         | INVALID_DIMENSIONS_MSG
        "7"             | INVALID_DIMENSIONS_MSG
        ""              | INVALID_DIMENSIONS_MSG
        " "             | INVALID_DIMENSIONS_MSG
    }
}