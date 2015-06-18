package com.thoughtworks.ttt;

import java.io.PrintStream;

/**
 * Created by eugenew on 6/18/15.
 */
public class Board {


    private PrintStream printStream;
    private final String[] loc;

    public Board(PrintStream printStream) {

        this.printStream = printStream;
        loc = new String[]{" ", " ", " ", " ", " ", " ", " ", " ", " "};
    }

    public void drawBoard() {
        String topLine = loc[0] + "|" + loc[1] + "|" + loc[2];
        String middleLine = loc[3] + "|" + loc[4] + "|" + loc[5];
        String bottomLine = loc[6] + "|" + loc[7] + "|" + loc[8];
        String dividers = "---------";
        String board = String.format("%-5s\n%-5s\n%-5s\n%-5s\n%-5s",topLine,dividers,middleLine,dividers,bottomLine);
        printStream.println(board);
    }

    public boolean addMove(int location, String mark) {
        if(location >= 1 && location <= 9) {
            if(loc[location-1].equals(" ")) {
                loc[location - 1] = mark;
                return true;
            } else {
                return false;
            }
        }
        return true;
    }
}
