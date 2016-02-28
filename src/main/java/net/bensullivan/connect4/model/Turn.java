package net.bensullivan.connect4.model;

@FunctionalInterface
public interface Turn {
    Result attemptTurn();
}
