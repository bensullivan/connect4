package net.bensullivan.connect4.cli.exception;

public class InvalidMoveException extends RuntimeException {

    public InvalidMoveException(String message) {
        super(message);
    }
}
