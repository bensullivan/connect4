package net.bensullivan.connect4.cli;

import net.bensullivan.connect4.model.Result;

@FunctionalInterface
public interface Turn {
    Result attemptTurn();
}
