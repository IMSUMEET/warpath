package Factory;

import Models.Piece;
import Enums.PieceType;

public class PieceFactory{
    public Piece createNewPiece(PieceType pieceType){
        return new Piece(pieceType);
    }
}