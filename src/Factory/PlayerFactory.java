package Factory;

import Models.Player;
import Enums.PieceType;

public class PlayerFactory {
    public Player createNewPlayer(String playerName, PieceType pieceType){
        return new Player(playerName, pieceType);
    }
}
