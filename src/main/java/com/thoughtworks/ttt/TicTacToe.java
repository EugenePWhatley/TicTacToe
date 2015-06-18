package com.thoughtworks.ttt;

import java.io.InputStreamReader;
import java.io.PrintStream;

/**
 * Created by eugenew on 6/18/15.
 */
public class TicTacToe {
    private PrintStream printStream;
    private ACAwesomeBufferedReader bufferedReader;
    private Board board;

    public TicTacToe(PrintStream printStream, ACAwesomeBufferedReader bufferedReader, Board board) {
        this.printStream = printStream;
        this.bufferedReader = bufferedReader;
        this.board = board;
    }


    public static void main(String[] args) {
        new TicTacToe(System.out, new ACAwesomeBufferedReader(new InputStreamReader(System.in)), new Board(System.out)).play();
    }

    public void play() {
        board.drawBoard();
        Player p1 = new Player(bufferedReader);
        Player p2 = new Player(bufferedReader);
        while(board.isBoardFull()) {
            boolean valid;
            do {
                promptUser();
                valid = board.addMove(p1.chooseLocation(), " X ");
            } while (!valid);
            board.drawBoard();
            do {
                promptUser();
                valid = board.addMove(p2.chooseLocation(), " O ");
            } while (!valid);
            board.drawBoard();
        }
    }

    private void promptUser() {
        String prompt = "Enter a number between 1 and 9 to indicate where you wish to move: ";
        printStream.println(prompt);
    }


}
