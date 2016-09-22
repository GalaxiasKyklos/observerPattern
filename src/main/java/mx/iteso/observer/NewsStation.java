package mx.iteso.observer;

import mx.iteso.observer.impl.ScoresData;
import mx.iteso.observer.impl.SportsMobileDisplay;
import mx.iteso.observer.impl.StoreMonitorDisplay;
import static mx.iteso.observer.Player.NUMPOSITIONS;
import java.util.ArrayList;

public class NewsStation {
    public static void main( String[] args ){
        ScoresData scoresData;
        scoresData = new ScoresData();

        StoreMonitorDisplay storeMonitorDisplay = new StoreMonitorDisplay(scoresData);
        SportsMobileDisplay sportsMobileDisplay=new SportsMobileDisplay(scoresData);

        ArrayList<Player> players = new ArrayList<Player>();
        players.add(new Player(
                "Roberto",
                5,
                NUMPOSITIONS.GOALKEEPER.ordinal(),
                "Tacit Knowledge"
        ));
        players.add(new Player(
                "Link",
                3,
                NUMPOSITIONS.FORWARD.ordinal(),
                "Intel"
        ));
        players.add(new Player(
                "Ganondorf",
                6,
                NUMPOSITIONS.DEFENDER.ordinal(),
                "Tacit Knowledge"
        ));

        scoresData.setScore("Tacit Knowledge", "Intel", 2, 1, players);
        sportsMobileDisplay.stopNotifications();
        players = new ArrayList<Player>();
        players.add(new Player(
                "Chivo",
                3,
                NUMPOSITIONS.FORWARD.ordinal(),
                "Chivas"
        ));
        players.add(new Player(
                "Borrego",
                9,
                NUMPOSITIONS.MIDFIELDER.ordinal(),
                "Chivas"
        ));
        scoresData.setScore("Chivas", "Queretaro", 2, 0, players);

    }
}
