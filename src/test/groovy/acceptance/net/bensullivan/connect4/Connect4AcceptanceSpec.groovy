package net.bensullivan.connect4

import net.bensullivan.connect4.cli.CLIFrameDimensionParser
import net.bensullivan.connect4.cli.CLITurnColumnParser
import net.bensullivan.connect4.cli.exception.InvalidFrameDimensionsException
import net.bensullivan.connect4.model.Position
import net.bensullivan.connect4.rules.ResultChecker
import spock.lang.Ignore
import spock.lang.Specification

class Connect4AcceptanceSpec extends Specification {

    def connect4 = new Connect4(new CLIFrameDimensionParser(), new CLITurnColumnParser(), new ResultChecker())

    @Ignore
    def "Scenario 1: Yellow should win with 4 horizontal checkers"() {
        expect:
        println("Not yet implemented")
    }

    def "Scenario 2: Red should win with 4 vertical checkers"() {
        expect:
        expectedInitialisedGrid(5, 4) == connect4.boardDimensions("5 4").getFrame().grid

        connect4.yellowsTurn("1");
        connect4.redsTurn("2");
        connect4.yellowsTurn("3");
        connect4.redsTurn("2");
        connect4.yellowsTurn("1");
        connect4.redsTurn("2");
        connect4.yellowsTurn("1");
        connect4.redsTurn("2");
    }

    @Ignore
    def "Scenario 3: Yellow should win with 4 diagonal checkers"() {
        expect:
        println("Not yet implemented")
    }

    @Ignore
    def "Scenario 4: Game is drawn with neither Yellow nor Red having 4 checkers in a row"() {
        expect:
        println("Not yet implemented")
    }

    def "Scenario 5: Invalid board dimensions supplied"() {
        when:
        connect4.boardDimensions("0 0")

        then:
        InvalidFrameDimensionsException ifde = thrown()
        ifde.message == "Supplied frame dimensions [0 0] are invalid. The frame must be at least [4 4]"
    }

    @Ignore
    def "Scenario 6: Invalid move"() {
        expect:
        println("Not yet implemented")
    }

    def Position[][] expectedInitialisedGrid(numRows, numColumns) {
        def grid = new Position[numRows][numColumns];
        grid.each { Position[] row ->
            Arrays.fill(row, Position.EMPTY);
        }
        return grid
    }
}
