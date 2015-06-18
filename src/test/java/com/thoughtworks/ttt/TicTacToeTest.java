package com.thoughtworks.ttt;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
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

    @Before
    public void setUp(){
        printStream = mock(PrintStream.class);
        ticTacToe = new TicTacToe(printStream);
        p1 = mock(Player.class);

    }

    @Test
    public void shouldDrawBoardWhenGameStarts(){
        String board = "  |   |\n" +
                "---------\n" +
                "  |   |\n" +
                "---------\n" +
                "  |   |";

        ticTacToe.start();

        verify(printStream).println(board);
    }

    @Test
    public void shouldPromptPlayerOneToMakeMoveWhenGameStarts(){
        String prompt = "Enter a number between 1 and 9 to indicate where you wish to move: ";

        ticTacToe.start();

        verify(printStream).println(prompt);
    }

    @Test
    public void shouldRedrawBoardPlacingXInFirstPosition(){
        String board = "X|   |\n" +
                "---------\n" +
                "  |   |\n" +
                "---------\n" +
                "  |   |";

        when(p1.makesMove()).thenReturn(1);

        verify(printStream).println(board);
    }

    @Test
    public void shouldNotRedrawBoardWhenPlayerSelectsNumberGreaterThanNine(){
        String board = "  |   |\n" +
                "---------\n" +
                "  |   |\n" +
                "---------\n" +
                "  |   |";

        when(p1.makesMove()).thenReturn(10);

        verify(printStream).println(board);
    }
}
