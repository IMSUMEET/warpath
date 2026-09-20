package Models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Enums.PieceType;

public class Board {
    private final Tile[][] grid;
    Map<PieceType, Faction> pieceTypeToFactionMapping;
    private final Map<Tile, List<Piece>> tileToPiecesMapping;

    public Board(Tile[][] grid, Map<PieceType, Faction> pieceTypeToFactionMapping){
        this.grid = grid;
        this.pieceTypeToFactionMapping = pieceTypeToFactionMapping;
        this.tileToPiecesMapping = buildTileToPiecesMapping();
    }

    // Show Method ---- Might use javaFX later
    public void show(){
        String rowSeparator = "├";
        for(int col = 0; col < grid[0].length; col++){
            rowSeparator += "──────────────┤";
        }

        System.out.println();
        System.out.println("  ⚔️  ═══════════  W A R P A T H  ═══════════  ⚔️");
        System.out.println();

        for(int row = 0; row < grid.length; row++){
            System.out.println("  " + rowSeparator);

            StringBuilder line = new StringBuilder("  │");
            for(int col = 0; col < grid[row].length; col++){
                Tile tile = grid[row][col];

                String terrain;
                switch(tile.getTileType()){
                    case BASE:    terrain = "🏰"; break;
                    case PORTAL:  terrain = "🌀"; break;
                    case GATEWAY: terrain = "🚪"; break;
                    case VICTORY: terrain = "👑"; break;
                    default:      terrain = "🟩"; break;
                }

                StringBuilder cell = new StringBuilder(" ").append(terrain);
                List<Piece> pieces = tileToPiecesMapping.get(tile);
                if(pieces != null){
                    for(Piece piece : pieces){
                        cell.append(piece.getEmote()).append(piece.pieceId());
                    }
                }
                while(cell.length() < 14){
                    cell.append(" ");
                }

                line.append(cell).append("│");
            }
            System.out.println(line);
        }
        System.out.println("  " + rowSeparator);

        System.out.println();
        System.out.println("  🟩 Common   🏰 Base   🌀 Portal   🚪 Gateway   👑 Victory");
        System.out.println();
    }

    private Map<Tile, List<Piece>> buildTileToPiecesMapping(){
        Map<Tile, List<Piece>> mapping = new HashMap<>();
        for(Faction faction : pieceTypeToFactionMapping.values()){
            for(Map.Entry<Piece, Tile> entry : faction.getCurrentPiecesMapping().entrySet()){
                mapping.computeIfAbsent(entry.getValue(), tile -> new ArrayList<>()).add(entry.getKey());
            }
        }
        return mapping;
    }
}
