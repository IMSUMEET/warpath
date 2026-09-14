package Factory;
import Models.Tile;
import Enums.TileType;

public class TileFactory {
    public static Tile createNewTile(int row, int col, TileType tileType){
        return new Tile(row, col, tileType);
    }
}