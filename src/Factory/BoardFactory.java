package Factory;

import java.util.List;

import Models.Board;
import Models.Player;
import Factory.TileFactory;
import Factory.PieceFactory;

public class BoardFactory {
    public Board createNewBoard(List<Player> players, PieceFactory pieceFactory,TileFactory tileFactory){
        return new Board(players, pieceFactory, tileFactory);
    }
}