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

    private String[] locs;
    private String boardLayout;
    private final String unoccupied = "   ";
    private PrintStream printStream;
    private Board board;

    @Before
    public void setUp(){
        printStream = mock(PrintStream.class);
        locs = new String[]{unoccupied, unoccupied, unoccupied, unoccupied, unoccupied, unoccupied, unoccupied, unoccupied, unoccupied};
        board = new Board(printStream);
    }

    @Test
    public void shouldDrawEmptyBoardWhenGameBegins(){
        boardLayout = locs[0] + "|" + locs[1] + "|" + locs[2] + "\n";
        boardLayout += "-----------" + "\n";
        boardLayout += locs[3] + "|" + locs[4] + "|" + locs[5] + "\n";
        boardLayout += "-----------" + "\n";
        boardLayout += locs[6] + "|" + locs[7] + "|" + locs[8];

        board.drawBoard();

        verify(printStream).println(boardLayout);
    }

    @Test
    public void shouldDrawXInPositionOneWhenAddingMove(){
        locs[0] = " X ";
        boardLayout = locs[0] + "|" + locs[1] + "|" + locs[2] + "\n";
        boardLayout += "-----------" + "\n";
        boardLayout += locs[3] + "|" + locs[4] + "|" + locs[5] + "\n";
        boardLayout += "-----------" + "\n";
        boardLayout += locs[6] + "|" + locs[7] + "|" + locs[8];

        board.addMove(1, " X ");
        board.drawBoard();

        verify(printStream).println(boardLayout);
    }

    @Test
    public void shouldDrawNothingWhenInvalidInputIsGiven(){
        boardLayout = locs[0] + "|" + locs[1] + "|" + locs[2] + "\n";
        boardLayout += "-----------" + "\n";
        boardLayout += locs[3] + "|" + locs[4] + "|" + locs[5] + "\n";
        boardLayout += "-----------" + "\n";
        boardLayout += locs[6] + "|" + locs[7] + "|" + locs[8];

        board.addMove(-1, " X ");
        board.drawBoard();

        verify(printStream).println(boardLayout);
    }

    @Test
    public void shouldDrawXInPositionOneAndOInPositionTwo(){
        locs[0] = " X ";
        locs[1] = " O ";
        boardLayout = locs[0] + "|" + locs[1] + "|" + locs[2] + "\n";
        boardLayout += "-----------" + "\n";
        boardLayout += locs[3] + "|" + locs[4] + "|" + locs[5] + "\n";
        boardLayout += "-----------" + "\n";
        boardLayout += locs[6] + "|" + locs[7] + "|" + locs[8];

        board.addMove(1, " X ");
        board.addMove(2, " O ");
        board.drawBoard();

        verify(printStream).println(boardLayout);
    }

    @Test
    public void shouldGiveErrorMessageWhenTryingToPlaceInInvalidLocation(){
        String errorMessage = "Invalid Location, please pick somewhere between 1 and 9";

        board.addMove(-1, " X ");

        verify(printStream).println(errorMessage);
    }

    @Test
    public void shouldGiveErrorMessageWhenTryingToPlaceInPositionAlreadyOccupied(){
        String errorMessage = "Location Already Occupied";

        board.addMove(1, " X ");
        board.addMove(1, " O ");

        verify(printStream).println(errorMessage);
    }

    @Test
    public void shouldDisplayDrawWhenAllPositionsAreOccupied(){
    }
}
