package Factory;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import Enums.PieceType;
import Enums.TileType;
import Models.Board;
import Models.Faction;
import Models.Piece;
import Models.Tile;

public class BoardFactory {
    private final PieceFactory pieceFactory;
    private final TileFactory tileFactory;
    private final FactionFactory factionFactory;

    private Tile[][] grid;
    private Map<PieceType, Faction> pieceTypeToFactionMapping;

    // public 
    public BoardFactory(PieceFactory pieceFactory, TileFactory tileFactory, FactionFactory factionFactory){
        this.pieceFactory = pieceFactory;
        this.tileFactory = tileFactory;
        this.factionFactory = factionFactory;
        this.grid = new Tile[5][5];
    }

    public Board createNewBoard(List<PieceType> selectedPieceTypes){
        buildGrid();
        this.pieceTypeToFactionMapping = createPieceTypeToFactionMap(selectedPieceTypes);
        return new Board(this.grid, pieceTypeToFactionMapping);
    }

    // private
    private void buildGrid(){
        for(int row = 0; row < 5; row++){
            for(int col = 0; col < 5; col++){
                this.grid[row][col] = tileFactory.createNewTile(row, col, TileType.COMMON);
            }
        }
        int[][] baseTiles = {
            {0, 2}, {2, 0}, {4, 2}, {2, 4} 
        };

        int[][] portalTiles = {
            {0, 3}, {1, 0}, {4, 1}, {3, 4}
        };

        int[][] gatewayTiles = {
            {1, 2}, {2, 1}, {2, 3}, {3, 2}
        };
        
        for(int[] baseTile : baseTiles){
            grid[baseTile[0]][baseTile[1]].setTileType(TileType.BASE);
        }

        for(int[] portalTile : portalTiles){
            grid[portalTile[0]][portalTile[1]].setTileType(TileType.PORTAL);
        }

        for(int[] gatewayTile : gatewayTiles){
            grid[gatewayTile[0]][gatewayTile[1]].setTileType(TileType.GATEWAY);
        }

        grid[2][2].setTileType(TileType.VICTORY);
    }

    private Map<PieceType, Faction> createPieceTypeToFactionMap(List<PieceType> selectedPieceTypes){
        Map<PieceType, Faction> map = new HashMap<>();

        List<int[]> tileCoordinates = new ArrayList<>(List.of(
            new int[]{2, 0, 1, 0, 2, 1}, // left
            new int[]{4, 2, 4, 1, 3, 2}, // bottom
            new int[]{2, 4, 3, 4, 2, 3}, // right
            new int[]{0, 2, 0, 3, 1, 2}  // top
        ));

        Random random = new Random();

        for(PieceType pieceType: selectedPieceTypes){
            
            int index = random.nextInt(tileCoordinates.size());

            int[] coordinates = tileCoordinates.remove(index);

            Tile homeTile = this.grid[coordinates[0]][coordinates[1]];
            Tile portalTile = this.grid[coordinates[2]][coordinates[3]];
            Tile gatewayTile = this.grid[coordinates[4]][coordinates[5]];

            // create map
            Map<Piece, Tile> pieceToTileMapping = new HashMap<>();
            for(int i  = 1; i <= 4; i++){
                Piece piece = pieceFactory.createNewPiece(i, pieceType);
                pieceToTileMapping.put(piece, homeTile);
            }

            Faction faction = factionFactory.createFaction(homeTile, portalTile, gatewayTile, pieceToTileMapping);
            map.put(pieceType, faction);
        }
        
        return map;
    }
}
