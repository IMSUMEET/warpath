package Models;

import java.util.Map;

public class Faction {
    private final Tile homeTile;
    private final Tile portalTile;
    private final Tile gatewayTile;
    private Map<Piece, Tile> pieceToTileMapping;

    public Faction( Tile homeTile, Tile portalTile, Tile gatewayTile, Map<Piece, Tile> pieceToTileMapping){
        this.homeTile = homeTile;
        this.portalTile = portalTile;
        this.gatewayTile = gatewayTile;
        this.pieceToTileMapping = pieceToTileMapping;
    }

    public Tile getHomeTile(){
        return this.homeTile;
    }

    public Tile getPortalTile(){
        return this.portalTile;
    }

    public Tile getGatewayTile(){
        return this.gatewayTile;
    }

    public Map<Piece, Tile> getCurrentPiecesMapping(){
        return this.pieceToTileMapping;
    }
}
