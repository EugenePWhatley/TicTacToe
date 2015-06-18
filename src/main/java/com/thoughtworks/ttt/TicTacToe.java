package com.thoughtworks.ttt;

import java.io.PrintStream;

/**
 * Created by eugenew on 6/18/15.
 */
public class TicTacToe {
    private PrintStream printStream;

    public TicTacToe(PrintStream printStream) {
        this.printStream = printStream;
    }


    public static void main(String[] args) {
        new TicTacToe(System.out).start();
    }

    public void start() {
        drawBoard();
        promptUser();
    }

    private void promptUser() {
        String prompt = "Enter a number between 1 and 9 to indicate where you wish to move: ";
        printStream.println(prompt);
    }

    public void drawBoard() {
        String board = "  |   |\n" +
                "---------\n" +
                "  |   |\n" +
                "---------\n" +
                "  |   |";
        printStream.println(board);
    }

}
