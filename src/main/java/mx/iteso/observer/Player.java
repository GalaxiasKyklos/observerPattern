package mx.iteso.observer;

/**
 * Created by Saúl on 22/09/2016.
 */
public class Player {
    private String name;
    private int number;
    private static final String[] POSITIONS = {
            "Goalkeeper",
            "Defender",
            "Midfielder",
            "Forward"
    };
    private int numPosition;
    private String team;
    public enum NUMPOSITIONS {
        GOALKEEPER,
        DEFENDER,
        MIDFIELDER,
        FORWARD
    };

    public Player(String name, int number, int numPosition, String team) {
        this.name = name;
        this.number = number;
        this.numPosition = numPosition;
        this.team = team;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public String getPosition() {
        return POSITIONS[numPosition];
    }

    public String getTeam() {
        return team;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setNumPosition(int numPosition) {
        this.numPosition = numPosition;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String toString() {
        String ret = "";
        ret += "Name: " + this.getName();
        ret += "\nNumber: " + this.getNumber();
        ret += "\nPosition: " + POSITIONS[numPosition];
        ret += "\nTeam: " + this.getTeam();
        return ret;
    }
}
