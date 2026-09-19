package Factory;

import java.util.List;

import Interfaces.IOInterface;
import Models.Board;
import Models.Player;
import Factory.TileFactory;
import Factory.PieceFactory;

public class BoardFactory {
    private final TileFactory tileFactory;
    private final PieceFactory pieceFactory;

    public BoardFactory(TileFactory tileFactory, PieceFactory pieceFactory){
        this.tileFactory = tileFactory;
        this.pieceFactory = pieceFactory;
    }

    public Board createNewBoard(List<Player> players, IOInterface ioInterface){
        return new Board(players, pieceFactory, tileFactory, ioInterface);
    }
}