package Models;

import Enums.PieceType;
import Enums.PieceWeight;


public class Piece {
    private final PieceType pieceType;
    private PieceWeight pieceWeight;

    public Piece(PieceType pieceType){
        this.pieceType = pieceType;
        this.pieceWeight = PieceWeight.SINGLE;
    }

    public PieceType getPieceType(){
        return this.pieceType;
    }

    public String getEmote(){
        return this.pieceType.getEmote();
    }

    public boolean isDoublePiece(){
        return pieceWeight == PieceWeight.DOUBLE;
    }

    public void setDoublePiece(){
        // remove a same SINGLE piece
        this.pieceWeight = PieceWeight.DOUBLE;
    }


}
