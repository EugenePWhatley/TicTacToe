package com.thoughtworks.ttt;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by eugenew on 6/18/15.
 */
public class TicTacToeTest {

    private PrintStream printStream;
    private TicTacToe ticTacToe;
    private Player p1;
    private Board board;
    private ACAwesomeBufferedReader bufferedReader;


    @Before
    public void setUp(){
        printStream = mock(PrintStream.class);
        bufferedReader = mock(ACAwesomeBufferedReader.class);
        ticTacToe = new TicTacToe(printStream);
        p1 = mock(Player.class);
        board = mock(Board.class);
    }

    @Test
    public void shouldDrawBoardWhenGameStarts(){
        ticTacToe.play();

        verify(board).drawBoard();
    }

    @Test
    public void shouldPromptPlayerOneToMakeMoveWhenGameStarts(){
        String prompt = "Enter a number between 1 and 9 to indicate where you wish to move: ";

        ticTacToe.play();

        verify(printStream).println(prompt);
    }

    @Test
    public void shouldGiveErrorMessageWhenInvalidInput(){
        when(bufferedReader.readLine()).thenReturn("1");
        when(board.addMove(1," ")).thenReturn(false);

        ticTacToe.play();

        verify(printStream).println("Location already taken");
    }
}
