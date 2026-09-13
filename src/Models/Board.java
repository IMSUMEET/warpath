package Models;

import java.util.*;

import Models.Tile;
import Factory.PieceFactory;

public class Board {
    Tile[][] board;
    Map<Player, List<Piece>> playerToPieceMapping;
    Map<Piece, Tile> pieceToTileMapping;
    
    private final PieceFactory pieceFactory; 
    // at a given stage in the game get all the pieces and its pos for a player




    public Board(List<Player> players, PieceFactory pieceFactory){
        this.board = new Tile[5][5];
        this.pieceFactory = PieceFactory;

        // set tiletypes for all tiles {}
        // set path -> anticlockwise outer and clockwise inner
        // for 2 players assign opposite side bases
        // for portal tile check condition
        // base to portalTile
    }

    private void buildBoard(){

        for(int row = 0; row < 5; row++){
            for(int col = 0; col < 5; col++){
                board[row][col] = TileFactory.createNewTile(row, col, TileType.COMMON);
            }
        }

        // setting base tiles
        Tile[] homeTiles = new Tile[]{
            board[0][2], board[2][0], board[4][2], board[2][4]
        };

        for(Tile tile: homeTiles){
            tile.setTileType(TileType.BASE);
        }

        // setting victory tile
        board[2][2].setTileType(TileType.VICTORY);

        // setting portal tiles
        Tile[] portalTiles = new Tile[]{
            board[0][3], board[1][0], board[4][1], board[3][4]
        };
        
        for(Tile tile: portalTiles){
            tile.setTileType(TileType.PORTAL);
        }
    }

    public void setupBoardForPlayers(List<Player> players){
        // player -> name, piecetype
        // number of players = list.size()
        // if 2 players -> place them on random opposite bases, if 3 players, place them randomly
        
        // how to link tile with piece... and then with player
        // relation b/w home and portal tile
        // which piece/player belong to which basetile.
        
        int numPlayer = players.size();
        for(Player player: players){
            pieceFactory.createNewPiece(player.getPieceType());
        }

    }
    
    

}