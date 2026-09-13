package Factory;

import java.util.*;

import Models.Board;
import Models.Player;

public class BoardFactory {
    public Board createNewBoard(List<Player> players){
        return new Board(players);
    }
}