import java.util.ArrayList;
import java.util.Random;

public class Team {

    public ArrayList<Player> getAllPlayers(){
        ArrayList<Player> allPlayers = new ArrayList<>();
        allPlayers.add(new Player(23,"Nguyễn Văn Toản",Position.GK));
        allPlayers.add(new Player(19,"Nguyễn Văn Toản",Position.DF));
        allPlayers.add(new Player(8,"Nguyễn Văn Toản",Position.DF));
        allPlayers.add(new Player(2,"Nguyễn Văn Toản",Position.DF));
        allPlayers.add(new Player(3,"Nguyễn Văn Toản",Position.GK));
        allPlayers.add(new Player(10,"Nguyễn Văn Toản",Position.DF));
        allPlayers.add(new Player(11,"Nguyễn Văn Toản",Position.DF));
        allPlayers.add(new Player(12,"Nguyễn Văn Toản",Position.DF));
        allPlayers.add(new Player(4,"Nguyễn Văn Toản",Position.GK));
        allPlayers.add(new Player(5,"Nguyễn Văn Toản",Position.MF));
        allPlayers.add(new Player(6,"Nguyễn Văn Toản",Position.MF));
        allPlayers.add(new Player(7,"Nguyễn Văn Toản",Position.MF));
        allPlayers.add(new Player(13,"Nguyễn Văn Toản",Position.MF));
        allPlayers.add(new Player(17,"Nguyễn Văn Toản",Position.MF));
        allPlayers.add(new Player(21,"Nguyễn Văn Toản",Position.MF));
        allPlayers.add(new Player(22,"Nguyễn Văn Toản",Position.MF));
        allPlayers.add(new Player(18,"Nguyễn Văn Toản",Position.MF));

        return allPlayers;
    }

    public void buildTeam(ArrayList<Player> allPlayers){
        ArrayList<Player> selectedTeam = new ArrayList<>();
        Random rd = new Random();

        //Lấy ra thủ môn

        int gateKeeperSize = 0;
        while (gateKeeperSize<1){
            int rdGateKeeper = rd.nextInt(8);
            if(allPlayers.get(rdGateKeeper).getPosition().equals(Position.GK)){
                selectedTeam.add(allPlayers.get(rdGateKeeper));
                gateKeeperSize++;
            }
        }

        //Lấy ra DF
        int defenderSize = 0;
        while (defenderSize < 4){
            int rdDefender = rd.nextInt(8);
            if(allPlayers.get(rdDefender).getPosition().equals(Position.DF)){
                if(!selectedTeam.contains(allPlayers.get(rdDefender))){
                    selectedTeam.add(allPlayers.get(rdDefender));
                    defenderSize++;
                }
            }
        }

        int defenderSize = 0;
        while (defenderSize < 4){
            int rdDefender = rd.nextInt(8);
            if(allPlayers.get(rdDefender).getPosition().equals(Position.DF)){
                if(!selectedTeam.contains(allPlayers.get(rdDefender))){
                    selectedTeam.add(allPlayers.get(rdDefender));
                    defenderSize++;
                }
            }
        }

        for(Player p : selectedTeam){
            System.out.println(p);
        }
    }
}