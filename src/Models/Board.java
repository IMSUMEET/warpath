package Models;

public class Board {
    Tile[][] board;
    Map<Piece, Tile> pieceToTileMapping;

    public Board(List<Player> players){
        this.board = new Tile[5][5];
        // set tiletypes for all tiles
        // set path -> anticlockwise outer and clockwise inner
        // for 2 players assign opposite side bases
        // for portal tile check condition
        // base to portalTile
    }

    // moveNextTile()
}