package net.bensullivan.connect4.model;

public enum Position {
    EMPTY,
    RED,
    YELLOW;

    @Override
    public String toString() {
        switch(this) {
            case EMPTY: return "o";
            case RED: return "r";
            case YELLOW: return "y";
            default: throw new IllegalArgumentException();
        }
    }

    public static Position fromChecker(Checker checker) {
        switch(checker) {
            case RED: return RED;
            default: return YELLOW;
        }
    }
}
