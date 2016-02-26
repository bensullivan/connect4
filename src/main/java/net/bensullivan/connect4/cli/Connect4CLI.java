package net.bensullivan.connect4.cli;

import net.bensullivan.connect4.Connect4;
import net.bensullivan.connect4.model.Result;
import net.bensullivan.connect4.rules.GridChecker;

import java.util.Scanner;

public class Connect4CLI {

    private static final Scanner scanner = new Scanner(System.in);

    //TODO Implement dependency injection to handle construction of object graph and weaving loggin aspect
    private static final CLIFrameDimensionParser cliFrameDimensionParser = new CLIFrameDimensionParser();
    private static final CLITurnColumnParser cliTurnColumnParser = new CLITurnColumnParser();
    private static final Connect4 connect4 = new Connect4(cliFrameDimensionParser, cliTurnColumnParser, new GridChecker());

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("> Please enter the board dimensions (number of rows, number of columns)");
        System.out.print("> ");
        connect4.frameDimensions(scanner.nextLine());
        playGame();
    }

    private static void playGame() {
        while(connect4.getResult() == Result.PENDING) {
            playRound();
        }
        switch(connect4.getResult()) {
            case YELLOW_WINS: {
                System.out.println("Yellow WINS!");
                break;
            }
            case RED_WINS: {
                System.out.println("Red WINS!");
                break;
            }
            case DRAW: {
                System.out.println("> This game is a DRAW!");
            }
        }
    }

    private static void playRound() {
        attemptTurn(() -> {
            System.out.println("> Yellows turn: ");
            System.out.print("> ");
            return connect4.yellowsTurn(scanner.next());
        });
        attemptTurn(() -> {
            System.out.println("> Reds turn: ");
            System.out.print("> ");
            return connect4.redsTurn(scanner.next());
        });
    }

    private static void attemptTurn(Turn turn) {
        do {
            if(turn.attemptTurn() == Result.INVALID_MOVE) {
                System.out.println("> INVALID MOVE - please try again.");
            }
        } while(connect4.getResult() == Result.INVALID_MOVE);
    }
}
