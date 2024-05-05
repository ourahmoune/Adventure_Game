package DataGame;

import java.io.Serializable;
import java.util.List;

import Adventure_Game.Continents;
import Player.Player;;

public class GameSave implements Serializable {
    private List<Continents> continentsList;
    private Player player;

    public GameSave(List<Continents> continentsList, Player player) {
        this.continentsList = continentsList;
        this.player = player;
    }
    public List<Continents> getContinentsList() {
        return continentsList;
    }

    public Player getPlayer() {
        return player;
    }

}

