package com.thoughtworks.ttt;

import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by eugenew on 6/18/15.
 */
public class PlayerTest {

    private Player p1;
    private ACAwesomeBufferedReader bufferedReader;

    @Before
    public void setUp(){
        bufferedReader = mock(ACAwesomeBufferedReader.class);
        p1 = new Player(bufferedReader);
    }

    @Test
    public void shouldTellBoardToPlaceXInFirstPositionWhenPrompted() {

        when(bufferedReader.readLine()).thenReturn("1");

        assertEquals(p1.chooseLocation(), 1);
    }

    @Test
    public void shouldNotTellBoardAnythingWhenNumberGreaterThanNineIsChose() {

        when(bufferedReader.readLine()).thenReturn("10");

        assertEquals(p1.chooseLocation(), 0);
    }

}