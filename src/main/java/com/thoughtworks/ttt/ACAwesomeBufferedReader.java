package com.thoughtworks.ttt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

/**
 * Created by eugenew on 6/18/15.
 */
public class ACAwesomeBufferedReader extends BufferedReader {

    public ACAwesomeBufferedReader(Reader in) {
        super(in);
    }

    @Override
    public String readLine() {
        try{
            return super.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}