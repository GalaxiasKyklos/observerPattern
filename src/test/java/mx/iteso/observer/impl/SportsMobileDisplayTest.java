package mx.iteso.observer.impl;

import mx.iteso.observer.Player;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.mockito.Mockito.*;


/**
 * Created by Saúl on 23/09/2016.
 */
public class SportsMobileDisplayTest {
    private SportsMobileDisplay sportsMobileDisplay;
    private ScoresData scoresData;
    private ArrayList<Player> players;

    @Before
    public void setUp() {
        scoresData = mock(ScoresData.class);
        sportsMobileDisplay = new SportsMobileDisplay(scoresData);
        players = new ArrayList<Player>();
        players.add(new Player(
                "Name",
                0,
                Player.NUMPOSITIONS.GOALKEEPER.ordinal(),
                "Team"
        ));
    }

    @Test
    public void testUpdate() {
        sportsMobileDisplay.update("homeTeam", "awayTeam", 1, 0, players);
        Assert.assertEquals("Jamaicon Mobile App says \n" +
                "Latest score is:homeTeam (HOME) 1 - awayTeam (AWAY) 0Player:\n" +
                "Name: Name\n" +
                "Number: 0\n" +
                "Position: Goalkeeper\n" +
                "Team: Team", sportsMobileDisplay.display());
    }

    @Test
    public void testStopNotifications() {
        sportsMobileDisplay = mock(new SportsMobileDisplay(scoresData).getClass());
        scoresData.registerObserver(sportsMobileDisplay);
        sportsMobileDisplay.stopNotifications();
        scoresData.setScore("home","js",2,3,players);
        verify(sportsMobileDisplay, times(0)).display();
        //when(scoresData.notifyObservers()).then(sportsMobileDisplay.display());
        //when(sportsMobileDisplay.display()).thenReturn("Llamado");
        //scoresData.notifyObservers();
        //verify(sportsMobileDisplay, times(1)).display();
        //sportsMobileDisplay.stopNotifications();
        //verify(sportsMobileDisplay, times(0)).display();
    }


}
