package mx.iteso.observer.impl;

import mx.iteso.observer.Displayable;
import mx.iteso.observer.Observer;
import mx.iteso.observer.Player;
import mx.iteso.observer.Subject;

import java.util.ArrayList;

/**
 * Created by Rodolfo on 22/09/2016.
 */
public class SportsMobileDisplay implements Observer, Displayable{
        private String homeTeam;
        private String awayTeam;
        private int homeGoals;
        private int awayGoals;
        private Subject scoresData;
        private ArrayList<Player> players;

        public SportsMobileDisplay(Subject scoresData){
            this.scoresData = scoresData;
            this.scoresData.registerObserver(this);
        }
        public String display() {
            String ret = "Jamaicon Mobile App says \nLatest score is:";
            ret += homeTeam + " (HOME) " + homeGoals + " - "
                    + awayTeam + " (AWAY) " + awayGoals;
            for (Player player : players) {
                ret += player;
            }
            System.out.println(ret);
            return ret;
        }
        public void update(String home, String away, int homeGoals, int awayGoals, ArrayList<Player> players) {
            this.homeTeam = home;
            this.awayTeam = away;
            this.homeGoals = homeGoals;
            this.awayGoals = awayGoals;
            this.players = players;
            display();
        }
        public void stopNotifications() {
            this.scoresData.removeObserver(this);
        }
        public void renewNotifications() {
            this.scoresData.registerObserver(this);
        }


}
