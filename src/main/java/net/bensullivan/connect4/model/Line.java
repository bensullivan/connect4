package net.bensullivan.connect4.model;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private final List<Position> positions = new ArrayList<>();

    public void add(Position position) {
        positions.add(position);
    }

    public boolean isNotFull() {
        return positions.contains(Position.EMPTY);
    }

    public boolean hasSequenceOfFour(Position targetPosition) {
        if(positions.stream().filter(p -> p == Position.RED).count() < 4 &&
                positions.stream().filter(p -> p == Position.YELLOW).count() < 4) {
            return false;
        }
        boolean sequenceOfFourFound = false;
        int sequenceCount = 0;
        Position currentPosition = null;
        for (Position position : positions) {
            if (currentPosition == position && position == targetPosition) {
                sequenceCount++;
            } else {
                sequenceCount = 0;
            }
            if (sequenceCount == 3) {
                sequenceOfFourFound = true;
                break;
            }
            currentPosition = position;
        }
        return sequenceOfFourFound;
    }
}
