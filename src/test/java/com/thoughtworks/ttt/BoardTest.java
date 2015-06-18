package com.thoughtworks.ttt;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by eugenew on 6/18/15.
 */
public class BoardTest {

    private String[] loc;
    private String topLine;
    private String middleLine;
    private String bottomLine;
    private String dividers;
    private PrintStream printStream;
    private Board board;

    @Before
    public void setUp(){
        printStream = mock(PrintStream.class);
        loc = new String[]{" ", " ", " ", " ", " ", " ", " ", " ", " "};
        dividers = "---------";
        board = new Board(printStream);
    }

    @Test
    public void shouldDrawEmptyBoardWhenGameBegins(){
        topLine = loc[0] + "|" + loc[1] + "|" + loc[2];
        middleLine = loc[3] + "|" + loc[4] + "|" + loc[5];
        bottomLine = loc[6] + "|" + loc[7] + "|" + loc[8];
        String boardLayout = String.format("%-5s\n%-5s\n%-5s\n%-5s\n%-5s", topLine, dividers, middleLine, dividers, bottomLine);

        board.drawBoard();

        verify(printStream).println(boardLayout);
    }

    @Test
    public void shouldDrawXInPositionOneWhenAddingMove(){
        loc[0] = " X ";
        topLine = loc[0] + "|" + loc[1] + "|" + loc[2];
        middleLine = loc[3] + "|" + loc[4] + "|" + loc[5];
        bottomLine = loc[6] + "|" + loc[7] + "|" + loc[8];
        String boardLayout = String.format("%-5s\n%-5s\n%-5s\n%-5s\n%-5s", topLine, dividers, middleLine, dividers, bottomLine);

        board.addMove(1, " X ");
        board.drawBoard();

        verify(printStream).println(boardLayout);
    }

    @Test
    public void shouldDrawNothingWhenInvalidInputIsGiven(){
        topLine = loc[0] + "|" + loc[1] + "|" + loc[2];
        middleLine = loc[3] + "|" + loc[4] + "|" + loc[5];
        bottomLine = loc[6] + "|" + loc[7] + "|" + loc[8];
        String boardLayout = String.format("%-5s\n%-5s\n%-5s\n%-5s\n%-5s", topLine, dividers, middleLine, dividers, bottomLine);

        board.addMove(10, " X ");
        board.drawBoard();

        verify(printStream).println(boardLayout);
    }

    @Test
    public void shouldDrawXInPositionOneAndOInPositionTwo(){
        loc[0] = " X ";
        loc[1] = " O ";
        topLine = loc[0] + "|" + loc[1] + "|" + loc[2];
        middleLine = loc[3] + "|" + loc[4] + "|" + loc[5];
        bottomLine = loc[6] + "|" + loc[7] + "|" + loc[8];
        String boardLayout = String.format("%-5s\n%-5s\n%-5s\n%-5s\n%-5s", topLine, dividers, middleLine, dividers, bottomLine);

        board.addMove(1, " X ");
        board.addMove(2, " O ");
        board.drawBoard();

        verify(printStream).println(boardLayout);
    }

    @Test
    public void shouldGiveErrorMessageWhenTryingToPlaceInOccupiedSpot(){
        board.addMove(1, " X ");
        board.addMove(1, " O ");

        verify(printStream).println("Location Already Taken");
    }
}
