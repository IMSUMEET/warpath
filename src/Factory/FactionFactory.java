package Factory;

import java.util.Map;

import Models.Faction;
import Models.Piece;
import Models.Tile;

public class FactionFactory {
    public Faction createFaction(Tile homeTile, Tile portalTile, Tile gatewayTile, Map<Piece, Tile> pieceToTileMapping){
        return new Faction(homeTile, portalTile, gatewayTile, pieceToTileMapping);
    }
}
