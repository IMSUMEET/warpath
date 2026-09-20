package Models;

import java.util.*;

import Enums.TileType;

public class Tile{
    private int row;
    private int col;
    private TileType tileType;
    private Set<Piece> piecesOnCurrentTile;

    public Tile(int row, int col, TileType tileType){
        this.row = row;
        this.col = col;
        this.tileType = tileType;
        this.piecesOnCurrentTile = new HashSet<>();
    }

    public int getRow(){
        return this.row;
    }

    public int getCol(){
        return this.col;
    }

    public int[] getPosition(){
        return new int[]{this.row, this.col};
    }

    public TileType getTileType(){
        return this.tileType;
    }

    public void setTileType(TileType tileType){
        this.tileType = tileType;
    }

    // tile has what pieces
    public Set<Piece> getPiecesOnCurrentTile(){
        return this.piecesOnCurrentTile;
    }
    // in the board, check existing pieceTypes and act accordingly
    
}