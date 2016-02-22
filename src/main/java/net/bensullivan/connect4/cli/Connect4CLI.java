package net.bensullivan.connect4.cli;

import net.bensullivan.connect4.Connect4;
import net.bensullivan.connect4.model.Result;
import net.bensullivan.connect4.rules.ResultChecker;

import java.util.Scanner;

public class Connect4CLI {

    static CLIFrameDimensionParser cliFrameDimensionParser = new CLIFrameDimensionParser();
    static CLITurnColumnParser cliTurnColumnParser = new CLITurnColumnParser();
    static Connect4 connect4 = new Connect4(cliFrameDimensionParser, cliTurnColumnParser, new ResultChecker());

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("> Please enter the board dimensions (number of rows, number of columns)");
        System.out.print("> ");
        connect4.frameDimensions(scanner.nextLine());
        playGame(scanner);
    }

    private static void playGame(Scanner scanner) {
        while(connect4.getResult() == Result.PENDING) {
            System.out.println("> Yellows turn: ");
            System.out.print("> ");
            connect4.yellowsTurn(scanner.next());
            if (connect4.getResult() == Result.YELLOW_WINS) {
                System.out.println("Yellow WINS!");
                return;
            }
            System.out.println("> Reds turn: ");
            System.out.print("> ");
            connect4.redsTurn(scanner.next());
            if (connect4.getResult() == Result.RED_WINS) {
                System.out.println("Red WINS!");
                return;
            }
        }
    }
}
