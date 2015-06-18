package com.thoughtworks.ttt;

import java.io.PrintStream;

/**
 * Created by eugenew on 6/18/15.
 */
public class Board {


    private PrintStream printStream;
    private String[] locs;
    private final String unoccupied = "   ";

    public Board(PrintStream printStream) {

        this.printStream = printStream;
        locs = new String[]{unoccupied, unoccupied, unoccupied, unoccupied, unoccupied, unoccupied, unoccupied, unoccupied, unoccupied};
    }

    public void drawBoard() {
        String boardLayout = locs[0] + "|" + locs[1] + "|" + locs[2] + "\n";
        boardLayout += "-----------" + "\n";
        boardLayout += locs[3] + "|" + locs[4] + "|" + locs[5] + "\n";
        boardLayout += "-----------" + "\n";
        boardLayout += locs[6] + "|" + locs[7] + "|" + locs[8];
        printStream.println(boardLayout);
    }

    public boolean addMove(int location, String mark) {
        if(location > 0) {
            if (locs[location - 1].equals(unoccupied)) {
                locs[location - 1] = mark;
                return true;
            } else {
                String errorMessage = "Location Already Occupied";
                printStream.println(errorMessage);
                return false;
            }
        }
        String errorMessage = "Invalid Location, please pick somewhere between 1 and 9";
        printStream.println(errorMessage);
        return false;
    }

    public boolean isBoardFull(){
        boolean full = true;
        for (String loc : locs) {
            if (loc.equals(unoccupied)) {
                full = false;
            }
        }
        return full;
    }
}
