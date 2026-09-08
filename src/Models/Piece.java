package Models;

import Enums.PieceType;

public class Piece {
    private final PieceType pieceType;

    public Piece(PieceType pieceType){
        this.pieceType = pieceType;
    }

    public PieceType getPieceType(){
        return this.pieceType;
    }

    public String getEmote(){
        return this.pieceType.getEmote();
    }
}
