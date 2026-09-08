package Models;

import Enums.PieceType;

public class Player {
    private final String name;
    private final PieceType pieceType;

    public Player(String name,  PieceType pieceType){
        this.name = name;
        this.pieceType = pieceType;
    }

    public String getPlayerName(){
        return this.name;
    }

    public PieceType getPieceType(){
        return this.pieceType;
    }
}
