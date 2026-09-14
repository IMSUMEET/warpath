package Models;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import Interfaces.IOInterface;
import Models.Tile;
import Factory.PieceFactory;
import Factory.TileFactory;
import Enums.TileType;

public class Board {

    private final PieceFactory pieceFactory; 
    private final TileFactory tileFactory;
    private final IOInterface ioInterface;
    
    private Tile[][] board;
    private Tile[] homeTiles;
    private Tile[] portalTiles;
    private Tile victoryTile; 

    Map<Player, List<Piece>> playerToPieceMapping;
    Map<Piece, Tile> pieceToTileMapping;


    public Board(List<Player> players, PieceFactory pieceFactory, TileFactory tileFactory, IOInterface ioInterface){
        this.board = new Tile[5][5];
        this.pieceFactory = pieceFactory;
        this.tileFactory = tileFactory;
        this.ioInterface = ioInterface;

        // set tiletypes for all tiles {}
        // set path -> anticlockwise outer and clockwise inner
        // for 2 players assign opposite side bases
        // for portal tile check condition
        // base to portalTile
        buildBoard();
        homeTiles= new Tile[]{
            board[0][2], board[2][0], board[4][2], board[2][4]
        };

        portalTiles = new Tile[]{
            board[0][3], board[1][0], board[4][1], board[3][4]
        };

        victoryTile = board[2][2];
        setTiles();
    }


    private void buildBoard(){
        for(int row = 0; row < 5; row++){
            for(int col = 0; col < 5; col++){
                this.board[row][col] = tileFactory.createNewTile(row, col, TileType.COMMON);
            }
        }
        ioInterface.write("Build board works...");
        
    }

    private void setTiles(){
        // set home tiles
        ioInterface.write("Setting tiles...");
        for(Tile tile: homeTiles){
            tile.setTileType(TileType.BASE);
        }
        // set portal tiles
        for(Tile tile: portalTiles){
            tile.setTileType(TileType.PORTAL);
        }
        // set victory tile
        this.victoryTile.setTileType(TileType.VICTORY);
        ioInterface.write("Setting tiles done...");
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
            for( int i = 0; i < 4; i++){
                this.pieceFactory.createNewPiece(player.getPieceType());
            }
        }
        // 4 pieces per player
    }

    public void showBoard(){
        ioInterface.write("Board created successfully..");
    }
    
    

}