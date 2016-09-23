package mx.iteso.observer.impl;

import mx.iteso.observer.Player;
import static mx.iteso.observer.Player.NUMPOSITIONS;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.mockito.Mockito.mock;


public class StoreMonitorDisplayTest {
    private StoreMonitorDisplay storeMonitorDisplay;
    private ScoresData scoresData;
    private ArrayList<Player> players;

    @Before
    public void setUp() {
        scoresData = mock(ScoresData.class);
        storeMonitorDisplay = new StoreMonitorDisplay(scoresData);
        players = new ArrayList<>();
        players.add(new Player(
                "Name",
                0,
                NUMPOSITIONS.GOALKEEPER.ordinal(),
                "Team"
        ));
    }

    @Test
    public void testUpdate() {
        storeMonitorDisplay.update("homeTeam", "awayTeam", 1, 0, players);
        //Nothing to assert or verify for now
        Assert.assertEquals("Store Monitor says\n" +
                " Latest score is:homeTeam (HOME) 1 - awayTeam (AWAY) 0Player:\n" +
                "Name: Name\n" +
                "Number: 0\n" +
                "Position: Goalkeeper\n" +
                "Team: Team", storeMonitorDisplay.display());
    }
}
