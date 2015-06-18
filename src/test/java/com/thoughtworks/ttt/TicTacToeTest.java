package com.thoughtworks.ttt;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.times;

/**
 * Created by eugenew on 6/18/15.
 */
public class TicTacToeTest {

    private PrintStream printStream;
    private ACAwesomeBufferedReader bufferedReader;
    private TicTacToe ticTacToe;
    private Player p1;
    private Player p2;
    private Board board;


    @Before
    public void setUp(){
        printStream = mock(PrintStream.class);
        bufferedReader = mock(ACAwesomeBufferedReader.class);
        p1 = mock(Player.class);
        p2 = mock(Player.class);
        board = mock(Board.class);
        when(p1.chooseLocation()).thenReturn(1);
        when(p2.chooseLocation()).thenReturn(2);
        when(bufferedReader.readLine()).thenReturn("1");
        when(board.addMove(1, "X")).thenReturn(true);
        ticTacToe = new TicTacToe(printStream, bufferedReader, board);
    }

    @Test
    public void shouldDrawBoardWhenGameStarts(){
        ticTacToe.play();

        verify(board, times(3)).drawBoard();
    }

    @Test
    public void shouldPromptPlayerOneToMakeMoveWhenGameStarts(){
        String prompt = "Enter a number between 1 and 9 to indicate where you wish to move: ";

        ticTacToe.play();

        verify(printStream, times(2)).println(prompt);
    }

    @Test
    public void shouldDiplayDrawWhenBoardIsFull(){
        ticTacToe.play();

    }
}
