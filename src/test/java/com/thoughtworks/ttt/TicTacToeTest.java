package com.thoughtworks.ttt;

import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by eugenew on 6/18/15.
 */
public class TicTacToeTest {

    @Test
    public void shouldDrawBoardWhenGameStarts(){
        TicTacToe ticTacToe = new TicTacToe();
        PrintStream printStream = mock(PrintStream.class);
        String board = "  |   |\n" +
                "---------\n" +
                "   |   |\n" +
                "---------\n" +
                "   |   |;";
        ticTacToe.drawBoard();

        verify(printStream).println();
    }
}
