package net.bensullivan.connect4

import net.bensullivan.connect4.cli.Connect4CLIFrameDimensionParser
import net.bensullivan.connect4.cli.exception.InvalidFrameDimensionsException
import spock.lang.Ignore
import spock.lang.Specification

class Connect4AcceptanceSpec extends Specification {

    static final INVALID_DIMENSIONS_MSG =
            "Supplied frame dimensions are invalid. Width and height should be integers and separated by a single space."

    def connect4 = new Connect4(new Connect4CLIFrameDimensionParser());

    @Ignore
    def "Scenario 1: Yellow should win with 4 horizontal checkers"() {
        expect:
        println("Not yet implemented")
    }

    @Ignore
    def "Scenario 2: Red should win with 4 vertical checkers"() {
        expect:
        println("Not yet implemented")
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
        connect4.enter("0 0")

        then:
        InvalidFrameDimensionsException ifde = thrown()
        ifde.message == "Supplied frame dimensions [0 0] are invalid. The frame must be at least [4 4]"
    }

    @Ignore
    def "Scenario 6: Invalid move"() {
        expect:
        println("Not yet implemented")
    }
}
