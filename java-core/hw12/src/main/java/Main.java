import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Team team = new Team();
        ArrayList<Player> list = team.getAllPlayers();

        team.buildTeam(list);
    }
}
