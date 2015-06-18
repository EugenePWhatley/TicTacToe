package com.thoughtworks.ttt;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created by eugenew on 6/18/15.
 */
public class Player {
    private ACAwesomeBufferedReader bufferedReader;

    public Player(ACAwesomeBufferedReader bufferedReader) {

        this.bufferedReader = bufferedReader;
    }

    public int makesMove() {
        String move = bufferedReader.readLine();

        return 1;
    }
}
