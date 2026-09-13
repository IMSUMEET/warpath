package Factory;

class TileFactory {
    public static Tile createNewTile(int row, int col, TileType tileType){
        return new Tile(row, col, tileType);
    }
}