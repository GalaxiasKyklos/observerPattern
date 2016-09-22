package mx.iteso.observer.impl;

import mx.iteso.observer.Observer;
import mx.iteso.observer.Player;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static mx.iteso.observer.Player.NUMPOSITIONS;

public class ScoresDataTest {
    ScoresData scoresData;
    Observer observer;
    ArrayList<Player> players;

    @Before
    public void setUp() {
        scoresData = new ScoresData();
        observer = mock(Observer.class);
        players = new ArrayList<Player>();
        players.add(new Player(
                "Name",
                0,
                NUMPOSITIONS.GOALKEEPER.ordinal(),
                "Team"
        ));
    }

    @Test(expected=ArrayIndexOutOfBoundsException.class)
    public void testRegisterAndRemoveObserver() {
        scoresData.registerObserver(observer);
        scoresData.removeObserver(observer);
        scoresData.removeObserver(observer);
    }

    @Test
    public void testSetScore() {
        scoresData.registerObserver(observer);
        scoresData.registerObserver(observer);
        scoresData.setScore("testTeam", "testTeam2", 1, 0, players);
        verify(observer, times(2)).update("testTeam", "testTeam2", 1, 0, players);
    }
}
